package it.unisa.WoodLot.service.gestioneCatalogo.filtri;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.model.entity.Categoria;
import it.unisa.WoodLot.model.entity.PaeseOrigine;
import it.unisa.WoodLot.model.entity.UsoLocale;
import it.unisa.WoodLot.model.repository.AlberoRepository;
import it.unisa.WoodLot.model.repository.CategoriaRepository;
import it.unisa.WoodLot.model.repository.PaeseOrigineRepository;
import it.unisa.WoodLot.model.repository.UsoLocaleRepository;
import it.unisa.WoodLot.sevice.gestioneCatalogo.filtri.GestioneFiltriService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test di unità per la classe GestioneFiltriService
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FiltriServiceUT {

    @Mock
    private AlberoRepository alberoRepository;
    @Mock
    private PaeseOrigineRepository paeseOrigineRepository;
    @Mock
    private UsoLocaleRepository usoLocaleRepository;
    @InjectMocks
    private GestioneFiltriService gestioneFiltriService;
    @Mock
    private CategoriaRepository categoriaRepository;

    private List<Albero> alberi;

    @BeforeEach()
    void setUp() {
        Categoria c1 = new Categoria();
        c1.setNome("Categoria1");

        Categoria c2 = new Categoria();
        c2.setNome("Categoria2");

        Categoria c3 = new Categoria();
        c3.setNome("Categoria4");

        UsoLocale u1 = new UsoLocale();
        u1.setNome("Uso locale 1");

        UsoLocale u2 = new UsoLocale();
        u2.setNome("Uso locale 2");

        UsoLocale u3 = new UsoLocale();
        u3.setNome("Uso locale 3");

        UsoLocale u4 = new UsoLocale();
        u4.setNome("Uso locale 4");

        UsoLocale u5 = new UsoLocale();
        u5.setNome("Uso locale 5");

        PaeseOrigine p = new PaeseOrigine();
        p.setNome("Paese1");

        PaeseOrigine p1 = new PaeseOrigine();
        p1.setNome("Paese2");

        PaeseOrigine p2 = new PaeseOrigine();
        p2.setNome("Paese2");

        PaeseOrigine p3 = new PaeseOrigine();
        p3.setNome("Paese3");

        alberi = new ArrayList<>();
        Albero albero = new Albero();
        albero.setNome("1");
        albero.setPrezzo(56);
        albero.setPaeseOrigine(p);
        albero.setUsiLocali(Arrays.asList(u5, u2, u1));
        albero.setAnidrideCarbonicaAssorbita(67);
        albero.setCategoria(c1);
        alberi.add(albero);

        albero = new Albero();
        albero.setNome("2");
        albero.setPrezzo(89);
        albero.setPaeseOrigine(p1);
        albero.setUsiLocali(Arrays.asList(u5, u4, u3));
        albero.setAnidrideCarbonicaAssorbita(6);
        albero.setCategoria(c2);
        alberi.add(albero);

        albero = new Albero();
        albero.setNome("3");
        albero.setPrezzo(9);
        albero.setPaeseOrigine(p2);
        albero.setPaeseOrigine(p1);
        albero.setUsiLocali(Arrays.asList(u2));
        albero.setAnidrideCarbonicaAssorbita(77);
        albero.setCategoria(c3);
        alberi.add(albero);

        albero = new Albero();
        albero.setNome("3");
        albero.setPrezzo(9);
        albero.setPaeseOrigine(p2);
        albero.setPaeseOrigine(p1);
        albero.setUsiLocali(Arrays.asList(u1));
        albero.setAnidrideCarbonicaAssorbita(678);
        albero.setCategoria(c2);
        alberi.add(albero);

        albero = new Albero();
        albero.setNome("4");
        albero.setPrezzo(97);
        albero.setPaeseOrigine(p2);
        albero.setPaeseOrigine(p1);
        albero.setUsiLocali(Arrays.asList(u5, u4));
        albero.setAnidrideCarbonicaAssorbita(83);
        albero.setCategoria(c1);
        alberi.add(albero);

        albero = new Albero();
        albero.setNome("5");
        albero.setPrezzo(67);
        albero.setPaeseOrigine(p3);
        albero.setPaeseOrigine(p1);
        albero.setUsiLocali(Arrays.asList(u3, u2, u1));
        albero.setAnidrideCarbonicaAssorbita(56);
        albero.setCategoria(c3);
        alberi.add(albero);

        alberoRepository.saveAll(alberi);
    }


    @Test
    public void testGetProdottiFiltratiByCO2_decrescente() {
        Iterable<Albero> result = gestioneFiltriService.getProdottiFiltratiByAnidrideCarbonica("anidrideDecrescente");

        assertNotNull(result);

        List<Albero> resultList = StreamSupport.stream(result.spliterator(), false)
                .collect(Collectors.toList());

        for (int i = 1; i < resultList.size(); i++) {
            Albero current = resultList.get(i);
            Albero previous = resultList.get(i - 1);
            assertTrue(current.getAnidrideCarbonicaAssorbita() <= previous.getAnidrideCarbonicaAssorbita());
        }
    }

    @Test
    public void testGetProdottiFiltratiByCO2_crescente() {
        Iterable<Albero> result = gestioneFiltriService.getProdottiFiltratiByAnidrideCarbonica("anidrideCrescente");

        assertNotNull(result);

        List<Albero> resultList = StreamSupport.stream(result.spliterator(), false)
                .collect(Collectors.toList());

        for (int i = 1; i < resultList.size(); i++) {
            Albero current = resultList.get(i);
            Albero previous = resultList.get(i - 1);
            assertTrue(current.getAnidrideCarbonicaAssorbita() >= previous.getAnidrideCarbonicaAssorbita());
        }
    }

    @Test
    public void testGetProdottiFiltratiByCO2_parametroInvalido() {
        Iterable<Albero> result = gestioneFiltriService.getProdottiFiltratiByAnidrideCarbonica("parametroInvalido");
        assertNull(result);
    }

    @Test
    public void testGetProdottiFiltratiByPrezzo_prezzoDecrescente() {
        Iterable<Albero> result = gestioneFiltriService.getProdottiFiltratiByPrezzo("prezzoDecrescente");

        assertNotNull(result);

        List<Albero> resultList = StreamSupport.stream(result.spliterator(), false)
                .collect(Collectors.toList());

        for (int i = 1; i < resultList.size(); i++) {
            Albero current = resultList.get(i);
            Albero previous = resultList.get(i - 1);
            assertTrue(current.getPrezzo() <= previous.getPrezzo());
        }
    }

    @Test
    public void testGetProdottiFiltratiByPrezzo_prezzoCrescente() {
        Iterable<Albero> result = gestioneFiltriService.getProdottiFiltratiByPrezzo("prezzoCrescente");

        assertNotNull(result);

        List<Albero> resultList = StreamSupport.stream(result.spliterator(), false)
                .collect(Collectors.toList());

        for (int i = 1; i < resultList.size(); i++) {
            Albero current = resultList.get(i);
            Albero previous = resultList.get(i - 1);
            assertTrue(current.getPrezzo() >= previous.getPrezzo());
        }
    }

    @Test
    public void testGetProdottiFiltratiByPrezzo_parametroInvalido() {
        Iterable<Albero> result = gestioneFiltriService.getProdottiFiltratiByPrezzo("parametroInvalido");
        assertNull(result);
    }

    @Test
    public void testGetProdottiFiltratiByPaese() {
        Iterable<Albero> result = gestioneFiltriService.getProdottiFiltratiByPaese("Paese1");
        assertNotNull(result);

        List<Albero> resultList = StreamSupport.stream(result.spliterator(), false)
                .collect(Collectors.toList());
        resultList.forEach(albero -> assertEquals("Paese1", albero.getPaeseOrigine().getNome()));
    }

    @Test
    public void testGetProdottiFiltratiByUsiLocali() {
        UsoLocale u1 = new UsoLocale();
        u1.setNome("Uso locale 1");

        Iterable<Albero> result = gestioneFiltriService.getProdottiFiltratiByUsoLocale("Uso locale 1");
        assertNotNull(result);

        for (Albero albero : result) {
            assertTrue(albero.getUsiLocali().contains(u1));
        }
    }

    @Test
    public void testGetProdottiFiltratiByCategoria() {
        Categoria c1 = new Categoria();
        c1.setNome("Categoria1");

        Iterable<Albero> result = gestioneFiltriService.getProdottiFiltratiByCategoria("Categoria1");
        assertNotNull(result);

        List<Albero> resultList = StreamSupport.stream(result.spliterator(), false)
                .collect(Collectors.toList());
        resultList.forEach(albero -> assertEquals("Categoria1", albero.getCategoria().getNome()));

    }
}
