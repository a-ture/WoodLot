package it.unisa.WoodLot.service.gestioneCatalogo.filtri;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import it.unisa.WoodLot.sevice.gestioneCatalogo.filtri.GestioneFiltriService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test d'integrazione fra la classe GestioneFiltriService e la repository.
 *
 * @author Alessia Ture
 */
@SpringBootTest
@Transactional
@Rollback
@ExtendWith(SpringExtension.class)
public class FiltriServiceIT {

    @Autowired
    private AlberoRepository alberoRepository;
    @Autowired
    private PaeseOrigineRepository paeseOrigineRepository;
    @Autowired
    private UsoLocaleRepository usoLocaleRepository;
    @Autowired
    private BeneficioRepository beneficioRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private GestioneFiltriService gestioneFiltriService;

    private Albero albero1;
    private Albero albero2;
    private Albero albero3;

    @BeforeEach()
    void setUp() {
        PaeseOrigine paeseOrigine = new PaeseOrigine();
        paeseOrigine.setNome("Paese 1");
        paeseOrigine.setDescrizione("string");
        paeseOrigineRepository.save(paeseOrigine);

        Categoria categoria = new Categoria();
        categoria.setNome("Categoria 1");
        categoria.setDescrizione("string");
        categoriaRepository.save(categoria);

        UsoLocale usoLocale = new UsoLocale();
        usoLocale.setNome("Uso locale 1");
        usoLocale.setDescrizione("string");
        usoLocaleRepository.save(usoLocale);

        Beneficio beneficio = new Beneficio();
        beneficio.setNome("Beneficio");
        beneficio.setDescrizione("string");
        beneficioRepository.save(beneficio);

        albero1 = new Albero();
        albero1.setNome("Albero 1");
        albero1.setPrezzo(56);
        albero1.setSalvaguardia(3);
        albero1.setDescrizione("String string");
        albero1.setDescrizioneBreve("string");
        albero1.setPaeseOrigine(paeseOrigine);
        albero1.setCategoria(categoria);
        albero1.setAnidrideCarbonicaAssorbita(78);
        albero1.setSpecieScientifica("Specie");
        albero1.setUsiLocali(Arrays.asList(usoLocale));
        albero1.setBenefici(Arrays.asList(beneficio));

        alberoRepository.save(albero1);

        paeseOrigine = new PaeseOrigine();
        paeseOrigine.setNome("Paese 2");
        paeseOrigine.setDescrizione("string");
        paeseOrigineRepository.save(paeseOrigine);

        categoria = new Categoria();
        categoria.setNome("Categoria 2");
        categoria.setDescrizione("string");
        categoriaRepository.save(categoria);

        usoLocale = new UsoLocale();
        usoLocale.setNome("Uso locale 2");
        usoLocale.setDescrizione("string");
        usoLocaleRepository.save(usoLocale);

        beneficio = new Beneficio();
        beneficio.setNome("Beneficio 2");
        beneficio.setDescrizione("string");
        beneficioRepository.save(beneficio);

        albero2 = new Albero();
        albero2.setNome("Albero 2");
        albero2.setPrezzo(6);
        albero2.setSalvaguardia(3);
        albero2.setDescrizione("String string");
        albero2.setDescrizioneBreve("string");
        albero2.setPaeseOrigine(paeseOrigine);
        albero2.setCategoria(categoria);
        albero2.setAnidrideCarbonicaAssorbita(8);
        albero2.setSpecieScientifica("Specie");
        albero2.setUsiLocali(Arrays.asList(usoLocale));
        albero2.setBenefici(Arrays.asList(beneficio));

        alberoRepository.save(albero2);

        paeseOrigine = new PaeseOrigine();
        paeseOrigine.setNome("Paese 3");
        paeseOrigine.setDescrizione("string");
        paeseOrigineRepository.save(paeseOrigine);

        categoria = new Categoria();
        categoria.setNome("Categoria 3");
        categoria.setDescrizione("string");
        categoriaRepository.save(categoria);

        usoLocale = new UsoLocale();
        usoLocale.setNome("Uso locale 3");
        usoLocale.setDescrizione("string");
        usoLocaleRepository.save(usoLocale);

        beneficio = new Beneficio();
        beneficio.setNome("Beneficio 3");
        beneficio.setDescrizione("string");
        beneficioRepository.save(beneficio);

        albero3 = new Albero();
        albero3.setNome("Albero 3");
        albero3.setPrezzo(586);
        albero3.setSalvaguardia(3);
        albero3.setDescrizione("String string");
        albero3.setDescrizioneBreve("string");
        albero3.setPaeseOrigine(paeseOrigine);
        albero3.setCategoria(categoria);
        albero3.setAnidrideCarbonicaAssorbita(798);
        albero3.setSpecieScientifica("Specie");
        albero3.setUsiLocali(Arrays.asList(usoLocale));
        albero3.setBenefici(Arrays.asList(beneficio));

        alberoRepository.save(albero3);
    }

