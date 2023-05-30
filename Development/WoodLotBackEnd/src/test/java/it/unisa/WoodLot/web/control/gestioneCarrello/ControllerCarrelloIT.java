package it.unisa.WoodLot.web.control.gestioneCarrello;


import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Test d'integrazione per la classe ControllerCarrello
 *
 * @author Alessia Ture
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerCarrelloIT {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private CarrelloRepository carrelloRepository;
    @Autowired
    private ProdottoCarrelloRepository prodottoCarrelloRepository;
    @Autowired
    private PaeseOrigineRepository paeseOrigineRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private UsoLocaleRepository usoLocaleRepository;
    @Autowired
    private BeneficioRepository beneficioRepository;
    @Autowired
    private AlberoRepository alberoRepository;
    @Autowired
    private UtenteRepository utenteRepository;
    private Albero albero;
    private Carrello carrello;
    private Utente utente;

    @BeforeAll
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

        utente = new Utente();
        utente.setPassword("briciolina");
        utente.setNome("Test");
        utente.setCognome("Test");
        utente.setEmail("test@test.com");
        utente = utenteRepository.save(utente);

        carrello = new Carrello();
        carrello.setUtente(utente);
        carrello = carrelloRepository.save(carrello);
    }

    /**
     * Testa il caso in cui viene aggiunto un prodotto al carrello con successo
     * <p>
     * Il test è superato se il prodotto viene aggiunto con successo
     */
    @Test
    void testAggiungiProdottoSuccesso() {
        ProdottoCarrello prodottoCarrello = new ProdottoCarrello();
        prodottoCarrello.setAlbero(albero);

        String url = "http://localhost:8090/api/carrello/aggiungiProdotto/{nomeAlbero}/{idCarrello}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("nomeAlbero", albero.getNome());
        uriVariables.put("idCarrello", carrello.getId().toString());

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Carrello> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, requestEntity, Carrello.class, uriVariables);

        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        carrello.aggiungiProdottoCarrello(prodottoCarrello);
        assertEquals(carrello.getProdottiCarrello().get(0).getAlbero().getNome(),
                responseEntity.getBody().getProdottiCarrello().get(0).getAlbero().getNome());
    }

    /**
     * Testa il caso in cui si vuole aggiungere un prodotto al carrello ma si verifica un eccezione
     * <p>
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    void testAggiungiProdottoCarrelloNonValido() {
        String url = "http://localhost:8090/api/carrello/aggiungiProdotto/{nomeAlbero}/{idCarrello}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("nomeAlbero", albero.getNome());
        uriVariables.put("idCarrello", -67L + "");

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Carrello> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, requestEntity, Carrello.class, uriVariables);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    /**
     * Testa il caso in cui si vuole aggiungere un prodotto al carrello ma si verifica un eccezione
     * <p>
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    void testAggiungiProdottoNomeAlberoNonValido() {
        String url = "http://localhost:8090/api/carrello/aggiungiProdotto/{nomeAlbero}/{idCarrello}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("nomeAlbero", "Nome non valido");
        uriVariables.put("idCarrello", carrello.getId().toString());

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Carrello> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, requestEntity, Carrello.class, uriVariables);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    /**
     * Testa il caso in cui il carrello viene svuotato con successo
     * <p>
     * Il test è superato se il carrello viene svuotato con successo
     */
    @Test
    void testSvuotareCarrelloSuccesso() {
        ProdottoCarrello prodottoCarrello = new ProdottoCarrello();
        prodottoCarrello.setAlbero(albero);

        String url = "http://localhost:8090/api/carrello/svuotareCarrello/{idCarrello}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("idCarrello", carrello.getId());

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Carrello> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, requestEntity, Carrello.class, uriVariables);

        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        assertEquals(0, responseEntity.getBody().getProdottiCarrello().size());
    }

    /**
     * Testa il caso in cui si vuole svuotare il carrello ma si verifica un eccezione
     * <p>
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    void testSvuotareCarrelloInsuccesso() {
        ProdottoCarrello prodottoCarrello = new ProdottoCarrello();
        prodottoCarrello.setAlbero(albero);

        String url = "http://localhost:8090/api/carrello/svuotareCarrello/{idCarrello}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("idCarrello", -1L);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Carrello> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, requestEntity, Carrello.class, uriVariables);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    /**
     * Testa il caso in cui un prodotto viene rimosso con un successo
     * <p>
     * Il prodotto viene eliminato
     */
    @Test
    void testRimuoviProdottoSuccesso() {
        ProdottoCarrello prodottoCarrello = new ProdottoCarrello();
        prodottoCarrello.setAlbero(albero);
        prodottoCarrello = prodottoCarrelloRepository.save(prodottoCarrello);
        carrello.aggiungiProdottoCarrello(prodottoCarrello);
        carrello = carrelloRepository.save(carrello);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("idCarrello", carrello.getId());
        uriVariables.put("idProdottoCarrello", prodottoCarrello.getId());

        String url = "http://localhost:8090/api/carrello/rimuoviProdotto/{idCarrello}/{idProdottoCarrello}/";
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<Carrello> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, requestEntity, Carrello.class, uriVariables);

        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());

        Carrello carrelloRisposta = responseEntity.getBody();
        assertEquals(carrello.getProdottiCarrello().size() - 1, carrelloRisposta.getProdottiCarrello().size());
    }

    /**
     * Testa il caso in cui si vuole rimuovere un prodotto dal carrello ma si verifica un eccezione
     * <p>
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    void testRimuoviProdottoCarrelloNonTrovato() {
        Long idCarrelloNonValido = 100L;

        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                "http://localhost:8090/api/carrello/rimuoviProdotto/{idCarrello}/{idProdottoCarrello}/",
                HttpMethod.GET, null, Object.class,
                idCarrelloNonValido, 1L);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    /**
     * Testa il caso in cui si vuole rimuovere un prodotto dal carrello ma si verifica un eccezione
     * <p>
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    void testRimuoviProdottoProdottoNonTrovato() {
        Long idProdottoNonValido = 100L;

        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                "http://localhost:8090/api/carrello/rimuoviProdotto/{idCarrello}/{idProdottoCarrello}/",
                HttpMethod.GET, null, Object.class,
                carrello.getId(), idProdottoNonValido);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    /**
     * Testa il caso in cui il recupero del carrello di un utente avviene con successo
     * <p>
     * Il test è superato se il carrello viene visualizzato con successo
     */
    @Test
    void testVisualizzareCarrelloSuccesso() {
        ProdottoCarrello prodottoCarrello = new ProdottoCarrello();
        prodottoCarrello.setAlbero(albero);

        String url = "http://localhost:8090/api/carrello/{idUtente}";

        Map<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("idUtente", utente.getId());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<Carrello> responseEntity = restTemplate.exchange(
                url, HttpMethod.GET, requestEntity, Carrello.class, uriVariables);

        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        assertEquals(carrello.getId(), responseEntity.getBody().getId());
    }

    /**
     * Testa il caso in cui si vuole visualizzare un carrello ma si verifica un eccezione
     * <p>
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    void testVisualizzaCarrelloInsuccesso() {
        Long idUtenteNonValido = -1L;
        ResponseEntity<Carrello> responseEntity = restTemplate.getForEntity("http://localhost:8090/api/carrello/{idUtente}", Carrello.class, idUtenteNonValido);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}