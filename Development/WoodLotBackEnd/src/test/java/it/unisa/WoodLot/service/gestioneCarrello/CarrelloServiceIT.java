package it.unisa.WoodLot.service.gestioneCarrello;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import it.unisa.WoodLot.sevice.gestioneCarrello.CarrelloService;
import it.unisa.WoodLot.sevice.gestioneCarrello.eccezzioni.CarrelloException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.Date;


import static org.junit.jupiter.api.Assertions.*;


/**
 * Test d'integrazione fra la classe GestioneCarrelloService e la repository.
 *
 * @author Alessia Ture
 */
@SpringBootTest
@Transactional
@Rollback
@ExtendWith(SpringExtension.class)
public class CarrelloServiceIT {

    @Autowired
    private CarrelloRepository carrelloRepository;
    @Autowired
    private AlberoRepository alberoRepository;
    @Autowired
    private UsoLocaleRepository usoLocaleRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private BeneficioRepository beneficioRepository;
    @Autowired
    private PaeseOrigineRepository paeseOrigineRepository;
    @Autowired
    private ProdottoCarrelloRepository prodottoCarrelloRepository;
    @Autowired
    private CarrelloService carrelloService;
    @Autowired
    private UtenteRepository utenteRepository;

    private Albero albero;
    private Carrello carrello;

    @BeforeEach
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

        albero = new Albero();
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

