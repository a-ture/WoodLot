package it.unisa.WoodLot.web.control.gestioneOrdine.ordini;

import it.unisa.WoodLot.model.entity.Ordine;
import it.unisa.WoodLot.sevice.gestioneOrdine.ordini.GestioneOrdineService;
import it.unisa.WoodLot.web.controller.gestioneOrdine.ordini.ControllerOrdini;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test di unità per la classe ControllerOrdini
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerOrdiniUT {

    @Mock
    private GestioneOrdineService gestioneOrdineService;
    @InjectMocks
    private ControllerOrdini controllerOrdini;

    /**
     * Testa il caso in cui viene recuperato l'elenco degli ordini effettuati
     * Il test risulta superato se vengono recuperati tutti gli ordini
     */
    @Test
    void testRestituisciOrdini() {
        List<Ordine> ordini = new ArrayList<>();
        Ordine ordine1 = new Ordine();
        ordine1.setId(1L);
        Ordine ordine2 = new Ordine();
        ordine2.setId(2L);
        ordini.add(ordine1);
        ordini.add(ordine2);

        when(gestioneOrdineService.restituisciOrdini()).thenReturn(ordini);

        ResponseEntity<Object> responseEntity = controllerOrdini.restituisciOrdini();

        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        assertEquals(2, ((List<Ordine>) responseEntity.getBody()).size());
    }

    /**
     * Testa il caso in cui viene recuperato l'elenco degli ordini effettuati da un utente
     * Il test risulta superato se vengono recuperati tutti gli ordini
     */
    @Test
    void testVisualizzaOrdiniUtente() {
        Long idUtente = 1L;
        List<Ordine> ordini = new ArrayList<>();
        ordini.add(new Ordine());
        when(gestioneOrdineService.visualizzaOrdiniUtente(idUtente)).thenReturn(ordini);

        ResponseEntity<Object> response = controllerOrdini.visualizzaOrdiniUtente(idUtente);
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(ordini, response.getBody());
    }
}