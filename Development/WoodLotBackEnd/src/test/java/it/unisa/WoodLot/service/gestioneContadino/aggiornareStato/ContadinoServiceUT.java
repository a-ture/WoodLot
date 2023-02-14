package it.unisa.WoodLot.service.gestioneContadino.aggiornareStato;

import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.ProdottoOrdine;
import it.unisa.WoodLot.model.repository.ContadinoRepository;
import it.unisa.WoodLot.model.repository.ProdottoOrdineRepository;
import it.unisa.WoodLot.sevice.gestioneContadino.GestioneContadinoService;
import it.unisa.WoodLot.sevice.gestioneContadino.eccezioni.ContadinoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Test di unità per la classe GestioneContadinoService
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ContadinoServiceUT {
    @MockBean
    private ContadinoRepository contadinoRepository;
    @Mock
    private ProdottoOrdineRepository prodottoOrdineRepository;
    @InjectMocks
    private GestioneContadinoService gestioneContadinoService;

    /**
     * Testa il caso in cui vengono visualizzati l'elenco dei contadini
     * Il test risulta superato se vengono recuperati tutti i contadini
     */
    @Test
    void testGetElencoContadini() {
        Contadino c1 = new Contadino();
        c1.setId(1L);
        c1.setNome("Contadino1");

        Contadino c2 = new Contadino();
        c2.setId(1L);
        c2.setNome("Contadino2");
        List<Contadino> contadini = Arrays.asList(
                c1, c2
        );

        when(contadinoRepository.findAll()).thenReturn(contadini);

        Iterable<Contadino> result = gestioneContadinoService.getElencoContadini();

        assertEquals(contadini, result);
    }

    /**
     * Testa il caso in cui viene visualizzato l'elenco degli alberi che si trovano nello stato: non assegnato
     * Il test risulta superato se vengono recuperati tutti gli alberi che si trovano nello stato: non assegnato
     */
    @Test
    void testGetAlberiNonAssegnati() {
        ProdottoOrdine p1 = new ProdottoOrdine();
        p1.setNomeAlbero("Albero");
        p1.setStato(ProdottoOrdine.Stato.NonAssegnato);
        ProdottoOrdine p2 = new ProdottoOrdine();
        p2.setNomeAlbero("Albero");
        p2.setStato(ProdottoOrdine.Stato.NonAssegnato);

        List<ProdottoOrdine> prodottiOrdine = Arrays.asList(
                p1, p2
        );

        when(prodottoOrdineRepository.findAllByStatoIs(ProdottoOrdine.Stato.NonAssegnato)).thenReturn(prodottiOrdine);

        Iterable<ProdottoOrdine> result = gestioneContadinoService.getAlberiNonAssegnati();

        assertEquals(prodottiOrdine, result);
    }

    /**
     * Testa il caso in cui lo stato dell'albero viene aggiornato con successo
     * Il test risulta superato se lo stato dell'albero viene aggiornato
     */
    @Test
    void testAggiornaStatoSuccesso() {
        ProdottoOrdine prodottoOrdine = new ProdottoOrdine();
        prodottoOrdine.setNomeAlbero("Albero1");
        prodottoOrdine.setStato(ProdottoOrdine.Stato.Bocciolo);
        ProdottoOrdine prodottoOrdineDb = new ProdottoOrdine();
        prodottoOrdineDb.setNomeAlbero("Albero1");
        prodottoOrdineDb.setStato(ProdottoOrdine.Stato.Fiore);

        when(prodottoOrdineRepository.findById(prodottoOrdine.getId())).thenReturn(Optional.of(prodottoOrdineDb));
        when(prodottoOrdineRepository.save(prodottoOrdine)).thenReturn(prodottoOrdine);

        try {
            ProdottoOrdine result = gestioneContadinoService.aggiornaStato(prodottoOrdine);

            assertNotNull(result);
            assertEquals(prodottoOrdine.getId(), result.getId());
            assertEquals(prodottoOrdine.getFrutta(), result.getFrutta());
            assertEquals(prodottoOrdine.getStato(), result.getStato());
            assertEquals(prodottoOrdine.getDescrizione(), result.getDescrizione());

            verify(prodottoOrdineRepository, times(1)).findById(prodottoOrdine.getId());
            verify(prodottoOrdineRepository, times(1)).save(prodottoOrdine);
        } catch (ContadinoException e) {
            fail(e.getMessage());
        }
    }


    /**
     * Testa il caso in cui l'albero di cui si intende aggiornare lo stato non è valido
     * Il test risulta superato se il messaggio d'errore fornito dal sistema è uguale a quello dell'oracolo
     */
    @Test
    void testAggiornaStatoNonTrovato() {
        String messaggio = "Non è stato trovato il prodotto ordine";
        ProdottoOrdine prodottoOrdine = new ProdottoOrdine();
        prodottoOrdine.setNomeAlbero("Albero1");
        prodottoOrdine.setStato(ProdottoOrdine.Stato.Bocciolo);
        when(prodottoOrdineRepository.findById(prodottoOrdine.getId())).thenReturn(Optional.empty());

        try {
            gestioneContadinoService.aggiornaStato(prodottoOrdine);
        } catch (ContadinoException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }
}
