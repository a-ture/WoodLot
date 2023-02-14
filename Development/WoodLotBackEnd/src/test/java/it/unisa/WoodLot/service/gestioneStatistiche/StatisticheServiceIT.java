package it.unisa.WoodLot.service.gestioneStatistiche;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import it.unisa.WoodLot.sevice.gestioneStatistiche.GestioneStatisticheService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test d'integrazione fra la classe GestioneStatisticheService e la repository.
 *
 * @author Alessia Ture
 */
@SpringBootTest
@Transactional
@Rollback
@ExtendWith(SpringExtension.class)
public class StatisticheServiceIT {

    @Autowired
    private OrdineRepository ordineRepository;
    @Autowired
    private PaeseOrigineRepository paeseOrigineRepository;
    @Autowired
    private ContadinoRepository contadinoRepository;
    @Autowired
    private ProdottoOrdineRepository prodottoOrdineRepository;
    @Autowired
    private GestioneStatisticheService gestioneStatisticheService;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private AlberoRepository alberoRepository;

    /**
     * Testa la visualizzazione delle statistiche per la pagina dell'utente
     * Il test risulta superato se le statistiche corrispondo all'oracolo
     */
    @Test
    void testStatistichePaginaUtente() {
        Utente utente = new Utente();
        utente.setNome("Simona");
        utente.setCognome("Mengoni");
        utente.setPassword("password");
        utente.setEmail("simona@gmail.com");
        utente.setDataDiNascita(new Date());
        utenteRepository.save(utente);

        Ordine ordine1 = new Ordine();
        Ordine ordine2 = new Ordine();

        ProdottoOrdine prodottoOrdine1 = new ProdottoOrdine();
        prodottoOrdine1.setAnidrideCarbonicaAssorbita(100);

        ProdottoOrdine prodottoOrdine2 = new ProdottoOrdine();
        prodottoOrdine2.setAnidrideCarbonicaAssorbita(200);

        ProdottoOrdine prodottoOrdine3 = new ProdottoOrdine();
        prodottoOrdine3.setAnidrideCarbonicaAssorbita(300);

        List<ProdottoOrdine> prodottiOrdine1 = new ArrayList<>();
        prodottiOrdine1.add(prodottoOrdine1);
        prodottiOrdine1.add(prodottoOrdine2);
        ordine1.setProdottiOrdine(prodottiOrdine1);
        ordine1.setUtente(utente);
        ordine1.setDataOrdine(LocalDate.now());
        ordine1.setTotale(234);

        List<ProdottoOrdine> prodottiOrdine2 = new ArrayList<>();
        prodottiOrdine2.add(prodottoOrdine3);
        ordine2.setProdottiOrdine(prodottiOrdine2);
        ordine2.setUtente(utente);
        ordine2.setDataOrdine(LocalDate.now());
        ordine2.setTotale(2343);

        List<Ordine> ordini = new ArrayList<>();
        ordini.add(ordine1);
        ordini.add(ordine2);

        ordineRepository.saveAll(ordini);

        Iterable<Double> statistiche = gestioneStatisticheService.statistichePaginaUtente(utente.getId());
        ArrayList<Double> expected = new ArrayList<>(2);
        expected.add(3.0);
        expected.add(600.0);
        assertEquals(expected, statistiche);
    }

