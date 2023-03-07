package it.unisa.WoodLot.service.gestioneCatalogo.catalogo;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import it.unisa.WoodLot.sevice.gestioneCatalogo.catalogo.GestioneCatalogoService;
import it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni.AlberoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test d'integrazione fra la classe GestioneCatalogoService e la repository.
 *
 * @author Alessia Ture
 */
@SpringBootTest
@Transactional
@Rollback
@ExtendWith(SpringExtension.class)
public class CatalogoServiceIT {

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
    private GestioneCatalogoService gestioneCatalogoService;

    /**
     * Testa il caso in cui l'albero viene aggiunto con successo al catalogo
     * Il test risulta superato se il prodotto viene aggiunto con successo al catalogo
     */
    @Test
    public void testAggiungiProdottoSuccesso() {
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
        albero.setNome("Albero di Natale34");
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
        try {
            Albero savedAlbero = gestioneCatalogoService.aggiungiProdotto(albero);
            assertEquals(savedAlbero, albero);
        } catch (AlberoException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il nome dell'albero è già presente
     * <p>
     * Il test risulta superato se il messaggio d'errore generato dal sistema corrisponde all'oracolo
     */
    @Test
    void testAggiungiProdotto_nomeEsistente() {
        String messaggio = "Questo nome è già presente nel catalogo! Scegline un altro";
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
        albero.setNome("Albero di Natale489");
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
        alberoRepository.save(albero);
        try {
            gestioneCatalogoService.aggiungiProdotto(albero);
        } catch (AlberoException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui la categoria non è valida
     * <p>
     * Il test è superato se il messaggio d'errore generato dal sistema è uguale a quello previsto dall'oracolo
     */
    @Test
    void aggiungiProdotto_categoriaInvalida() {
        String messaggio = "La categoria fornita non è valida";
        PaeseOrigine paeseOrigine = new PaeseOrigine();
        paeseOrigine.setNome("Paese 1");
        paeseOrigine.setDescrizione("string");
        paeseOrigineRepository.save(paeseOrigine);

        Categoria categoria = new Categoria();
        categoria.setNome("Categoria 1");
        categoria.setDescrizione("string");

        UsoLocale usoLocale = new UsoLocale();
        usoLocale.setNome("Uso locale 1");
        usoLocale.setDescrizione("string");
        usoLocaleRepository.save(usoLocale);

        Beneficio beneficio = new Beneficio();
        beneficio.setNome("Beneficio");
        beneficio.setDescrizione("string");
        beneficioRepository.save(beneficio);

        Albero albero = new Albero();
        albero.setNome("Albero di Natale4546");
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
        try {
            gestioneCatalogoService.aggiungiProdotto(albero);
        } catch (AlberoException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui l'uso locale non è valido
     * Il test è superato se il messaggio d'errore generato dal sistema è uguale a quello previsto dall'oracolo
     */
    @Test
    void aggiungiProdotto_usoLocaleInvalido() {
        String messaggio = "L'uso locale fornito non è valido";
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

        Beneficio beneficio = new Beneficio();
        beneficio.setNome("Beneficio");
        beneficio.setDescrizione("string");
        beneficioRepository.save(beneficio);

        Albero albero = new Albero();
        albero.setNome("Albero di Natale33545");
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
        try {
            gestioneCatalogoService.aggiungiProdotto(albero);
        } catch (AlberoException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il beneficio non è valido
     * <p>
     * Il test è superato se il messaggio d'errore generato dal sistema è uguale a quello previsto dall'oracolo
     */
    @Test
    public void testAggiungiProdotto_beneficioInvalido() {
        String messaggio = "Il beneficio fornito non è valido";
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

        Albero albero = new Albero();
        albero.setNome("Albero di Natale86");
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
        try {
            Albero savedAlbero = gestioneCatalogoService.aggiungiProdotto(albero);
            assertEquals(savedAlbero, albero);
        } catch (AlberoException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il paese non è valido
     * <p>
     * Il test è superato se il messaggio d'errore generato dal sistema è uguale a quello previsto dall'oracolo
     */
    @Test
    public void testAggiungiProdotto_PaeseInvalido() {
        String messaggio = "Il paese fornito non è valido";
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
        albero.setNome("Albero di Natale23");
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

        try {
            Albero savedAlbero = gestioneCatalogoService.aggiungiProdotto(albero);
            assertEquals(savedAlbero, albero);
        } catch (AlberoException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il prodotto viene eliminato correttamente
     * Il test risulta superato se il prodotto viene eliminato correttamente
     */
    @Test
    public void testEliminaProdotto() {
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
        albero.setNome("Albero di Natale4");
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

        alberoRepository.save(albero);
        try {
            gestioneCatalogoService.eliminaProdotto(albero.getNome());
            assertFalse(alberoRepository.existsById(albero.getNome()));
        } catch (AlberoException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso in cui viene fornito un id non valido
     * Il test è superato se il messaggio d'errore generato dal sistema è uguale a quello previsto dall'oracolo
     */
    @Test
    public void testEliminaProdottoInsuccesso() {
        String messaggio = "L'id fornito non è associato a nessun albero";
        Albero albero = new Albero();
        albero.setNome("albero4656");
        try {
            gestioneCatalogoService.eliminaProdotto(albero.getNome());
        } catch (AlberoException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }
}
