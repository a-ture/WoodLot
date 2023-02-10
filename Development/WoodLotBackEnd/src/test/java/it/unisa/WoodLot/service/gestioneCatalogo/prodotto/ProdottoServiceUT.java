package it.unisa.WoodLot.service.gestioneCatalogo.prodotto;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni.AlberoException;
import it.unisa.WoodLot.sevice.gestioneCatalogo.prodotto.GestioneProdottoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

/**
 * Test di unità per la classe GestioneProdottoService
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProdottoServiceUT {
    @InjectMocks
    private GestioneProdottoService gestioneProdottoService;
    @Mock
    private AlberoRepository alberoRepository;
    @Mock
    private CategoriaRepository categoriaRepository;
    @Mock
    private BeneficioRepository beneficioRepository;
    @Mock
    private UsoLocaleRepository usoLocaleRepository;
    @Mock
    private PaeseOrigineRepository paeseOrigineRepository;

    /**
     * Testa il caso in cui il prodotto viene trovato con successo
     *
     * @result il test è superato se è possibile trovare il prodotto
     */
    @Test
    public void testGetProdottoSuccesso() {
        Albero albero = new Albero();
        albero.setNome("Albero di pino");
        when(alberoRepository.findById("Albero di pino")).thenReturn(Optional.of(albero));

        try {
            Albero result = gestioneProdottoService.getProdotto("Albero di pino");
            assertEquals("Albero di pino", result.getNome());
        } catch (AlberoException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso im cui il prodotto non viene trovato
     *
     * @@result Il test è superato se il messaggio generato dal sistema è uguale a quello
     * *previsto dall'oracolo.
     */
    @Test
    public void testGetProdottoInsuccesso() {
        Albero albero = new Albero();
        albero.setNome("Albero di pino");
        String messaggio = "L'albero non è stato trovato";
        when(alberoRepository.findById("Albero di pino")).thenReturn(Optional.empty());

        try {
            gestioneProdottoService.getProdotto("Albero di pino");
        } catch (AlberoException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il recupero con successo delle categorie
     */
    @Test
    void testGetCategorie() {
        List<Categoria> categorie = new ArrayList<>();
        Categoria categoria1 = new Categoria();
        categoria1.setNome("1");
        categoria1.setDescrizione("String");
        categorie.add(categoria1);

        Categoria categoria2 = new Categoria();
        categoria2.setNome("2");
        categoria2.setDescrizione("String");
        categorie.add(categoria2);

        when(categoriaRepository.findAll()).thenReturn(categorie);

        Iterable<Categoria> result = gestioneProdottoService.getCategorie();

        assertEquals(2, StreamSupport.stream(result.spliterator(), false).count());
    }


    /**
     * Testa il caso in cui i benefici sono visualizzati con successo
     */
    @Test
    void testGetBenefici() {
        List<Beneficio> benefici = new ArrayList<>();
        Beneficio beneficio1 = new Beneficio();
        beneficio1.setNome("1");
        beneficio1.setDescrizione("String");
        benefici.add(beneficio1);

        Beneficio benefici2 = new Beneficio();
        benefici2.setNome("2");
        benefici2.setDescrizione("String");
        benefici.add(benefici2);

        when(beneficioRepository.findAll()).thenReturn(benefici);

        Iterable<Beneficio> result = gestioneProdottoService.getBenefici();

        assertEquals(2, StreamSupport.stream(result.spliterator(), false).count());
    }

    /**
     * Testa il caso in cui gli usi locali sono visualizzati con successo
     */
    @Test
    void testGetUsiLocali() {
        List<UsoLocale> usiLocali = new ArrayList<>();
        UsoLocale usoLocale1 = new UsoLocale();
        usoLocale1.setNome("1");
        usoLocale1.setDescrizione("String");
        usiLocali.add(usoLocale1);

        UsoLocale usoLocale2 = new UsoLocale();
        usoLocale2.setNome("2");
        usoLocale2.setDescrizione("String");
        usiLocali.add(usoLocale2);

        when(usoLocaleRepository.findAll()).thenReturn(usiLocali);

        Iterable<UsoLocale> result = gestioneProdottoService.getUsiLocali();

        assertEquals(2, StreamSupport.stream(result.spliterator(), false).count());
    }

    /**
     * Testa il caso in cui i paesi sono visualizzati con successo
     */
    @Test
    void testGetPaesi() {
        List<PaeseOrigine> paesi = new ArrayList<>();
        PaeseOrigine paeseOrigine1 = new PaeseOrigine();
        paeseOrigine1.setNome("1");
        paeseOrigine1.setDescrizione("String");
        paesi.add(paeseOrigine1);

        PaeseOrigine paeseOrigine2 = new PaeseOrigine();
        paeseOrigine2.setNome("2");
        paeseOrigine2.setDescrizione("String");
        paesi.add(paeseOrigine2);

        when(paeseOrigineRepository.findAll()).thenReturn(paesi);

        Iterable<PaeseOrigine> result = gestioneProdottoService.getPaesiDiOrigine();

        assertEquals(2, StreamSupport.stream(result.spliterator(), false).count());
    }
}
