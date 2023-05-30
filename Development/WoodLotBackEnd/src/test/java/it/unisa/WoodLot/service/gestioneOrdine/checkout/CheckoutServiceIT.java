package it.unisa.WoodLot.service.gestioneOrdine.checkout;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import it.unisa.WoodLot.sevice.gestioneOrdine.checkout.GestioneCheckoutService;
import it.unisa.WoodLot.sevice.gestioneOrdine.eccezioni.OrdineException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test d'integrazione fra la classe GestioneCheckoutService e la repository.
 *
 * @author Alessia Ture
 */
@SpringBootTest
@Transactional
@Rollback
@ExtendWith(SpringExtension.class)
public class CheckoutServiceIT {


    @Autowired
    private CarrelloRepository carrelloRepository;
    @Autowired
    private ProdottoCarrelloRepository prodottoCarrelloRepository;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private AlberoRepository alberoRepository;
    @Autowired
    private UsoLocaleRepository usoLocaleRepository;
    @Autowired
    private PaeseOrigineRepository paeseOrigineRepository;
    @Autowired
    private BeneficioRepository beneficioRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private GestioneCheckoutService gestioneCheckoutService;

    /**
     * Testa il caso in cui l'ordine viene effettuato con successo
     * Il test risulta superato se l'ordine viene creato
     */
    @Test
    public void effettuaOrdineSuccesso() {
       Utente utente = utenteRepository.findById(6L).orElse(null);

        Carrello carrello = new Carrello();
        carrello.setUtente(utente);
        carrello = carrelloRepository.save(carrello);

        ProdottoCarrello prodottoCarrello = new ProdottoCarrello();
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
        prodottoCarrello.setAlbero(albero);

        prodottoCarrello = prodottoCarrelloRepository.save(prodottoCarrello);
        carrello.aggiungiProdottoCarrello(prodottoCarrello);
        carrelloRepository.save(carrello);

        Ordine ordine = gestioneCheckoutService.effettuareOrdine(utente.getId());

        assertNotNull(ordine);
        assertEquals(LocalDate.now(), ordine.getDataOrdine());
        assertNotNull(ordine.getUtente());
        assertEquals(utente.getId(), ordine.getUtente().getId());
        assertNotNull(ordine.getProdottiOrdine());
        assertEquals(1, ordine.getProdottiOrdine().size());
        ProdottoOrdine prodottoOrdine = ordine.getProdottiOrdine().get(0);
        assertNotNull(prodottoOrdine);
        assertEquals(albero.getAnidrideCarbonicaAssorbita(), prodottoOrdine.getAnidrideCarbonicaAssorbita(), 0.0);
        assertEquals(albero.getNome(), prodottoOrdine.getNomeAlbero());
        assertEquals(albero.getPrezzo(), prodottoOrdine.getPrezzoUnitario(), 0.0);
        assertEquals(ProdottoOrdine.Stato.NonAssegnato, prodottoOrdine.getStato());

    }

    /**
     * Testa il caso in cui l'id dell utente non corrisponde a nessun utente
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    void effettuareOrdineUtenteNullo() {
        Utente utente = new Utente();
        utente.setId(234L);
        String messaggio = "L'utente non è stato trovato";
        try {
            gestioneCheckoutService.effettuareOrdine(utente.getId());
        } catch (OrdineException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }


    /**
     * Testa il caso in cui l'id dell carrello non corrisponde a nessun carrello
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    void effettuareOrdineCarrelloNullo() {
        String messaggio = "Il tuo carrello è nullo";
        Utente utente = new Utente();
        utente.setNome("John");
        utente.setCognome("Doe");
        utente.setEmail("john5677.doe@example.com");
        utente.setPassword("password");
        utente = utenteRepository.save(utente);

        Carrello carrello = new Carrello();
        carrello.setUtente(utente);
        try {
            gestioneCheckoutService.effettuareOrdine(utente.getId());
        } catch (OrdineException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il carrello è vuoto
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    void carrelloVuoto() {
        String messaggio = "Il tuo carrello è vuoto! Aggiungi degli alberi prima di continuare";
        Utente utente = new Utente();
        utente.setNome("John");
        utente.setCognome("Doe");
        utente.setEmail("johnnn.doe@example.com");
        utente.setPassword("password");
        utente = utenteRepository.save(utente);

        Carrello carrello = new Carrello();
        carrello.setUtente(utente);
        carrelloRepository.save(carrello);

        try {
            gestioneCheckoutService.effettuareOrdine(utente.getId());
        } catch (OrdineException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }
}
