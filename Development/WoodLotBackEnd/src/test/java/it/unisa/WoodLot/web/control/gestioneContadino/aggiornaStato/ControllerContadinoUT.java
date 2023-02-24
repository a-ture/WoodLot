package it.unisa.WoodLot.web.control.gestioneContadino.aggiornaStato;

import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.ProdottoOrdine;
import it.unisa.WoodLot.sevice.gestioneContadino.GestioneContadinoService;
import it.unisa.WoodLot.sevice.gestioneContadino.eccezioni.ContadinoException;
import it.unisa.WoodLot.web.controller.gestioneContadino.ControllerContadino;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
     * Testa il caso in cui si vuole recuperare l'elenco degli alberi che si trovano nello stato non assegnato
     * Il test è superato se vengono recuperati tutti gli alberi
     */
    @Test
    public void testElencoAlberiNonAssegnati() {
        List<ProdottoOrdine> alberiNonAssegnati = new ArrayList<>();
        ProdottoOrdine albero = new ProdottoOrdine();
        albero.setStato(ProdottoOrdine.Stato.NonAssegnato);
        albero.setId(2L);
        alberiNonAssegnati.add(albero);
        albero.setId(1L);
        alberiNonAssegnati.add(albero);

        when(gestioneContadinoService.getAlberiNonAssegnati()).thenReturn(alberiNonAssegnati);

        ResponseEntity<Object> response = controllerContadino.elencoAlberiNonAssegnati();

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(alberiNonAssegnati, response.getBody());
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
}