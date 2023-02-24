package it.unisa.WoodLot.web.control.gestioneCatalogo.filtri;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.model.entity.Categoria;
import it.unisa.WoodLot.model.entity.PaeseOrigine;
import it.unisa.WoodLot.model.entity.UsoLocale;
import it.unisa.WoodLot.sevice.gestioneCatalogo.filtri.GestioneFiltriService;
import it.unisa.WoodLot.web.controller.gestioneCatalogo.filtri.ControllerFiltri;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test di unità per la classe ControllerFiltri
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerFiltriUT {

    @Mock
    private GestioneFiltriService filtriService;
    @InjectMocks
    private ControllerFiltri controllerFiltri;

    /**
     * Testa il caso un cui si vuole recuperare tutti i prodotti del catalogo
     * Il test risulta superato se vengono recuperati tutti i prodotti del catalogo
     */
    @Test
    public void testRestituisciProdotti() {
        List<Albero> alberi = new ArrayList<>();
        Albero albero = new Albero();
        albero.setNome("Quercia");
        alberi.add(albero);
        albero.setNome("Pino");
        alberi.add(albero);

        when(filtriService.getProdotti()).thenReturn(alberi);

        Iterable<Albero> risultato = controllerFiltri.restituisciProdotti();

        assertEquals(2, ((List<Albero>) risultato).size());
    }

    /**
     * Testa il caso un cui si vuole recuperare tutti i prodotti del catalogo ordinanti in base al prezzo
     * assorbita
     * Il test risulta superato se vengono recuperati tutti i prodotti del catalogo
     */
    @Test
    public void testRestituisciProdottiFiltratiByPrezzo() {
        String prezzoCrescente = "prezzoCrescente";

        List<Albero> alberi = new ArrayList<>();
        Albero albero = new Albero();
        albero.setNome("Quercia");
        albero.setPrezzo(34);
        alberi.add(albero);
        albero.setNome("Pino");
        albero.setPrezzo(45);
        alberi.add(albero);

        when(filtriService.getProdottiFiltratiByPrezzo(prezzoCrescente)).thenReturn(alberi);

        List<Albero> filteredProdotti = (List<Albero>) controllerFiltri.restituisciProdottiFiltratiByPrezzo(prezzoCrescente);

        assertEquals(false, filteredProdotti.isEmpty());
    }

    /**
     * Testa il caso un cui si vuole recuperare tutti i prodotti del catalogo che vengono piantati in determinato paese
     * Il test risulta superato se vengono recuperati tutti i prodotti del catalogo che appartengo al paese in ingresso
     */
    @Test
    void testRestituisciProdottiFiltratiByPaese() {
        PaeseOrigine paeseOrigine = new PaeseOrigine();
        paeseOrigine.setNome("Italia");

        PaeseOrigine paeseOrigine1 = new PaeseOrigine();
        paeseOrigine1.setNome("Guatemala");

        List<Albero> alberi = new ArrayList<>();
        Albero albero = new Albero();
        albero.setNome("Quercia");
        albero.setPrezzo(34);
        albero.setPaeseOrigine(paeseOrigine);
        alberi.add(albero);

        albero.setNome("Pino");
        albero.setPrezzo(45);
        albero.setPaeseOrigine(paeseOrigine1);
        alberi.add(albero);

        List<Albero> risultato = new ArrayList<>();
        risultato.add(albero);

        when(filtriService.getProdottiFiltratiByPaese(paeseOrigine1.getNome())).thenReturn(risultato);

        List<Albero> filteredProdotti = (List<Albero>) controllerFiltri.restituisciProdottiFiltratiByPaese(paeseOrigine1.getNome());

        assertEquals(risultato, filteredProdotti);
    }

    /**
     * Testa il caso un cui si vuole recuperare tutti i prodotti del catalogo che hanno un uso locale
     * Il test risulta superato se vengono recuperati tutti i prodotti del catalogo che hanno l'uso locale
     */
    @Test
    void testRestituisciProdottiFiltratiByUsoLocale() {
        UsoLocale usoLocale = new UsoLocale();
        usoLocale.setNome("Uso locale 1");

        UsoLocale usoLocale1 = new UsoLocale();
        usoLocale1.setNome("Uso locale 2");

        List<Albero> alberi = new ArrayList<>();
        Albero albero = new Albero();
        albero.setNome("Quercia");
        albero.setPrezzo(34);
        albero.setUsiLocali(Arrays.asList(usoLocale1));
        alberi.add(albero);

        albero.setNome("Pino");
        albero.setPrezzo(45);
        albero.setUsiLocali(Arrays.asList(usoLocale));
        alberi.add(albero);

        List<Albero> risultato = new ArrayList<>();
        risultato.add(albero);

        when(filtriService.getProdottiFiltratiByUsoLocale(usoLocale1.getNome())).thenReturn(risultato);

        List<Albero> filteredProdotti = (List<Albero>) controllerFiltri.restituisciProdottiFiltratiByUsoLocale(usoLocale1.getNome());

        assertEquals(risultato, filteredProdotti);
    }

    /**
     * Testa il caso un cui si vuole recuperare tutti i prodotti del catalogo che appartengono a una determinata categoria
     * Il test risulta superato se vengono recuperati tutti i prodotti del catalogo che appartengono alla categoria
     */
    @Test
    void testRestituisciProdottiFiltratiByCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNome("Categoria");

        Categoria categoria1 = new Categoria();
        categoria1.setNome("Categoria 1");

        List<Albero> alberi = new ArrayList<>();
        Albero albero = new Albero();
        albero.setNome("Quercia");
        albero.setPrezzo(34);
        albero.setCategoria(categoria);
        alberi.add(albero);

        albero.setNome("Pino");
        albero.setPrezzo(45);
        albero.setCategoria(categoria1);
        alberi.add(albero);

        List<Albero> risultato = new ArrayList<>();
        risultato.add(albero);

        when(filtriService.getProdottiFiltratiByCategoria(categoria1.getNome())).thenReturn(risultato);

        List<Albero> filteredProdotti = (List<Albero>) controllerFiltri.restituisciProdottiByCategoria(categoria1.getNome());

        assertEquals(risultato, filteredProdotti);
    }

    /**
     * Testa il caso un cui si vuole recuperare tutti i prodotti del catalogo ordinanti in base alla anidride carbonica
     * assorbita
     * Il test risulta superato se vengono recuperati tutti i prodotti del catalogo
     */
    @Test
    public void testRestituisciProdottiFiltratiByAnidride() {
        String anidrideCrescente = "anidrideCrescente";

        List<Albero> alberi = new ArrayList<>();
        Albero albero = new Albero();
        albero.setNome("Quercia");
        albero.setAnidrideCarbonicaAssorbita(34);
        alberi.add(albero);
        albero.setNome("Pino");
        albero.setAnidrideCarbonicaAssorbita(45);
        alberi.add(albero);

        when(filtriService.getProdottiFiltratiByAnidrideCarbonica(anidrideCrescente)).thenReturn(alberi);

        List<Albero> filteredProdotti = (List<Albero>) controllerFiltri.restituisciProdottiByAnidrideCarbonica(anidrideCrescente);

        assertEquals(false, filteredProdotti.isEmpty());
    }

}
