package it.unisa.WoodLot.web.control.gestioneCatalogo.prodotto;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test d' integrazione per la classe ControllerProdotto
 *
 * @author Alessia Ture
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerProdottoIT {
    @Autowired
    private TestRestTemplate restTemplate;
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

    /**
     * Testa il caso in cui si vuole recuperare le informazioni di un prodotto
     * Il test risulta superato se l'albero viene recuperato correttamente
     */
    @Test
    void testRestituisciProdotto() {
        Albero albero = alberoRepository.findById("Avocado").orElse(null);

        ResponseEntity<Albero> response = restTemplate.getForEntity("http://localhost:8090/api/prodotto/" + albero.getNome(), Albero.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(albero.getNome(), response.getBody().getNome());
    }

    /**
     * Testa il caso in cui si vogliono recuperate l'elenco delle categorie presenti nel database
     * Il test risulta superato se i dati vengono recuperati correttamente
     */
    @Test
    public void testRestituisciCategorie() {
        List<Categoria> categorie = categoriaRepository.findAll();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<List> response = restTemplate.exchange(
                "http://localhost:8090/api/prodotto/categorie", HttpMethod.GET, entity, List.class);
        assertEquals(categorie.size(), response.getBody().size());
    }

    /**
     * Testa il caso in cui si vogliono recuperate l'elenco dei paesi presenti nel database
     * Il test risulta superato se i dati vengono recuperati correttamente
     */
    @Test
    public void testRestituisciPaesi() {
        List<PaeseOrigine> paesi = paeseOrigineRepository.findAll();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<List> response = restTemplate.exchange(
                "http://localhost:8090/api/prodotto/paesi", HttpMethod.GET, entity, List.class);
        assertEquals(paesi.size(), response.getBody().size());
    }

    /**
     * Testa il caso in cui si vogliono recuperate l'elenco degli usi locali presenti nel database
     * Il test risulta superato se i dati vengono recuperati correttamente
     */
    @Test
    public void testRestituisciUsiLocali() {
        List<UsoLocale> usi = usoLocaleRepository.findAll();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<List> response = restTemplate.exchange(
                "http://localhost:8090/api/prodotto/usiLocali", HttpMethod.GET, entity, List.class);
        assertEquals(usi.size(), response.getBody().size());
    }

    /**
     * Testa il caso in cui si vogliono recuperate l'elenco dei benefici presenti nel database
     * Il test risulta superato se i dati vengono recuperati correttamente
     */
    @Test
    public void testRestituisciBenefici() {
        List<Beneficio> benefici = beneficioRepository.findAll();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<List> response = restTemplate.exchange(
                "http://localhost:8090/api/prodotto/benefici", HttpMethod.GET, entity, List.class);
        assertEquals(benefici.size(), response.getBody().size());
    }
}