    /**
     * Testa il caso in viene recuperato il catalogo prodotti
     * <p>
     * Il test è superato se vengono restituiti tutti i prodotti
     */
    @Test
    public void testGetProdotti() {
        Iterable<Albero> prodotti = gestioneFiltriService.getProdotti();

        List<Albero> resultList = StreamSupport.stream(prodotti.spliterator(), false)
                .collect(Collectors.toList());

        assertTrue(resultList.contains(albero1));
        assertTrue(resultList.contains(albero2));
        assertTrue(resultList.contains(albero3));
    }

    /**
     * Testa il caso in viene applicato il filtro: Anidride carbonica decrescente
     * <p>
     * Il test è superato se i prodotti vengono ordinati correttamente
     */
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

    /**
     * Testa il caso in viene applicato il filtro: Anidride carbonica crescente
     * <p>
     * Il test è superato se i prodotti vengono ordinati correttamente
     */
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

    /**
     * Testa il caso in viene applicato il filtro: Anidride carbonica con un parametro non valido
     * <p>
     * Il test è superato se i prodotti vengono ordinati correttamente
     */
    @Test
    public void testGetProdottiFiltratiByCO2_parametroInvalido() {
        Iterable<Albero> result = gestioneFiltriService.getProdottiFiltratiByAnidrideCarbonica("parametroInvalido");
        assertNull(result);
    }

    /**
     * Testa il caso in viene applicato il filtro: Prezzo decrescente
     * <p>
     * Il test è superato se i prodotti vengono ordinati correttamente
     */
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

    /**
     * Testa il caso in viene applicato il filtro: Prezzo crescente
     * <p>
     * Il test è superato se i prodotti vengono ordinati correttamente
     */
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

    /**
     * Testa il caso in viene applicato il filtro: Prezzo con un parametro invalido
     * <p>
     * Il test è superato se i prodotti vengono ordinati correttamente
     */
    @Test
    public void testGetProdottiFiltratiByPrezzo_parametroInvalido() {
        Iterable<Albero> result = gestioneFiltriService.getProdottiFiltratiByPrezzo("parametroInvalido");
        assertNull(result);
    }

    /**
     * Testa il caso in viene applicato il filtro: Paesi
     * <p>
     * Il test è superato se i prodotti restituiti sono solo quelli piantati nel paese in ingresso
     */
    @Test
    public void testGetProdottiFiltratiByPaese() {
        Iterable<Albero> result = gestioneFiltriService.getProdottiFiltratiByPaese("Paese1");
        assertNotNull(result);

        List<Albero> resultList = StreamSupport.stream(result.spliterator(), false)
                .collect(Collectors.toList());
        resultList.forEach(albero -> assertEquals("Paese1", albero.getPaeseOrigine().getNome()));
    }

    /**
     * Testa il caso in viene applicato il filtro: Usi locali
     * <p>
     * Il test è superato se i prodotti restituiti sono solo quelli che possiedono l'uso locale in ingresso
     */
    @Test
    public void testGetProdottiFiltratiByUsiLocali() {
        UsoLocale u1 = new UsoLocale();
        u1.setNome("Uso locale 1");
        u1.setDescrizione("string");

        Iterable<Albero> result = gestioneFiltriService.getProdottiFiltratiByUsoLocale("Uso locale 1");
        assertNotNull(result);

        for (Albero albero : result) {
            assertTrue(albero.getUsiLocali().contains(u1));
        }
    }

    /**
     * Testa il caso in viene applicato il filtro: Categoria
     * <p>
     * Il test è superato se i prodotti restituiti sono solo quelli che appartengono alla categoria in ingresso
     */
    @Test
    public void testGetProdottiFiltratiByCategoria() {
        Categoria c1 = new Categoria();
        c1.setNome("Categoria 1");

        Iterable<Albero> result = gestioneFiltriService.getProdottiFiltratiByCategoria("Categoria1");
        assertNotNull(result);

        List<Albero> resultList = StreamSupport.stream(result.spliterator(), false)
                .collect(Collectors.toList());
        resultList.forEach(albero -> assertEquals("Categoria1", albero.getCategoria().getNome()));
    }
}