package it.unisa.WoodLot.service.gestioneStatistiche;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.ContadinoRepository;
import it.unisa.WoodLot.model.repository.OrdineRepository;
import it.unisa.WoodLot.model.repository.PaeseOrigineRepository;
import it.unisa.WoodLot.model.repository.ProdottoOrdineRepository;
import it.unisa.WoodLot.sevice.gestioneStatistiche.GestioneStatisticheService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test di unità per la classe GestioneStatisticheService
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StatisticheServiceUT {
    @Mock
    private OrdineRepository ordineRepository;
    @Mock
    private ContadinoRepository contadinoRepository;
    @Mock
    private PaeseOrigineRepository paeseOrigineRepository;
    @InjectMocks
    private GestioneStatisticheService gestioneStatisticheService;
    @Mock
    private ProdottoOrdineRepository prodottoOrdineRepository;

    /**
     * Testa la visualizzazione delle statistiche per la pagina dell'utente
     * Il test risulta superato se le statistiche corrispondo all'oracolo
     */
    @Test
    public void testStatistichePaginaUtente() {
        Long idUtente = 1L;
        Ordine ordine = new Ordine();
        ProdottoOrdine prodottoOrdine = new ProdottoOrdine();
        prodottoOrdine.setAnidrideCarbonicaAssorbita(1000);
        List<ProdottoOrdine> prodottoOrdineList = new ArrayList<>();
        prodottoOrdineList.add(prodottoOrdine);
        ordine.setProdottiOrdine(prodottoOrdineList);
        List<Ordine> ordineList = new ArrayList<>();
        ordineList.add(ordine);

        when(ordineRepository.findOrdineByUtente_Id(idUtente)).thenReturn(ordineList);

        Iterable<Double> result = gestioneStatisticheService.statistichePaginaUtente(idUtente);

        Iterable<Double> statistiche = gestioneStatisticheService.statistichePaginaUtente(idUtente);
        Double[] statisticheArray = StreamSupport.stream(statistiche.spliterator(), false)
                .toArray(Double[]::new);

        // Verifica del risultato
        assertEquals(2, statisticheArray.length);
        assertEquals(1.0, statisticheArray[0]);
        assertEquals(1000, statisticheArray[1]);
    }

    /**
     * Testa la visualizzazione delle statistiche per la pagina del responsabile catalogo
     * Il test risulta superato se le statistiche corrispondo all'oracolo
     */
    @Test
    public void testStatistichePaginaResponsabileCatalogo() {
        Utente utente = new Utente();

        List<Ordine> ordini = new ArrayList<>();
        Ordine ordine1 = new Ordine();
        ordine1.setDataOrdine(LocalDate.from(LocalDateTime.now()));
        ordine1.setUtente(utente);
        ordine1.setId(56L);

        ProdottoOrdine prodottoOrdine = new ProdottoOrdine();
        prodottoOrdine.setStato(ProdottoOrdine.Stato.NonAssegnato);
        prodottoOrdine.setNomeAlbero("Castagno");
        prodottoOrdine.setAnidrideCarbonicaAssorbita(345);
        ordine1.aggiungiProdotto(prodottoOrdine);

        Ordine ordine2 = new Ordine();
        ordine2.setDataOrdine(LocalDate.from(LocalDateTime.now()));
        ordine2.setUtente(utente);
        ordine2.setId(57L);

        ProdottoOrdine prodottoOrdine1 = new ProdottoOrdine();
        prodottoOrdine1.setStato(ProdottoOrdine.Stato.NonAssegnato);
        prodottoOrdine1.setNomeAlbero("Castagno");
        prodottoOrdine1.setAnidrideCarbonicaAssorbita(345);
        ordine2.aggiungiProdotto(prodottoOrdine1);

        ordini.add(ordine1);
        ordini.add(ordine2);

        Contadino contadino = new Contadino();
        Contadino contadino1 = new Contadino();

        PaeseOrigine paeseOrigine = new PaeseOrigine();
        PaeseOrigine paeseOrigine1 = new PaeseOrigine();

        when(ordineRepository.findAll()).thenReturn(ordini);
        when(contadinoRepository.findAll()).thenReturn(Arrays.asList(contadino1, contadino));
        when(paeseOrigineRepository.findAll()).thenReturn(Arrays.asList(paeseOrigine1, paeseOrigine));

        Iterable<Double> result = gestioneStatisticheService.statistichePaginaResponsabileCatalogo();
        List<Double> resultList = new ArrayList<>();
        result.forEach(resultList::add);

        assertEquals(4, resultList.size());
        // verifica che i valori restituiti siano corretti
        assertEquals(2, resultList.get(0), 0.01);
        assertEquals(690, resultList.get(1), 0.01);
        assertEquals(2, resultList.get(2), 0.01);
        assertEquals(2, resultList.get(3), 0.01);
    }

    /**
     * Testa la visualizzazione delle statistiche per la pagina del contadino
     * Il test risulta superato se le statistiche corrispondo all'oracolo
     */
    @Test
    public void testStatistichePaginaContadino() {
        ProdottoOrdine prodotto1 = new ProdottoOrdine();
        prodotto1.setFrutta(10.0);
        prodotto1.setAnidrideCarbonicaAssorbita(200);

        ProdottoOrdine prodotto2 = new ProdottoOrdine();
        prodotto2.setFrutta(15.0);
        prodotto2.setAnidrideCarbonicaAssorbita(250);

        ArrayList<ProdottoOrdine> prodotti = new ArrayList<>();
        prodotti.add(prodotto1);
        prodotti.add(prodotto2);

        when(prodottoOrdineRepository.findAllByContadino_Id(1L)).thenReturn(prodotti);

        Iterable<Double> result = gestioneStatisticheService.statistichePaginaContadino(1L);

        List<Double> expected = Arrays.asList(450.0, 25.0, 2.0);
        assertEquals(expected, result);
    }

    /**
     * Testa la visualizzazione delle statistiche per la pagina del responsabile degli ordini
     * Il test risulta superato se le statistiche corrispondo all'oracolo
     */
    @Test
    public void testStatistichePaginaResponsabileOrdini() {
        Utente utente = new Utente();

        List<Ordine> ordini = new ArrayList<>();
        Ordine ordine1 = new Ordine();
        ordine1.setDataOrdine(LocalDate.from(LocalDateTime.now()));
        ordine1.setUtente(utente);
        ordine1.setId(56L);

        ProdottoOrdine prodottoOrdine = new ProdottoOrdine();
        prodottoOrdine.setStato(ProdottoOrdine.Stato.NonAssegnato);
        prodottoOrdine.setNomeAlbero("Castagno");
        prodottoOrdine.setAnidrideCarbonicaAssorbita(345);
        ordine1.aggiungiProdotto(prodottoOrdine);

        Ordine ordine2 = new Ordine();
        ordine2.setDataOrdine(LocalDate.from(LocalDateTime.now()));
        ordine2.setUtente(utente);

        ordine2.setId(57L);

        ProdottoOrdine prodottoOrdine1 = new ProdottoOrdine();
        prodottoOrdine1.setStato(ProdottoOrdine.Stato.NonAssegnato);
        prodottoOrdine1.setNomeAlbero("Castagno");
        prodottoOrdine1.setAnidrideCarbonicaAssorbita(345);
        ordine2.aggiungiProdotto(prodottoOrdine1);

        ArrayList<ProdottoOrdine> prodotti = new ArrayList<>();
        prodotti.add(prodottoOrdine);
        prodotti.add(prodottoOrdine1);

        ordini.add(ordine1);
        ordini.add(ordine2);

        PaeseOrigine paeseOrigine = new PaeseOrigine();
        PaeseOrigine paeseOrigine1 = new PaeseOrigine();

        List<PaeseOrigine> listPaesi = Arrays.asList(
                paeseOrigine1, paeseOrigine
        );

        Contadino contadino = new Contadino();
        Contadino contadino1 = new Contadino();

        List<Contadino> listContadini = Arrays.asList(
                contadino1, contadino
        );

        when(ordineRepository.findAll()).thenReturn(ordini);
        when(contadinoRepository.findAll()).thenReturn(Arrays.asList(contadino1, contadino));
        when(paeseOrigineRepository.findAll()).thenReturn(Arrays.asList(paeseOrigine1, paeseOrigine));

        Iterable<Double> result = gestioneStatisticheService.statistichePaginaResponsabileOrdini();

        // Then (verifica dei risultati)
        List<Double> expectedResult = Arrays.asList((double) prodotti.size(), (double) listContadini.size(),
                (double) ordini.size(), (double) listPaesi.size());
        assertEquals(expectedResult, result);
    }
}
