package it.unisa.WoodLot.web.control.gestioneStatistiche;

import it.unisa.WoodLot.sevice.gestioneStatistiche.GestioneStatisticheService;
import it.unisa.WoodLot.web.controller.gestioneStatistiche.ControllerStatistiche;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Test di unità per la classe ControllerStatistiche
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerStatisticheUT {
    @Mock
    private GestioneStatisticheService gestioneStatisticheService;
    @InjectMocks
    private ControllerStatistiche controllerStatistiche;

    @Test
    void testVisualizzaStatisticheUtente() {
        ArrayList<Double> statistiche = new ArrayList<>(2);

        when(gestioneStatisticheService.statistichePaginaUtente(1L)).thenReturn(statistiche);

        ResponseEntity<Object> response = controllerStatistiche.visualizzaStatisticheUtente(1L);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testVisualizzaStatisticheResponsabile() {
        ArrayList<Double> statistiche = new ArrayList<>(2);

        when(gestioneStatisticheService.statistichePaginaResponsabileCatalogo()).thenReturn(statistiche);

        ResponseEntity<Object> response = controllerStatistiche.visualizzaStatisticheResponsabile();

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testStatistichePaginaContadino() {
        ArrayList<Double> statistiche = new ArrayList<>(2);

        when(gestioneStatisticheService.statistichePaginaContadino(1L)).thenReturn(statistiche);

        ResponseEntity<Object> response = controllerStatistiche.visualizzaStatisticheContadino(1L);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testStatistichePaginaResponsabileOrdini() {
        ArrayList<Double> statistiche = new ArrayList<>(2);

        when(gestioneStatisticheService.statistichePaginaResponsabileOrdini()).thenReturn(statistiche);

        ResponseEntity<Object> response = controllerStatistiche.visualizzaStatisticheOrdini();

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}