    /**
     * Testa la visualizzazione delle statistiche per la pagina del responsabile catalogo
     * Il test risulta superato se le statistiche corrispondo all'oracolo
     */
    @Test
    void testStatistichePaginaResponsabileCatalogo() {
        ordineRepository.deleteAll();
        prodottoOrdineRepository.deleteAll();
        contadinoRepository.deleteAll();
        alberoRepository.deleteAll();
        paeseOrigineRepository.deleteAll();

        Utente utente = new Utente();
        utente.setNome("Simona");
        utente.setCognome("Mengoni");
        utente.setPassword("password");
        utente.setEmail("simona@gmail.com");
        utente.setDataDiNascita(new Date());
        utenteRepository.save(utente);

        Ordine ordine1 = new Ordine();
        Ordine ordine2 = new Ordine();

        ProdottoOrdine prodottoOrdine1 = new ProdottoOrdine();
        prodottoOrdine1.setAnidrideCarbonicaAssorbita(100);
        prodottoOrdine1.setStato(ProdottoOrdine.Stato.NonAssegnato);
        prodottoOrdineRepository.save(prodottoOrdine1);

        ProdottoOrdine prodottoOrdine2 = new ProdottoOrdine();
        prodottoOrdine2.setAnidrideCarbonicaAssorbita(200);
        prodottoOrdine2.setStato(ProdottoOrdine.Stato.NonAssegnato);
        prodottoOrdineRepository.save(prodottoOrdine2);

        ProdottoOrdine prodottoOrdine3 = new ProdottoOrdine();
        prodottoOrdine3.setAnidrideCarbonicaAssorbita(300);
        prodottoOrdine3.setStato(ProdottoOrdine.Stato.NonAssegnato);
        prodottoOrdineRepository.save(prodottoOrdine3);

        List<ProdottoOrdine> prodottiOrdine1 = new ArrayList<>();
        prodottiOrdine1.add(prodottoOrdine1);
        prodottiOrdine1.add(prodottoOrdine2);
        ordine1.setProdottiOrdine(prodottiOrdine1);
        ordine1.setUtente(utente);
        ordine1.setDataOrdine(LocalDate.now());
        ordine1.setTotale(234);

        List<ProdottoOrdine> prodottiOrdine2 = new ArrayList<>();
        prodottiOrdine2.add(prodottoOrdine3);
        ordine2.setProdottiOrdine(prodottiOrdine2);
        ordine2.setUtente(utente);
        ordine2.setDataOrdine(LocalDate.now());
        ordine2.setTotale(2343);

        List<Ordine> ordini = new ArrayList<>();
        ordini.add(ordine1);
        ordini.add(ordine2);

        ordineRepository.saveAll(ordini);

        Contadino contadino1 = new Contadino();
        contadino1.setDataDiNascita(new Date());
        contadino1.setSwift("Swift");
        contadino1.setNome("Ziva");
        contadino1.setCognome("David");
        contadino1.setTitolareConto("Ziva David");
        contadino1.setPassword("password");
        contadino1.setEmail("zivadavid@gmail.com");
        contadino1.setCoordinateGeografiche("geografia");

        Contadino contadino2 = new Contadino();
        contadino2.setDataDiNascita(new Date());
        contadino2.setSwift("Swift");
        contadino2.setNome("Lea");
        contadino2.setCognome("David");
        contadino2.setTitolareConto("Lea David");
        contadino2.setPassword("password");
        contadino2.setEmail("leadavid@gmail.com");
        contadino2.setCoordinateGeografiche("geografia");

        List<Contadino> contadini = new ArrayList<>();
        contadini.add(contadino1);
        contadini.add(contadino2);

        contadinoRepository.saveAll(contadini);

        PaeseOrigine paeseOrigine1 = new PaeseOrigine();
        paeseOrigine1.setDescrizione("descrizione");
        paeseOrigine1.setNome("paese 1");

        PaeseOrigine paeseOrigine2 = new PaeseOrigine();
        paeseOrigine2.setDescrizione("descrizione");
        paeseOrigine2.setNome("paese 2");

        List<PaeseOrigine> paesiOrigine = new ArrayList<>();

        paesiOrigine.add(paeseOrigine1);
        paesiOrigine.add(paeseOrigine2);

        paeseOrigineRepository.saveAll(paesiOrigine);

        Iterable<Double> statistiche = gestioneStatisticheService.statistichePaginaResponsabileCatalogo();
        ArrayList<Double> expected = new ArrayList<>(4);
        expected.add(3.0);
        expected.add(600.0);
        expected.add(2.0);
        expected.add(2.0);

        assertEquals(expected, statistiche);
    }

    /**
     * Testa la visualizzazione delle statistiche per la pagina del contadino
     * Il test risulta superato se le statistiche corrispondo all'oracolo
     */
    @Test
    void testStatistichePaginaContadino() {
        ordineRepository.deleteAll();
        prodottoOrdineRepository.deleteAll();
        contadinoRepository.deleteAll();

        Contadino contadino = new Contadino();
        contadino.setDataDiNascita(new Date());
        contadino.setSwift("Swift");
        contadino.setNome("Ziva");
        contadino.setCognome("David");
        contadino.setTitolareConto("Ziva David");
        contadino.setPassword("password");
        contadino.setEmail("zivadavid@gmail.com");
        contadino.setCoordinateGeografiche("geografia");
        contadino = contadinoRepository.save(contadino);

        ProdottoOrdine prodottoOrdine1 = new ProdottoOrdine();
        prodottoOrdine1.setFrutta(10.0);
        prodottoOrdine1.setStato(ProdottoOrdine.Stato.NonAssegnato);
        prodottoOrdine1.setContadino(contadino);
        prodottoOrdine1.setAnidrideCarbonicaAssorbita(100);

        ProdottoOrdine prodottoOrdine2 = new ProdottoOrdine();
        prodottoOrdine2.setFrutta(20.0);
        prodottoOrdine2.setStato(ProdottoOrdine.Stato.NonAssegnato);
        prodottoOrdine2.setContadino(contadino);
        prodottoOrdine2.setAnidrideCarbonicaAssorbita(200);

        List<ProdottoOrdine> prodottiOrdine = new ArrayList<>();
        prodottiOrdine.add(prodottoOrdine1);
        prodottiOrdine.add(prodottoOrdine2);

        prodottoOrdineRepository.saveAll(prodottiOrdine);

        Iterable<Double> statistiche = gestioneStatisticheService.statistichePaginaContadino(contadino.getId());
        ArrayList<Double> expected = new ArrayList<>(3);
        expected.add(300.0);
        expected.add(30.0);
        expected.add(2.0);

        assertEquals(expected, statistiche);
    }

