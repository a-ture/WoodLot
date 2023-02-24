package it.unisa.WoodLot.web.control.gestioneCatalogo.catalogo;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.sevice.gestioneCatalogo.catalogo.GestioneCatalogoService;
import it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni.AlberoException;
import it.unisa.WoodLot.web.controller.gestioneCatalogo.catalogo.ControllerCatalogo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test di unità per la classe ControllerCatalogo
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerCatalogoUT {
    @Mock
    private GestioneCatalogoService gestioneCatalogoService;
    @InjectMocks
    private ControllerCatalogo controllerCatalogo;

    /**
     * Testa il caso in cui l'albero viene aggiunto con successo al catalogo
     * <p>
     * Il test risulta superato se il prodotto viene aggiunto con successo al catalogo
     */
    @Test
    void testInserimentoCatalogo() {
        Albero albero = new Albero();
        albero.setNome("Pino");
        albero.setDescrizione("Albero di Natale");
        albero.setPrezzo(50.0);

        try {
            when(gestioneCatalogoService.aggiungiProdotto(albero)).thenReturn(albero);
        } catch (AlberoException e) {
            fail(e.getMessage());
        }

        ResponseEntity<Object> response = controllerCatalogo.inserimentoCatalogo(albero);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(albero, response.getBody());
    }

    /**
     * Testa il caso in cui si vuole aggiungere un albero al catalogo ma si verifica un eccezione
     * <p>
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * *previsto dall'oracolo.
     */
    @Test
    void testInserimentoCatalogoWithException() throws AlberoException {
        Albero albero = new Albero();
        albero.setNome("Pino");
        albero.setPrezzo(-50.0);
        String messaggio = "Il prezzo del prodotto non può essere negativo";

        when(gestioneCatalogoService.aggiungiProdotto(albero)).thenThrow(new AlberoException(messaggio));

        ResponseEntity<Object> response = controllerCatalogo.inserimentoCatalogo(albero);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(messaggio, ((Map<String, String>) response.getBody()).get("data"));
    }

    /**
     * Testa il caso in cui il prodotto viene eliminato correttamente
     * Il test risulta superato se il prodotto viene eliminato correttamente
     */
    @Test
    void testEliminaProdottoCatalogo() {
        String idAlbero = "pino";

        assertDoesNotThrow(() -> controllerCatalogo.eliminaProdottoCatalogo(idAlbero));
    }

}
