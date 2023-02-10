package it.unisa.WoodLot.service.gestioneOrdine.ordini;

import it.unisa.WoodLot.model.entity.Ordine;
import it.unisa.WoodLot.model.repository.OrdineRepository;
import it.unisa.WoodLot.sevice.gestioneOrdine.ordini.GestioneOrdineService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


/**
 * Test di unità per la classe GestioneOrdineService
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OrdineServiceUT {

    @Mock
    private OrdineRepository ordineRepository;

    @InjectMocks
    private GestioneOrdineService gestioneOrdineService;

    /**
     * Testa il caso in cui vengono visualizzati tutti gli ordini presenti
     */
    @Test
    public void testRestituisciOrdini() {
        List<Ordine> listaOrdini = new ArrayList<>();
        listaOrdini.add(new Ordine());
        listaOrdini.add(new Ordine());

        when(ordineRepository.findAll()).thenReturn(listaOrdini);
        Iterable<Ordine> result = gestioneOrdineService.restituisciOrdini();

        verify(ordineRepository, times(1)).findAll();
        assertNotNull(result);
        assertEquals(listaOrdini, result);
    }

    /**
     * Testa il caso in cui vengono visualizzati gli ordini di un utente
     */
    @Test
    public void testVisualizzaOrdiniUtente() {
        Long idUtente = 1L;
        List<Ordine> listaOrdini = new ArrayList<>();
        listaOrdini.add(new Ordine());
        listaOrdini.add(new Ordine());

        when(ordineRepository.findOrdineByUtente_Id(idUtente)).thenReturn(listaOrdini);
        List<Ordine> result = gestioneOrdineService.visualizzaOrdiniUtente(idUtente);

        verify(ordineRepository, times(1)).findOrdineByUtente_Id(idUtente);
        assertNotNull(result);
        assertEquals(listaOrdini, result);
    }
}
