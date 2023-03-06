package it.unisa.WoodLot.web.control.gestioneContadino.aggiornaStato;

import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.ProdottoOrdine;
import it.unisa.WoodLot.sevice.gestioneContadino.contadino.GestioneContadinoService;
import it.unisa.WoodLot.sevice.gestioneContadino.eccezioni.ContadinoException;
import it.unisa.WoodLot.web.controller.gestioneContadino.ControllerContadino;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

/**
 * Test di unità per la classe ControllerContadino
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerContadinoUT {

    @Mock
    private GestioneContadinoService gestioneContadinoService;
    @InjectMocks
    private ControllerContadino controllerContadino;

    /**
     * Testa il caso in cui si vuole recuperare l'elenco dei contadini
     * Il test è superato se vengono recuperati tutti i contadini
     */
    @Test
    public void testVisualizzaElencoContadini() {
        List<Contadino> contadini = new ArrayList<>();
        Contadino contadino = new Contadino();
        contadino.setNome("contadino");
        contadino.setCognome("Uno");
        contadino.setId(1L);
        contadini.add(contadino);
        contadino.setCognome("Due");
        contadino.setId(2L);

        when(gestioneContadinoService.getElencoContadini()).thenReturn(contadini);

        ResponseEntity<Object> responseEntity = controllerContadino.visualizzaElencoContadini();

        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        assertEquals(contadini, responseEntity.getBody());
    }

    /**
     * Testa il caso in cui si vuole aggiornare lo stato di un albero con successo
     * Il test è superato se lo stato viene aggiornato con successo
     */
    @Test
    void testAggiornaStato() throws ContadinoException {
        ProdottoOrdine prodottoOrdine = new ProdottoOrdine();
        when(gestioneContadinoService.aggiornaStato(prodottoOrdine)).thenReturn(prodottoOrdine);

        ResponseEntity<Object> responseEntity = controllerContadino.aggiornaStato(prodottoOrdine);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(prodottoOrdine, responseEntity.getBody());
    }

    /**
     * Testa il caso in cui si vuole aggiornare lo stato di un albero ma si verifica un errore
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    void testAggiornaStatoException() throws ContadinoException {
        ProdottoOrdine prodottoOrdine = new ProdottoOrdine();
        when(gestioneContadinoService.aggiornaStato(prodottoOrdine)).thenThrow(new ContadinoException("Errore"));

        ResponseEntity<Object> responseEntity = controllerContadino.aggiornaStato(prodottoOrdine);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Errore", ((Map) responseEntity.getBody()).get("data"));
    }

    /**
     * Testa il caso in cui si vuole recuperare l'elenco degli alberi che si trovano nello stato non assegnato
     * Il test è superato se vengono recuperati tutti gli alberi
     */
    @Test
    void testElencoAlberiNonAssegnati() {
        ProdottoOrdine albero1 = new ProdottoOrdine();
        albero1.setId(1L);
        albero1.setNomeAlbero("Albero 1");
        ProdottoOrdine albero2 = new ProdottoOrdine();
        albero2.setId(2L);
        albero2.setNomeAlbero("Albero 2");
        when(gestioneContadinoService.getAlberiNonAssegnati()).thenReturn(Arrays.asList(albero1, albero2));

        ResponseEntity<Object> responseEntity = controllerContadino.elencoAlberiNonAssegnati();

        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());

        assertEquals(Arrays.asList(albero1, albero2), responseEntity.getBody());
    }

    /**
     * Testa il caso in cui si vuole recuperare l'elenco degli alberi che si trovano nello stato revisione
     * Il test è superato se vengono recuperati tutti gli alberi
     */
    @Test
    void testElencoAlberiDaRevisionare() {
        ProdottoOrdine albero1 = new ProdottoOrdine();
        albero1.setId(1L);
        albero1.setNomeAlbero("Albero 1");
        ProdottoOrdine albero2 = new ProdottoOrdine();
        albero2.setId(2L);
        albero2.setNomeAlbero("Albero 2");
        when(gestioneContadinoService.prodottiDaRevisionare()).thenReturn(Arrays.asList(albero1, albero2));

        ResponseEntity<Object> responseEntity = controllerContadino.elencoAlberiDaRevisionare();

        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());

        assertEquals(Arrays.asList(albero1, albero2), responseEntity.getBody());
    }

    /**
     * Testa il caso in cui si vuole recuperare l'elenco degli alberi che si trovano nello stato riassegnazione
     * Il test è superato se vengono recuperati tutti gli alberi
     */
    @Test
    void testElencoAlberiDaRiassegnare() {
        ProdottoOrdine albero1 = new ProdottoOrdine();
        albero1.setId(1L);
        albero1.setNomeAlbero("Albero 1");
        ProdottoOrdine albero2 = new ProdottoOrdine();
        albero2.setId(2L);
        albero2.setNomeAlbero("Albero 2");
        when(gestioneContadinoService.prodottiDaRiassegnare()).thenReturn(Arrays.asList(albero1, albero2));

        ResponseEntity<Object> responseEntity = controllerContadino.elencoAlberiDaRiassegnare();

        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());

        assertEquals(Arrays.asList(albero1, albero2), responseEntity.getBody());
    }

    /**
     * Testa il caso in cui si vuole aggiungere una foto
     * Il test è superato se viene aggiunto il file
     */
    @Test
    void testUploadImage() throws IOException {
        byte[] content = "test file content".getBytes();
        MockMultipartFile file = new MockMultipartFile("file", "test.jpg", "image/jpeg", content);
        ResponseEntity<Object> responseEntity = controllerContadino.uploadImage(file, "1");

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    /**
     * Testa il caso in cui si vuole rimuovere una foto
     * Il test è superato se viene eliminato il file
     */
    @Test
    void testDeleteImage() throws IOException {
        String prodottoId = "1";
        String contadinoId = "2";
        String DELETE_DIR = "/Users/alessiature/Desktop/WoodLot/Development/WoodLotFrontEnd/src/assets/img/alberiUtente/"
                + contadinoId + "/" + prodottoId + ".jpeg";
        File file = new File(DELETE_DIR);

        file.createNewFile();
        ResponseEntity<Object> responseEntity = controllerContadino.deleteImage(prodottoId, contadinoId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        assertFalse(file.exists());
    }

    /**
     * Testa il caso in cui si vuole recuperare l'elenco degli alberi di un contadino
     * Il test è superato se vengono recuperati tutti gli alberi
     */
    @Test
    void testRestituisceAlberiContadino() {
        Long idContadino = 1L;
        List<ProdottoOrdine> alberiContadino = new ArrayList<>();
        ProdottoOrdine albero1 = new ProdottoOrdine();
        albero1.setId(1L);
        albero1.setNomeAlbero("Albero 1");
        alberiContadino.add(albero1);
        ProdottoOrdine albero2 = new ProdottoOrdine();
        albero2.setId(2L);
        albero2.setNomeAlbero("Albero 2");
        alberiContadino.add(albero2);
        Mockito.when(gestioneContadinoService.elencoAlberiContadino(idContadino)).thenReturn(alberiContadino);
        ResponseEntity<Object> responseEntity = controllerContadino.restituisceAlberiContadino(idContadino);
        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        List<ProdottoOrdine> result = (List<ProdottoOrdine>) responseEntity.getBody();
        assertEquals(alberiContadino.size(), result.size());
        assertEquals(albero1.getId(), result.get(0).getId());
        assertEquals(albero1.getNomeAlbero(), result.get(0).getNomeAlbero());
        assertEquals(albero2.getId(), result.get(1).getId());
        assertEquals(albero2.getNomeAlbero(), result.get(1).getNomeAlbero());
    }
}