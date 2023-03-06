package it.unisa.WoodLot.service.gestioneContadino.contadino;

import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.ProdottoOrdine;
import it.unisa.WoodLot.model.repository.ContadinoRepository;
import it.unisa.WoodLot.model.repository.ProdottoOrdineRepository;
import it.unisa.WoodLot.sevice.gestioneContadino.contadino.GestioneContadinoService;
import it.unisa.WoodLot.sevice.gestioneContadino.eccezioni.ContadinoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
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
    public void testAggiornaStatoSuccesso() {
        ProdottoOrdine prodottoOrdine = new ProdottoOrdine();
        prodottoOrdine.setId(1L);
        prodottoOrdine.setNomeAlbero("Albero1");
        prodottoOrdine.setStato(ProdottoOrdine.Stato.Bocciolo);

        ProdottoOrdine prodottoOrdineDb = new ProdottoOrdine();
        prodottoOrdineDb.setId(1L);
        prodottoOrdineDb.setNomeAlbero("Albero1");
        prodottoOrdineDb.setStato(ProdottoOrdine.Stato.Fiore);

        when(prodottoOrdineRepository.findById(prodottoOrdine.getId())).thenReturn(Optional.of(prodottoOrdineDb));
        when(prodottoOrdineRepository.save(any(ProdottoOrdine.class))).thenReturn(prodottoOrdine);

        try {
            ProdottoOrdine result = gestioneContadinoService.aggiornaStato(prodottoOrdine);

            Assertions.assertNotNull(result);
            Assertions.assertEquals(prodottoOrdine.getId(), result.getId());
            Assertions.assertEquals(prodottoOrdine.getFrutta(), result.getFrutta());
            Assertions.assertEquals(prodottoOrdine.getStato(), result.getStato());
            Assertions.assertEquals(prodottoOrdine.getDescrizione(), result.getDescrizione());

            verify(prodottoOrdineRepository, times(1)).findById(prodottoOrdine.getId());
            verify(prodottoOrdineRepository, times(1)).save(any(ProdottoOrdine.class));
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

    /**
     * Testa il caso in cui si vuole recuperare l'elenco degli alberi di un contadino
     * Il test risulta superato se vengono recuperati gli alberi del contadino
     */
    @Test
    void elencoAlberiContadinoTest() {
        Long idContadino = 1L;
        ProdottoOrdine prodottoOrdine1 = new ProdottoOrdine();
        prodottoOrdine1.setId(1L);
        prodottoOrdine1.setNomeAlbero("Olivo");
        prodottoOrdine1.setContadino(new Contadino());
        prodottoOrdine1.getContadino().setId(idContadino);
        ProdottoOrdine prodottoOrdine2 = new ProdottoOrdine();
        prodottoOrdine2.setId(2L);
        prodottoOrdine2.setNomeAlbero("Mandorlo");
        prodottoOrdine2.setContadino(new Contadino());
        prodottoOrdine2.getContadino().setId(2L);
        List<ProdottoOrdine> prodottiOrdine = new ArrayList<>();
        prodottiOrdine.add(prodottoOrdine1);
        prodottiOrdine.add(prodottoOrdine2);

        when(prodottoOrdineRepository.findAllByContadino_Id(idContadino)).thenReturn((ArrayList<ProdottoOrdine>) prodottiOrdine);

        Iterable<ProdottoOrdine> result = gestioneContadinoService.elencoAlberiContadino(idContadino);

        assertEquals(prodottiOrdine, result);
    }

    /**
     * Testa il caso in cui si vuole recuperare l'elenco degli alberi che sono in Stato Revisione
     * Il test risulta superato se vengono recuperati gli alberi
     */
    @Test
    public void testProdottiDaRevisionare() {
        // definiamo i dati di test
        ProdottoOrdine prodotto1 = new ProdottoOrdine();
        prodotto1.setId(1L);
        prodotto1.setStato(ProdottoOrdine.Stato.Riassegnazione);
        ProdottoOrdine prodotto2 = new ProdottoOrdine();
        prodotto2.setId(2L);
        prodotto2.setStato(ProdottoOrdine.Stato.Revisione);
        List<ProdottoOrdine> prodotti = Arrays.asList(prodotto1, prodotto2);

        when(prodottoOrdineRepository.findAllByStatoIs(ProdottoOrdine.Stato.Revisione)).thenReturn(prodotti);

        Iterable<ProdottoOrdine> result = gestioneContadinoService.prodottiDaRevisionare();

        assertEquals(prodotti, result);
    }

    /**
     * Testa il caso in cui si vuole recuperare l'elenco degli alberi che sono in Stato Riassegnazione
     * Il test risulta superato se vengono recuperati gli alberi
     */
    @Test
    void testProdottiDaRiassegnare() {
        ProdottoOrdine prodotto1 = new ProdottoOrdine();
        prodotto1.setStato(ProdottoOrdine.Stato.Riassegnazione);

        ProdottoOrdine prodotto2 = new ProdottoOrdine();
        prodotto2.setStato(ProdottoOrdine.Stato.Riassegnazione);

        when(prodottoOrdineRepository.findAllByStatoIs(ProdottoOrdine.Stato.Riassegnazione))
                .thenReturn(Arrays.asList(prodotto1, prodotto2));

        Iterable<ProdottoOrdine> prodottiRiassegnazione = gestioneContadinoService.prodottiDaRiassegnare();

        assertThat(prodottiRiassegnazione).hasSize(2);
        assertThat(prodottiRiassegnazione).contains(prodotto1);
        assertThat(prodottiRiassegnazione).contains(prodotto2);
    }
}
