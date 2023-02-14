package it.unisa.WoodLot.service.gestioneContadino.aggiornareStato;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.ProdottoOrdine;
import it.unisa.WoodLot.model.repository.ContadinoRepository;
import it.unisa.WoodLot.model.repository.ProdottoOrdineRepository;
import it.unisa.WoodLot.sevice.gestioneContadino.GestioneContadinoService;
import it.unisa.WoodLot.sevice.gestioneContadino.eccezioni.ContadinoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test d'integrazione fra la classe GestioneContadinoService e la repository.
 *
 * @author Alessia Ture
 */
@SpringBootTest
@Transactional
@Rollback
@ExtendWith(SpringExtension.class)
public class ContadinoServiceIT {

    @Autowired
    private ContadinoRepository contadinoRepository;

    @Autowired
    private ProdottoOrdineRepository prodottoOrdineRepository;

    @Autowired
    private GestioneContadinoService gestioneContadinoService;

    /**
     * Testa il caso in cui vengono recuperati tutti i contadini con successo
     * Il test è superato se tutti i contadini vegono recuperati con successo
     */
    @Test
    public void testGetElencoContadini() {
        Contadino c1 = new Contadino();
        c1.setNome("Luca");
        c1.setCoordinateGeografiche("string");
        c1.setCognome("Rossi");
        c1.setSwift("34");
        c1.setEmail("lucarossi@gmail.com");
        c1.setPassword("password");
        c1.setTitolareConto("Luca Rossi");
        c1.setDataDiNascita(new Date());
        c1 = contadinoRepository.save(c1);

        Contadino c2 = new Contadino();
        c2.setNome("Luca");
        c2.setCoordinateGeografiche("string");
        c2.setCognome("Neri");
        c2.setSwift("34rr");
        c2.setEmail("lucaneri@gmail.com");
        c2.setTitolareConto("Luca Neri");
        c2.setPassword("password");
        c2.setDataDiNascita(new Date());
        c2 = contadinoRepository.save(c2);

        Contadino c3 = new Contadino();
        c3.setNome("Anna");
        c3.setCoordinateGeografiche("string");
        c3.setCognome("Bianchi");
        c3.setSwift("3456");
        c3.setEmail("annabianchi@gmail.com");
        c3.setTitolareConto("Anna Bianchi");
        c3.setPassword("password");
        c3.setDataDiNascita(new Date());
        c3 = contadinoRepository.save(c3);

        List<Contadino> expectedContadini = Arrays.asList(
                c1, c2, c3
        );

        Iterable<Contadino> actualContadini = gestioneContadinoService.getElencoContadini();

        List<Contadino> resultList = StreamSupport.stream(actualContadini.spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(resultList.contains(expectedContadini.get(0)));
        assertTrue(resultList.contains(expectedContadini.get(2)));
        assertTrue(resultList.contains(expectedContadini.get(1)));
    }

    /**
     * Testa il caso in cui viene visualizzato con successo l'elenco degli alberi che si trovano nello stato non assegnato
     * Il test risulta superato se l'elenco viene recuperato con successo
     */
    @Test
    void testGetAlberiNonAssegnati() {
        ProdottoOrdine p1 = new ProdottoOrdine();
        p1.setStato(ProdottoOrdine.Stato.NonAssegnato);
        p1.setAnidrideCarbonicaAssorbita(23);
        p1 = prodottoOrdineRepository.save(p1);

        ProdottoOrdine p2 = new ProdottoOrdine();
        p2.setStato(ProdottoOrdine.Stato.NonAssegnato);
        p2.setAnidrideCarbonicaAssorbita(23);
        p2 = prodottoOrdineRepository.save(p2);

        ProdottoOrdine p3 = new ProdottoOrdine();
        p3.setStato(ProdottoOrdine.Stato.NonAssegnato);
        p3.setAnidrideCarbonicaAssorbita(23);
        p3 = prodottoOrdineRepository.save(p3);

        List<ProdottoOrdine> expectedProdottoOrdine = Arrays.asList(
                p1, p2, p3
        );

        Iterable<ProdottoOrdine> actualProdottoOrdine = gestioneContadinoService.getAlberiNonAssegnati();

        List<ProdottoOrdine> resultList = StreamSupport.stream(actualProdottoOrdine.spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(resultList.contains(expectedProdottoOrdine.get(0)));
        assertTrue(resultList.contains(expectedProdottoOrdine.get(1)));
        assertTrue(resultList.contains(expectedProdottoOrdine.get(2)));
    }

    /**
     * Testa il caso in cui lo stato dell'albero viene aggiornato con successo
     * Il test risulta superato se lo stato dell'albero viene aggiornato
     */
    @Test
    void testAggiornaStatoSuccesso() {
        ProdottoOrdine p1 = new ProdottoOrdine();
        p1.setStato(ProdottoOrdine.Stato.NonAssegnato);
        p1.setAnidrideCarbonicaAssorbita(23);
        p1.setNomeAlbero("Albero 1");
        p1 = prodottoOrdineRepository.save(p1);

        ProdottoOrdine updatedProdottoOrdine = new ProdottoOrdine();
        updatedProdottoOrdine.setId(p1.getId());
        updatedProdottoOrdine.setNomeAlbero(p1.getNomeAlbero());
        updatedProdottoOrdine.setStato(ProdottoOrdine.Stato.Assegnato);
        updatedProdottoOrdine.setDescrizione("Descrizione aggiornata");
        updatedProdottoOrdine.setFrutta(34.9);

        try {
            ProdottoOrdine actualProdottoOrdine = gestioneContadinoService.aggiornaStato(updatedProdottoOrdine);

            assertEquals(updatedProdottoOrdine.getId(), actualProdottoOrdine.getId());
            assertEquals(updatedProdottoOrdine.getNomeAlbero(), actualProdottoOrdine.getNomeAlbero());
            assertEquals(updatedProdottoOrdine.getStato(), actualProdottoOrdine.getStato());
            assertEquals(updatedProdottoOrdine.getDescrizione(), actualProdottoOrdine.getDescrizione());
            assertEquals(updatedProdottoOrdine.getFrutta(), actualProdottoOrdine.getFrutta());
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
        prodottoOrdine.setId(45565L);
        try {
            ProdottoOrdine actualProdottoOrdine = gestioneContadinoService.aggiornaStato(prodottoOrdine);
        } catch (ContadinoException e) {
            assertEquals(messaggio,e.getMessage());
        }
    }
}
