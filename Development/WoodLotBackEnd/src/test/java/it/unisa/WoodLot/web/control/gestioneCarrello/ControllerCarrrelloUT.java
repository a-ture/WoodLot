package it.unisa.WoodLot.web.control.gestioneCarrello;

import it.unisa.WoodLot.model.entity.Carrello;
import it.unisa.WoodLot.sevice.gestioneCarrello.GestioneCarrelloService;
import it.unisa.WoodLot.sevice.gestioneCarrello.eccezzioni.CarrelloException;
import it.unisa.WoodLot.web.controller.gestioneCarrello.ControllerCarrello;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * Test di unità per la classe ControllerCarrello
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerCarrrelloUT {
    @Mock
    private GestioneCarrelloService gestioneCarrelloService;
    @InjectMocks
    private ControllerCarrello controller;

    /**
     * Testa il caso in cui viene aggiunto un prodotto al carrello con successo
     * <p>
     * Il test è superato se il prodotto viene aggiunto con successo
     */
    @Test
    void testAggiungiProdotto() {
        Long idCarrello = 1L;
        String nomeAlbero = "Avocado";
        Carrello carrello = new Carrello();
        carrello.setId(idCarrello);

        try {
            when(gestioneCarrelloService.aggiungiProdotto(idCarrello, nomeAlbero)).thenReturn(carrello);
        } catch (CarrelloException e) {
            fail(e.getMessage());
        }

        ResponseEntity<Object> response = controller.aggiungiProdotto(nomeAlbero, idCarrello);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(carrello, response.getBody());
    }

    /**
     * Testa il caso in cui si vuole aggiungere un prodotto al carrello ma si verifica un eccezione
     * <p>
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    void testAggiungiProdottoWithException() {
        Long idCarrello = 1L;
        String nomeAlbero = "Pino";
        String errorMessage = "Errore durante l'aggiunta del prodotto al carrello";

        try {
            when(gestioneCarrelloService.aggiungiProdotto(idCarrello, nomeAlbero)).thenThrow(new CarrelloException(errorMessage));
        } catch (CarrelloException e) {
            fail(e.getMessage());
        }

        ResponseEntity<Object> response = controller.aggiungiProdotto(nomeAlbero, idCarrello);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(errorMessage, ((Map) response.getBody()).get("data"));
    }

    /**
     * Testa il caso in cui il carrello viene svuotato con successo
     * <p>
     * Il test è superato se il carrello viene svuotato con successo
     */
    @Test
    void testSvuotareCarrello() {
        Long idCarrello = 1L;
        Carrello carrello = new Carrello();

        try {
            when(gestioneCarrelloService.svuotareCarrello(idCarrello)).thenReturn(carrello);
        } catch (CarrelloException e) {
            fail(e.getMessage());
        }

        ResponseEntity<Object> response = controller.svuotareCarrello(idCarrello);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(carrello, response.getBody());
    }

    /**
     * Testa il caso in cui si vuole svuotare il carrello ma si verifica un eccezione
     * <p>
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    void testSvuotareCarrelloWithException() throws CarrelloException {
        Long idCarrello = 1L;
        String errorMessage = "Carrello non trovato";

        doThrow(new CarrelloException(errorMessage)).when(gestioneCarrelloService).svuotareCarrello(idCarrello);

        ResponseEntity<Object> response = controller.svuotareCarrello(idCarrello);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(errorMessage, ((Map<String, String>) response.getBody()).get("data"));
    }

    /**
     * Testa il caso in cui un prodotto viene rimosso con un successo
     * <p>
     * Il prodotto viene eliminato
     */
    @Test
    void testRimuoviProdotto() {
        Long idCarrello = 1L;
        Long idProdottoCarrello = 2L;
        Carrello carrello = new Carrello();
        try {
            when(gestioneCarrelloService.rimuoviProdotto(idCarrello, idProdottoCarrello)).thenReturn(carrello);
        } catch (CarrelloException e) {
            fail(e.getMessage());
        }

        ResponseEntity<Object> response = controller.rimuoviProdotto(idCarrello, idProdottoCarrello);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(carrello, response.getBody());
    }

    /**
     * Testa il caso in cui si vuole rimuovere un prodotto dal carrello ma si verifica un eccezione
     * <p>
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    void testRimuoviProdottoWithException() throws CarrelloException {
        Long idCarrello = 1L;
        Long idProdottoCarrello = 2L;
        String errorMessage = "Errore durante la rimozione del prodotto dal carrello";

        doThrow(new CarrelloException(errorMessage)).when(gestioneCarrelloService).rimuoviProdotto(idCarrello, idProdottoCarrello);

        ResponseEntity<Object> response = controller.rimuoviProdotto(idCarrello, idProdottoCarrello);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(errorMessage, ((Map<String, String>) response.getBody()).get("data"));
    }

    /**
     * Testa il caso in cui il recupero del carrello di un utente avviene con successo
     * <p>
     * Il test è superato se il carrello viene visualizzato con successo
     */
    @Test
    void testVisualizzaCarrello() {
        Long idUtente = 1L;
        Carrello carrello = new Carrello();
        try {
            when(gestioneCarrelloService.getCarrello(idUtente)).thenReturn(carrello);
        } catch (CarrelloException e) {
            fail(e.getMessage());
        }

        ResponseEntity<Object> response = controller.visualizzaCarrello(idUtente);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(carrello, response.getBody());
    }

    /**
     * Testa il caso in cui si vuole visualizzare un carrello ma si verifica un eccezione
     * <p>
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    void testVisualizzaCarrelloWithException() throws CarrelloException {
        Long idCarrello = 1L;
        String errorMessage = "Errore durante la visualizzazione del prodotto dal carrello";

        doThrow(new CarrelloException(errorMessage)).when(gestioneCarrelloService).getCarrello(idCarrello);

        ResponseEntity<Object> response = controller.visualizzaCarrello(idCarrello);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(errorMessage, ((Map<String, String>) response.getBody()).get("data"));
    }
}