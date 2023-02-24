package it.unisa.WoodLot.web.control.gestioneCatalogo.prodotto;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni.AlberoException;
import it.unisa.WoodLot.sevice.gestioneCatalogo.prodotto.GestioneProdottoService;
import it.unisa.WoodLot.web.controller.gestioneCatalogo.prodotto.ControllerProdotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test di unità per la classe ControllerProdotto
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerProdottoUT {

    @Mock
    private GestioneProdottoService gestioneProdottoService;
    @InjectMocks
    private ControllerProdotto controllerProdotto;

    /**
     * Testa il caso in cui si vuole recuperare le informazioni di un prodotto
     * Il test risulta superato se l'albero viene recuperato correttamente
     */
    @Test
    public void testRestituisciProdotto() throws AlberoException {
        Albero albero = new Albero();
        albero.setNome("Albero");

        when(gestioneProdottoService.getProdotto("Albero")).thenReturn(albero);

        Albero attuale = controllerProdotto.restituisciProdotto("Albero");

        assertEquals(albero, attuale);
    }

    /**
     * Testa il caso in cui si vogliono recuperate l'elenco delle categorie presenti nel database
     * Il test risulta superato se i dati vengono recuperati correttamente
     */
    @Test
    void testRestituisciCategorie() {
        Categoria categoria1 = new Categoria();
        categoria1.setNome("Categoria 1");
        Categoria categoria2 = new Categoria();
        categoria2.setNome("Categoria 2");

        List<Categoria> categorie = new ArrayList<>();
        categorie.add(categoria1);
        categorie.add(categoria2);

        when(gestioneProdottoService.getCategorie()).thenReturn(categorie);

        Iterable<Categoria> result = controllerProdotto.restituisciCategorie();

        assertEquals(categorie, result);
    }

    /**
     * Testa il caso in cui si vogliono recuperate l'elenco dei paesi presenti nel database
     * Il test risulta superato se i dati vengono recuperati correttamente
     */
    @Test
    void testRestituisciPaesi() {
        PaeseOrigine paeseOrigine = new PaeseOrigine();
        paeseOrigine.setNome("Paese 1");
        PaeseOrigine paeseOrigine1 = new PaeseOrigine();
        paeseOrigine1.setNome("Paese 2");

        List<PaeseOrigine> paesi = new ArrayList<>();
        paesi.add(paeseOrigine1);
        paesi.add(paeseOrigine);

        when(gestioneProdottoService.getPaesiDiOrigine()).thenReturn(paesi);

        Iterable<PaeseOrigine> result = controllerProdotto.restituisciPaesi();

        assertEquals(paesi, result);
    }

    /**
     * Testa il caso in cui si vogliono recuperate l'elenco degli usi locali presenti nel database
     * Il test risulta superato se i dati vengono recuperati correttamente
     */
    @Test
    void testRestituisciUsiLocali() {
        UsoLocale usoLocale = new UsoLocale();
        usoLocale.setNome("Uso Locale 1");
        UsoLocale usoLocale1 = new UsoLocale();
        usoLocale1.setNome("Uso locale 2");

        List<UsoLocale> usi = new ArrayList<>();
        usi.add(usoLocale);
        usi.add(usoLocale1);

        when(gestioneProdottoService.getUsiLocali()).thenReturn(usi);

        Iterable<UsoLocale> result = controllerProdotto.restituisciUsiLocali();

        assertEquals(usi, result);
    }

    /**
     * Testa il caso in cui si vogliono recuperate l'elenco dei benefici presenti nel database
     * Il test risulta superato se i dati vengono recuperati correttamente
     */
    @Test
    void testRestituisciBenefici() {
        Beneficio beneficio = new Beneficio();
        beneficio.setNome("Beneficio 1");
        Beneficio beneficio1 = new Beneficio();
        beneficio1.setNome("Beneficio 2");

        List<Beneficio> benefici = new ArrayList<>();
        benefici.add(beneficio1);
        benefici.add(beneficio);

        when(gestioneProdottoService.getBenefici()).thenReturn(benefici);

        Iterable<Beneficio> result = controllerProdotto.restituisciBenefici();

        assertEquals(benefici, result);
    }
}
