package it.unisa.WoodLot.service.gestioneCatalogo.prodotto;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni.AlberoException;
import it.unisa.WoodLot.sevice.gestioneCatalogo.prodotto.GestioneProdottoService;
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
 * Test d'integrazione fra la classe GestioneProdottoService e la repository.
 *
 * @author Alessia Ture
 */
@SpringBootTest
@Transactional
@Rollback
@ExtendWith(SpringExtension.class)
public class ProdottoServiceIT {

    @Autowired
    private AlberoRepository alberoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private UsoLocaleRepository usoLocaleRepository;
    @Autowired
    private BeneficioRepository beneficioRepository;
    @Autowired
    private PaeseOrigineRepository paeseOrigineRepository;
    @Autowired
    private GestioneProdottoService gestioneProdottoService;

    /**
     * Testa il caso in cui il prodotto viene trovato con successo
     * <p>
     * Il test è superato se è possibile trovare il prodotto
     */
    @Test
    public void testGetProdottoSuccesso() {
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

        Albero albero = new Albero();
        albero.setNome("Albero di Natale");
        albero.setPrezzo(56);
        albero.setSalvaguardia(3);
        albero.setDescrizione("String string");
        albero.setDescrizioneBreve("string");
        albero.setPaeseOrigine(paeseOrigine);
        albero.setCategoria(categoria);
        albero.setAnidrideCarbonicaAssorbita(78);
        albero.setSpecieScientifica("Specie");
        albero.setUsiLocali(Arrays.asList(usoLocale));
        albero.setBenefici(Arrays.asList(beneficio));

        albero = alberoRepository.save(albero);

        try {
            Albero trovato = gestioneProdottoService.getProdotto(albero.getNome());
            assertEquals(trovato, albero);
        } catch (AlberoException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso im cui il prodotto non viene trovato
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testGetProdottoInsuccesso() {
        Albero albero = new Albero();
        albero.setNome("Albero di Natale");
        String messaggio = "L'albero non è stato trovato";
        try {
            gestioneProdottoService.getProdotto(albero.getNome());
        } catch (AlberoException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il recupero con successo delle categorie
     * Il test è superato se vengono recuperate tutte le categorie
     */
    @Test
    public void testGetCategorie() {
        Categoria categoria1 = new Categoria();
        categoria1.setDescrizione("string");
        categoria1.setNome("categoria1");

        Categoria categoria2 = new Categoria();
        categoria2.setNome("categoria2");
        categoria2.setDescrizione("descrizione");

        categoriaRepository.save(categoria1);
        categoriaRepository.save(categoria2);

        Iterable<Categoria> categorie = gestioneProdottoService.getCategorie();

        List<Categoria> categorieList = StreamSupport.stream(categorie.spliterator(), false)
                .collect(Collectors.toList());
        assertEquals(categoriaRepository.findAll().size(), categorieList.size());
        assertTrue(categorieList.contains(categoria1));
        assertTrue(categorieList.contains(categoria2));
    }

    /**
     * Testa il caso in cui i benefici sono visualizzati con successo
     * Il test è superato se vengono recuperati tutti i benefici con successo
     */
    @Test
    void testGetBenefici() {
        Beneficio beneficio = new Beneficio();
        beneficio.setNome("Beneficio");
        beneficio.setDescrizione("string");
        beneficioRepository.save(beneficio);

        Beneficio beneficio1 = new Beneficio();
        beneficio1.setNome("Beneficio1");
        beneficio1.setDescrizione("string");
        beneficioRepository.save(beneficio1);

        Iterable<Beneficio> benefici = gestioneProdottoService.getBenefici();

        List<Beneficio> beneficioList = StreamSupport.stream(benefici.spliterator(), false)
                .collect(Collectors.toList());
        assertEquals(beneficioRepository.findAll().size(), beneficioList.size());
        assertTrue(beneficioList.contains(beneficio));
        assertTrue(beneficioList.contains(beneficio1));
    }

    /**
     * Testa il caso in cui gli usi locali sono visualizzati con successo
     * Il test è superato se vengono recuperati tutti gli usi locali
     */
    @Test
    public void testGetUsiLocali() {

        UsoLocale usoLocale = new UsoLocale();
        usoLocale.setNome("Uso locale 1");
        usoLocale.setDescrizione("string");
        usoLocaleRepository.save(usoLocale);

        UsoLocale usoLocale1 = new UsoLocale();
        usoLocale1.setNome("Uso locale 2");
        usoLocale1.setDescrizione("string");
        usoLocaleRepository.save(usoLocale1);

        Iterable<UsoLocale> usoLocaleIterable = gestioneProdottoService.getUsiLocali();

        List<UsoLocale> usoLocaleList = StreamSupport.stream(usoLocaleIterable.spliterator(), false)
                .collect(Collectors.toList());
        assertEquals(usoLocaleRepository.findAll().size(), usoLocaleList.size());
        assertTrue(usoLocaleList.contains(usoLocale));
        assertTrue(usoLocaleList.contains(usoLocale1));
    }

    /**
     * Testa il caso in cui i paesi sono visualizzati con successo
     * Il test è superato se vengono recuperati correttamente tutti i paesi
     */
    @Test
    public void testGetPaesi() {
        PaeseOrigine paeseOrigine = new PaeseOrigine();
        paeseOrigine.setNome("Paese 1");
        paeseOrigine.setDescrizione("string");
        paeseOrigineRepository.save(paeseOrigine);

        PaeseOrigine paeseOrigine1 = new PaeseOrigine();
        paeseOrigine1.setNome("Paese 2");
        paeseOrigine1.setDescrizione("string");
        paeseOrigineRepository.save(paeseOrigine1);

        Iterable<PaeseOrigine> paesi = gestioneProdottoService.getPaesiDiOrigine();

        List<PaeseOrigine> paeseOrigineList = StreamSupport.stream(paesi.spliterator(), false)
                .collect(Collectors.toList());
        assertEquals(paeseOrigineRepository.findAll().size(), paeseOrigineList.size());
        assertTrue(paeseOrigineList.contains(paeseOrigine1));
        assertTrue(paeseOrigineList.contains(paeseOrigine));
    }
}
