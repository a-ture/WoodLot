package it.unisa.WoodLot.web.control.gestioneOrdine.checkout;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Test d' integrazione per la classe ControllerCheckout
 *
 * @author Alessia Ture
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerCheckoutIT {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private CarrelloRepository carrelloRepository;
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
    private ProdottoCarrelloRepository prodottoCarrelloRepository;

    /**
     * Testa il caso in cui il checkout viene effettuato correttamente
     * Il test è superato se l'ordine viene effettuato correttamente
     */
    @Test
    void testEffettuareOrdine() {
        Utente utente = new Utente();
        utente.setNome("John");
        utente.setCognome("Doe");
        utente.setDataDiNascita(new Date());
        utente.setEmail("john.doe@example.com");
        utente.setPassword("password");
        utente = utenteRepository.save(utente);

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

        HttpEntity<Long> request = new HttpEntity<>(utente.getId());

        ResponseEntity<Ordine> response = restTemplate.postForEntity("http://localhost:8090/checkout", request, Ordine.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(carrello.getProdottiCarrello().size(), response.getBody().getProdottiOrdine().size());
    }

    /**
     * Testa il caso in cui il checkout fallisce a causa di un errore nel recupero del utente
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo
     */
    @Test
    void testEffettuareOrdineUtenteNonValido() {
        String errorMessage = "L'utente non è stato trovato";

        Long idUtente = -1L;
        HttpEntity<Long> request = new HttpEntity<>(idUtente);

        ResponseEntity<Object> response = restTemplate.postForEntity("http://localhost:8090/checkout", request, Object.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(errorMessage, ((Map) response.getBody()).get("data"));
    }

    /**
     * Testa il caso in cui il checkout fallisce a causa di un errore nel recupero del carrello
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo
     */
    @Test
    void testEffettuareOrdineCarrelloNullo() {
        String errorMessage = "Il tuo carrello è nullo";

        Long idUtente = 1L;
        HttpEntity<Long> request = new HttpEntity<>(idUtente);

        ResponseEntity<Object> response = restTemplate.postForEntity("http://localhost:8090/checkout", request, Object.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(errorMessage, ((Map) response.getBody()).get("data"));
    }
}