        carrello = new Carrello();
        carrello = carrelloRepository.save(carrello);
    }

    /**
     * Testa il caso in cui l'utente non ha un carrello e ne viene creato uno nuovo
     * <p>
     * Il test è superato se il carrello viene creato correttamente
     */
    @Test
    public void getNuovoCarrelloConSuccesso() {
        Utente utente = new Utente();
        utente.setPassword("password");
        utente.setEmail("utente@gmail.com");
        utente.setNome("Utente");
        utente.setDataDiNascita(new Date());
        utente.setCognome("Cognome");

        utente = utenteRepository.save(utente);

        try {
            Carrello result = carrelloService.getCarrello(utente.getId());
            assertNotNull(result);
            assertEquals(utente, result.getUtente());

        } catch (CarrelloException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso in cui l'utente ha un carrello
     * <p>
     * Il test è superato se il carrello viene recuperato con successo
     */
    @Test
    public void getCarrelloConSuccesso() {
        Utente utente = new Utente();
        utente.setPassword("password");
        utente.setEmail("utente@gmail.com");
        utente.setNome("Utente");
        utente.setDataDiNascita(new Date());
        utente.setCognome("Cognome");

        utente = utenteRepository.save(utente);
        carrello.setUtente(utente);
        carrelloRepository.save(carrello);

        try {
            Carrello result = carrelloService.getCarrello(utente.getId());
            assertNotNull(result);
            assertEquals(carrello, result);

        } catch (CarrelloException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il recupero del carrello di un utente avviene con successo
     * (in questo caso il carrello esiste)
     * <p>
     * Il test è superato se il carrello viene visualizzato con successo
     */
    @Test
    public void getCarrelloConInsuccesso() {
        String messaggio = "L'idUtente fornito non risulta associato a nessun utente";
        try {
            carrelloService.getCarrello(989L);
        } catch (CarrelloException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il l'id dell'utente fornito non è valido
     * <p>
     * Il test è superato se il messaggio d'errore generato dal sistema è uguale a quello previsto dall'oracolo
     */
    @Test
    public void testGetCarrelloCarrelloNotFound() {
        Long idUtente = 1689L;
        String messaggio = "L'idUtente fornito non risulta associato a nessun utente";
        try {
            carrelloService.getCarrello(idUtente);
        } catch (CarrelloException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui un prodotto viene aggiunto correttamente al carrello
     * <p>
     * Il test è superato se il prodotto viene aggiunto al carrello
     */
    @Test
    public void testAggiungiProdottoSuccesso() {
        try {
            Carrello carrelloConProdotto = carrelloService.aggiungiProdotto(carrello.getId(), albero.getNome());

            assertNotNull(carrelloConProdotto);
            assertEquals(1, carrelloConProdotto.getProdottiCarrello().size());
            assertEquals(albero.getNome(), carrelloConProdotto.getProdottiCarrello().get(0).getAlbero().getNome());
        } catch (CarrelloException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso in cui l'id dell albero da aggiungere al carrello non è valido
     * <p>
     * Il test è superato se il messaggio d'errore generato dal sistema è uguale a quello previsto dall'oracolo
     */
    @Test
    public void aggiungiProdottoCarrelloAlberoNull() {
        String messaggio = "L'albero non è stato trovato";
        Albero albero = new Albero();
        albero.setNome("AceroNonEsiste");
        try {
            carrelloService.aggiungiProdotto(carrello.getId(), "AceroNonEsiste");
        } catch (CarrelloException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il l'id del carrello fornito non è valido
     * <p>
     * Il test è superato se il messaggio d'errore generato dal sistema è uguale a quello previsto dall'oracolo
     */
    @Test
    public void aggiungiProdottoCarrelloCarrelloNull() {
        String messaggio = "Il carrello non  è stato trovato";
        try {
            carrelloService.aggiungiProdotto(100L, albero.getNome());
        } catch (CarrelloException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui si vuole aggiungere al carrello un prodotto già presente
     * <p>
     * Il test è superato se il messaggio d'errore generato dal sistema è uguale a quello previsto dall'oracolo
     */
    @Test
    public void aggiungiProdottoCarrelloPresente() {
        String messaggio = "Il prodotto è già presente nel carrello";
        try {
            carrelloService.aggiungiProdotto(carrello.getId(), albero.getNome());
            carrelloService.aggiungiProdotto(carrello.getId(), albero.getNome());
        } catch (CarrelloException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il carrello viene svuotato con successo
     * <p>
     * Il test è superato se il carrello viene svuotato con successo
     */
    @Test
    public void svuotaCarrelloSuccesso() {
        ProdottoCarrello prodottoCarrello = new ProdottoCarrello();
        prodottoCarrello.setAlbero(albero);
        carrello.aggiungiProdottoCarrello(prodottoCarrello);
        carrello = carrelloRepository.save(carrello);
        prodottoCarrello = prodottoCarrelloRepository.save(prodottoCarrello);
        try {
            Carrello result = carrelloService.svuotareCarrello(carrello.getId());
            assertNotEquals(carrello.getProdottiCarrello().size(), result.getProdottiCarrello().size());
        } catch (CarrelloException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso in cui l'id del carrello non è valido
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void svuotaCarrelloInsuccesso() {
        String messaggio = "Carrello non trovato";
        try {
            carrelloService.svuotareCarrello(34L);
        } catch (CarrelloException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui un prodotto viene rimosso con un successo
     * <p>
     * Il prodotto viene eliminato
     */
    @Test
    public void testRimuoviProdottoSuccesso() {
        ProdottoCarrello prodottoCarrello = new ProdottoCarrello();
        prodottoCarrello.setAlbero(albero);
        carrello.aggiungiProdottoCarrello(prodottoCarrello);
        prodottoCarrello = prodottoCarrelloRepository.save(prodottoCarrello);

        try {
            Carrello result = carrelloService.rimuoviProdotto(carrello.getId(), prodottoCarrello.getId());
            assertNotNull(result);
            assertEquals(0, result.getProdottiCarrello().size());
            assertFalse(prodottoCarrelloRepository.existsById(prodottoCarrello.getId()));
        } catch (CarrelloException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso in cui l'id del prodotto fornito non è valido
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testRimuoviProdottoNull() {
        String messaggio = "L'id del prodotto fornito non è valido";
        ProdottoCarrello prodottoCarrello = new ProdottoCarrello();
        prodottoCarrello.setAlbero(albero);
        carrello.aggiungiProdottoCarrello(prodottoCarrello);
        carrello = carrelloRepository.save(carrello);
        prodottoCarrello = prodottoCarrelloRepository.save(prodottoCarrello);
        try {
            carrelloService.rimuoviProdotto(carrello.getId(), 2892L);
        } catch (CarrelloException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui l'id del carrello fornito non è valido
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testRimuoviCarrelloNull() {
        String messaggio = "Il carrello non  è stato trovato";
        ProdottoCarrello prodottoCarrello = new ProdottoCarrello();
        prodottoCarrello.setAlbero(albero);
        carrello.aggiungiProdottoCarrello(prodottoCarrello);
        carrello = carrelloRepository.save(carrello);
        prodottoCarrello = prodottoCarrelloRepository.save(prodottoCarrello);
        try {
            carrelloService.rimuoviProdotto(222L, prodottoCarrello.getId());
        } catch (CarrelloException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }
}
