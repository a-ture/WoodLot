package it.unisa.WoodLot.web.control.gestioneCatalogo.filtri;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.model.entity.Categoria;
import it.unisa.WoodLot.model.entity.PaeseOrigine;
import it.unisa.WoodLot.model.entity.UsoLocale;
import it.unisa.WoodLot.model.repository.AlberoRepository;
import it.unisa.WoodLot.model.repository.CategoriaRepository;
import it.unisa.WoodLot.model.repository.PaeseOrigineRepository;
import it.unisa.WoodLot.model.repository.UsoLocaleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test d' integrazione per la classe ControllerFiltri
 *
 * @author Alessia Ture
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerFiltriIT {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private AlberoRepository alberoRepository;
    @Autowired
    private PaeseOrigineRepository paeseOrigineRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private UsoLocaleRepository usoLocaleRepository;
    private List<Albero> listaAlberi;

    @BeforeEach()
    void setUp() {
        listaAlberi = alberoRepository.findAll();
    }

    /**
     * Testa il caso un cui si vuole recuperare tutti i prodotti del catalogo
     * Il test risulta superato se vengono recuperati tutti i prodotti del catalogo
     */
    @Test
    public void testRestituisciProdotti() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<List> response = restTemplate.exchange(
                "http://localhost:8090/api/filtri/prodotti", HttpMethod.GET, entity, List.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listaAlberi.size(), response.getBody().size());
    }

    /**
     * Testa il caso un cui si vuole recuperare tutti i prodotti del catalogo ordinanti in base alla anidride carbonica
     * assorbita
     * Il test risulta superato se vengono recuperati tutti i prodotti del catalogo
     */
    @Test
    public void testRestituisciProdottiFiltratiByAnidrideCarbonica() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("anidrideCarbonica", "anidrideDecrescente");

        ResponseEntity<List> response = restTemplate.exchange(
                "http://localhost:8090/api/filtri/filtroAndirideCarbonica/{anidrideCarbonica}", HttpMethod.GET, entity, List.class,
                uriVariables);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listaAlberi.size(), response.getBody().size());
    }

    /**
     * Testa il caso un cui si vuole recuperare tutti i prodotti del catalogo che vengono piantati in determinato paese
     * Il test risulta superato se vengono recuperati tutti i prodotti del catalogo che appartengo al paese in ingresso
     */
    @Test
    public void testRestituisciProdottiFiltratiByPaese() {
        PaeseOrigine paeseOrigine = paeseOrigineRepository.findById("Italia").orElse(null);

        listaAlberi = new ArrayList<>(alberoRepository.findAllByPaeseOrigine(Optional.ofNullable(paeseOrigine)));

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("nomePaese", "Italia");

        ResponseEntity<List> response = restTemplate.exchange(
                "http://localhost:8090/api/filtri//filtroPaese/{nomePaese}", HttpMethod.GET, entity, List.class,
                uriVariables);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listaAlberi.size(), response.getBody().size());
    }

    /**
     * Testa il caso un cui si vuole recuperare tutti i prodotti del catalogo che appartengono a una determinata categoria
     * Il test risulta superato se vengono recuperati tutti i prodotti del catalogo che appartengono alla categoria
     */
    @Test
    public void testRestituisciProdottiFiltratiByCategoria() {
        Categoria categoria = categoriaRepository.findById("Rischio Estinzione").orElse(null);
        listaAlberi = new ArrayList<>(alberoRepository.findAllByCategoria(Optional.ofNullable(categoria)));

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("nomeCategoria", "Rischio Estinzione");

        ResponseEntity<List> response = restTemplate.exchange(
                "http://localhost:8090/api/filtri/filtroCategoria/{nomeCategoria}", HttpMethod.GET, entity, List.class,
                uriVariables);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listaAlberi.size(), response.getBody().size());
    }

    /**
     * Testa il caso un cui si vuole recuperare tutti i prodotti del catalogo ordinanti in base al prezzo
     * assorbita
     * Il test risulta superato se vengono recuperati tutti i prodotti del catalogo
     */
    @Test
    public void testRestituisciProdottiFiltratiByPrezzo() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("prezzo", "prezzoCrescente");

        ResponseEntity<List> response = restTemplate.exchange(
                "http://localhost:8090/api/filtri/filtroPrezzo/{prezzo}", HttpMethod.GET, entity, List.class,
                uriVariables);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listaAlberi.size(), response.getBody().size());
    }

    /**
     * Testa il caso un cui si vuole recuperare tutti i prodotti del catalogo che hanno un uso locale
     * Il test risulta superato se vengono recuperati tutti i prodotti del catalogo che hanno l'uso locale
     */
    @Test
    public void testRestituisciProdottiFiltratiByUsiLocali() {
        UsoLocale usoLocale = usoLocaleRepository.findById("Allevamento").orElse(null);
        listaAlberi = new ArrayList<>(alberoRepository.findAllByUsiLocali(Optional.ofNullable(usoLocale)));

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("nomeUsoLocale", "Allevamento");

        ResponseEntity<List> response = restTemplate.exchange(
                "http://localhost:8090/api/filtri/filtroUsoLocale/{nomeUsoLocale}", HttpMethod.GET, entity, List.class,
                uriVariables);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listaAlberi.size(), response.getBody().size());
    }
}