package it.unisa.WoodLot.web.control.gestioneContadino.aggiornaStato;

import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.ProdottoOrdine;
import it.unisa.WoodLot.model.repository.ContadinoRepository;
import it.unisa.WoodLot.model.repository.ProdottoOrdineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Test d' integrazione per la classe ControllerCarrello
 *
 * @author Alessia Ture
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerContadinoIT {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private ProdottoOrdineRepository prodottoOrdineRepository;
    @Autowired
    private ContadinoRepository contadinoRepository;

    /**
     * Testa il caso in cui si vuole recuperare l'elenco dei contadini
     * Il test è superato se vengono recuperati tutti i contadini
     */
    @Test
    public void testVisualizzaElencoContadini() {
        List<Contadino> contadini = contadinoRepository.findAll();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<List> response = restTemplate.exchange(
                "http://localhost:8090/api/contadino",
                HttpMethod.GET, entity, List.class);

        assertEquals(contadini.size(), response.getBody().size());
    }

    /**
     * Testa il caso in cui si vuole aggiornare lo stato di un albero con successo
     * Il test è superato se lo stato viene aggiornato con successo
     */
    @Test
    @Transactional
    public void testAggiornaStato() {
        ProdottoOrdine prodottoOrdine = prodottoOrdineRepository.findById(1L).orElse(null);

        ResponseEntity<ProdottoOrdine> response = restTemplate.postForEntity(
                "http://localhost:8090/api/contadino/aggiornaStato", prodottoOrdine, ProdottoOrdine.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        ProdottoOrdine result = response.getBody();
        assertEquals(prodottoOrdine.getStato(), result.getStato());
    }

    /**
     * Testa il caso in cui si vuole aggiornare lo stato di un albero ma si verifica un errore
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    public void testAggiornaStatoInsuccesso() {
        ProdottoOrdine prodottoOrdine = new ProdottoOrdine();
        prodottoOrdine.setId(-9L);
        prodottoOrdine.setStato(ProdottoOrdine.Stato.NonAssegnato);

        ResponseEntity<ProdottoOrdine> response = restTemplate.postForEntity(
                "http://localhost:8090/api/contadino/aggiornaStato", prodottoOrdine, ProdottoOrdine.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    /**
     * Testa il caso in cui si vuole recuperare l'elenco degli alberi che si trovano nello stato non assegnato
     * Il test è superato se vengono recuperati tutti gli alberi
     */
    @Test
    public void testElencoAlberiNonAssegnati() {
        List<ProdottoOrdine> alberiNonAssegnati = (List<ProdottoOrdine>) prodottoOrdineRepository.findAllByStatoIs(ProdottoOrdine.Stato.NonAssegnato);
        String url = "http://localhost:8090/api/contadino/alberiNonAssegnati";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, entity, List.class);

        assertEquals(alberiNonAssegnati.size(), response.getBody().size());
    }
}
