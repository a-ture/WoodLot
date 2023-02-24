package it.unisa.WoodLot.web.control.gestioneOrdine.checkout;

import it.unisa.WoodLot.model.entity.Ordine;
import it.unisa.WoodLot.sevice.gestioneOrdine.checkout.GestioneCheckoutService;
import it.unisa.WoodLot.sevice.gestioneOrdine.eccezioni.OrdineException;
import it.unisa.WoodLot.web.controller.gestioneOrdine.checkout.ControllerCheckout;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test di unità per la classe ControllerCheckout
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerCheckoutUT {
    @Mock
    private GestioneCheckoutService gestioneCheckoutService;
    @InjectMocks
    private ControllerCheckout controllerCheckout;

    /**
     * Testa il caso in cui il checkout viene effettuato correttamente
     * Il test è superato se l'ordine viene effettuato correttamente
     */
    @Test
    void testEffettuareOrdine() throws OrdineException {
        Long idUtente = 123L;
        Ordine expectedOrdine = new Ordine();
        expectedOrdine.setId(456L);

        when(gestioneCheckoutService.effettuareOrdine(idUtente)).thenReturn(expectedOrdine);

        ResponseEntity<Object> response = controllerCheckout.effettuareOrdine(idUtente);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedOrdine, response.getBody());
    }

    /**
     * Testa il caso in cui il checkout fallisce a causa di un errore
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo
     */
    @Test
    void testEffettuareOrdineException() throws OrdineException {
        Long idUtente = 123L;
        Ordine expectedOrdine = new Ordine();
        expectedOrdine.setId(456L);

        when(gestioneCheckoutService.effettuareOrdine(idUtente)).thenThrow(new OrdineException("Errore"));

        ResponseEntity<Object> response = controllerCheckout.effettuareOrdine(idUtente);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
