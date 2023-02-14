package it.unisa.WoodLot.service.gestioneCatalogo.catalogo;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import it.unisa.WoodLot.sevice.gestioneCatalogo.catalogo.GestioneCatalogoService;
import it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni.AlberoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Test di unità per la classe GestioneCatalogoService
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CatalogoServiceUT {

    @Mock
    private AlberoRepository alberoRepository;
    @Mock
    private CategoriaRepository categoriaRepository;
    @Mock
    private UsoLocaleRepository usoLocaleRepository;
    @Mock
    private BeneficioRepository beneficioRepository;
    @Mock
    private PaeseOrigineRepository paeseOrigineRepository;
    @InjectMocks
    private GestioneCatalogoService gestioneCatalogoService;

    /**
     * Testa il caso in cui l'albero viene aggiunto con successo al catalogo
     * <p>
     * Il test risulta superato se il prodotto viene aggiunto con successo al catalogo
     */
    @Test
    public void testAggiungiProdotto_Successo() {
        Albero albero = new Albero();
        albero.setNome("Albero 1");

        Categoria categoria = new Categoria();
        categoria.setNome("Categoria 1");
        albero.setCategoria(categoria);
        when(categoriaRepository.findById("Categoria 1")).thenReturn(Optional.of(categoria));

        UsoLocale usoLocale = new UsoLocale();
        usoLocale.setNome("Uso Locale 1");
        List<UsoLocale> usoLocaleList = new ArrayList<>();
        usoLocaleList.add(usoLocale);
        albero.setUsiLocali(usoLocaleList);
        when(usoLocaleRepository.findById("Uso Locale 1")).thenReturn(Optional.of(usoLocale));

        Beneficio beneficio = new Beneficio();
        beneficio.setNome("Beneficio 1");
        List<Beneficio> beneficioList = new ArrayList<>();
        beneficioList.add(beneficio);
        albero.setBenefici(beneficioList);
        when(beneficioRepository.findById("Beneficio 1")).thenReturn(Optional.of(beneficio));

        PaeseOrigine paeseOrigine = new PaeseOrigine();
        paeseOrigine.setNome("Paese Origine 1");
        albero.setPaeseOrigine(paeseOrigine);
        when(paeseOrigineRepository.findById("Paese Origine 1")).thenReturn(Optional.of(paeseOrigine));

        when(alberoRepository.existsById("Albero 1")).thenReturn(false);
        when(alberoRepository.save(albero)).thenReturn(albero);

        try {
            Albero risultato = gestioneCatalogoService.aggiungiProdotto(albero);

            assertNotNull(risultato);
            assertEquals("Albero 1", risultato.getNome());

            verify(categoriaRepository, times(1)).findById("Categoria 1");
            verify(usoLocaleRepository, times(1)).findById("Uso Locale 1");
            verify(beneficioRepository, times(1)).findById("Beneficio 1");
            verify(paeseOrigineRepository, times(1)).findById("Paese Origine 1");
            verify(alberoRepository, times(1)).existsById("Albero 1");
            verify(alberoRepository, times(1)).save(albero);
        } catch (AlberoException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il nome dell'albero è già presente
     * Il test è superato se il messaggio d'errore generato dal sistema è uguale a quello previsto dall'oracolo
     */
    @Test
    void testAggiungiProdotto_nomeEsistente() {
        Albero albero = new Albero();
        albero.setNome("Albero esistente");
        String messaggio = "Questo nome è già presente nel catalogo! Scegline un altro";

        when(alberoRepository.existsById(albero.getNome())).thenReturn(true);

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
        Albero albero = new Albero();
        Categoria categoria = new Categoria();
        categoria.setNome("Categoria non esistente");
        albero.setCategoria(categoria);
        String messaggio = "La categoria fornita non è valida";

        when(categoriaRepository.findById(categoria.getNome())).thenReturn(Optional.empty());

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
        Albero albero = new Albero();

        Categoria categoria = new Categoria();
        categoria.setNome("Categoria 1");
        albero.setCategoria(categoria);
        when(categoriaRepository.findById("Categoria 1")).thenReturn(Optional.of(categoria));

        UsoLocale usoLocale = new UsoLocale();
        usoLocale.setNome("Uso locale non esistente");
        albero.setUsiLocali(Arrays.asList(usoLocale));
        when(usoLocaleRepository.findById(usoLocale.getNome())).thenReturn(Optional.empty());

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

        Albero albero = new Albero();
        Beneficio beneficio = new Beneficio();
        beneficio.setNome("Beneficio non esistente");
        albero.setBenefici(Arrays.asList(beneficio));
        when(beneficioRepository.findById(beneficio.getNome())).thenReturn(Optional.empty());

        Categoria categoria = new Categoria();
        categoria.setNome("Categoria esistente");
        albero.setCategoria(categoria);
        when(categoriaRepository.findById("Categoria esistente")).thenReturn(Optional.of(categoria));

        UsoLocale usoLocale = new UsoLocale();
        usoLocale.setNome("UsoLocale esistente");
        albero.setUsiLocali(Arrays.asList(usoLocale));
        when(usoLocaleRepository.findById(usoLocale.getNome())).thenReturn(Optional.of(usoLocale));

        try {
            gestioneCatalogoService.aggiungiProdotto(albero);
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

        Albero albero = new Albero();
        Beneficio beneficio = new Beneficio();
        beneficio.setNome("Beneficio esistente");
        albero.setBenefici(Arrays.asList(beneficio));
        when(beneficioRepository.findById(beneficio.getNome())).thenReturn(Optional.of(beneficio));

        Categoria categoria = new Categoria();
        categoria.setNome("Categoria esistente");
        albero.setCategoria(categoria);
        when(categoriaRepository.findById("Categoria esistente")).thenReturn(Optional.of(categoria));

        UsoLocale usoLocale = new UsoLocale();
        usoLocale.setNome("UsoLocale esistente");
        albero.setUsiLocali(Arrays.asList(usoLocale));
        when(usoLocaleRepository.findById(usoLocale.getNome())).thenReturn(Optional.of(usoLocale));

        PaeseOrigine paeseOrigine = new PaeseOrigine();
        paeseOrigine.setNome("Paese non esistente");
        albero.setPaeseOrigine(paeseOrigine);
        when(paeseOrigineRepository.findById("Paese non esistente")).thenReturn(Optional.empty());

        try {
            gestioneCatalogoService.aggiungiProdotto(albero);
        } catch (AlberoException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il prodotto viene eliminato correttamente
     * Il test risulta superato se il prodotto viene eliminato correttamente
     */
    @Test
    public void testEliminaProdottoSuccesso() {
        Albero albero = new Albero();
        albero.setNome("Albero 1");

        when(alberoRepository.findById("Albero 1")).thenReturn(Optional.of(albero));

        String idAlbero = albero.getNome();
        try {
            gestioneCatalogoService.eliminaProdotto(idAlbero);
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
        albero.setNome("Albero 1");
        try {
            gestioneCatalogoService.eliminaProdotto(albero.getNome());
            Optional<Albero> result = alberoRepository.findById(albero.getNome());
            assertFalse(result.isPresent());
        } catch (AlberoException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }
}