    /**
     * Testa la visualizzazione delle statistiche per la pagina del responsabile degli ordini
     * Il test risulta superato se le statistiche corrispondo all'oracolo
     */
    @Test
    public void testStatistichePaginaResponsabileOrdini() {
        ordineRepository.deleteAll();
        prodottoOrdineRepository.deleteAll();
        contadinoRepository.deleteAll();
        alberoRepository.deleteAll();
        paeseOrigineRepository.deleteAll();

        PaeseOrigine paeseOrigine1 = new PaeseOrigine();
        paeseOrigine1.setDescrizione("descrizione");
        paeseOrigine1.setNome("paese 1");

        PaeseOrigine paeseOrigine2 = new PaeseOrigine();
        paeseOrigine2.setDescrizione("descrizione");
        paeseOrigine2.setNome("paese 2");

        List<PaeseOrigine> paesiOrigine = new ArrayList<>();

        paesiOrigine.add(paeseOrigine1);
        paesiOrigine.add(paeseOrigine2);

        paeseOrigineRepository.saveAll(paesiOrigine);

        Contadino contadino = new Contadino();
        contadino.setDataDiNascita(new Date());
        contadino.setSwift("Swift");
        contadino.setNome("Ziva");
        contadino.setCognome("David");
        contadino.setTitolareConto("Ziva David");
        contadino.setPassword("password");
        contadino.setEmail("zivadavid@gmail.com");
        contadino.setCoordinateGeografiche("geografia");
        contadino = contadinoRepository.save(contadino);

        ProdottoOrdine prodottoOrdine1 = new ProdottoOrdine();
        prodottoOrdine1.setFrutta(10.0);
        prodottoOrdine1.setStato(ProdottoOrdine.Stato.NonAssegnato);
        prodottoOrdine1.setContadino(contadino);
        prodottoOrdine1.setAnidrideCarbonicaAssorbita(100);

        ProdottoOrdine prodottoOrdine2 = new ProdottoOrdine();
        prodottoOrdine2.setFrutta(20.0);
        prodottoOrdine2.setStato(ProdottoOrdine.Stato.NonAssegnato);
        prodottoOrdine2.setContadino(contadino);
        prodottoOrdine2.setAnidrideCarbonicaAssorbita(200);

        List<ProdottoOrdine> prodottiOrdine1 = new ArrayList<>();
        prodottiOrdine1.add(prodottoOrdine1);
        prodottiOrdine1.add(prodottoOrdine2);

        prodottoOrdineRepository.saveAll(prodottiOrdine1);

        Ordine ordine1 = new Ordine();
        ordine1.setTotale(34);
        ordine1.aggiungiProdotto(prodottoOrdine1);
        ordine1.aggiungiProdotto(prodottoOrdine2);
        ordine1.setDataOrdine(LocalDate.now());
        ordine1 = ordineRepository.save(ordine1);

        ProdottoOrdine prodottoOrdine3 = new ProdottoOrdine();
        prodottoOrdine3.setFrutta(19.0);
        prodottoOrdine3.setStato(ProdottoOrdine.Stato.NonAssegnato);
        prodottoOrdine3.setContadino(contadino);
        prodottoOrdine3.setAnidrideCarbonicaAssorbita(1900);

        ProdottoOrdine prodottoOrdine4 = new ProdottoOrdine();
        prodottoOrdine4.setFrutta(20.0);
        prodottoOrdine4.setStato(ProdottoOrdine.Stato.NonAssegnato);
        prodottoOrdine4.setContadino(contadino);
        prodottoOrdine4.setAnidrideCarbonicaAssorbita(200);

        List<ProdottoOrdine> prodottiOrdine2 = new ArrayList<>();
        prodottiOrdine2.add(prodottoOrdine3);
        prodottiOrdine2.add(prodottoOrdine4);

        prodottoOrdineRepository.saveAll(prodottiOrdine2);

        Ordine ordine2 = new Ordine();
        ordine2.setDataOrdine(LocalDate.now());
        ordine2.setTotale(34);
        ordine2.aggiungiProdotto(prodottoOrdine3);
        ordine2.aggiungiProdotto(prodottoOrdine4);
        ordine2 = ordineRepository.save(ordine2);

        List<Ordine> ordini = new ArrayList<>();
        ordini.add(ordine1);
        ordini.add(ordine2);

        Iterable<Double> statistiche = gestioneStatisticheService.statistichePaginaResponsabileOrdini();
        ArrayList<Double> expected = new ArrayList<>(3);
        expected.add(4.0);
        expected.add(1.0);
        expected.add(2.0);
        expected.add(2.0);

        assertEquals(expected, statistiche);
    }
}
