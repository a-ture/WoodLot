package it.unisa.WoodLot.web.control.gestioneOrdine.ordini;

import it.unisa.WoodLot.model.entity.Ordine;
import it.unisa.WoodLot.model.repository.OrdineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test d' integrazione per la classe ControllerCarrello
 *
 * @author Alessia Ture
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerOrdiniIT {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private OrdineRepository ordineRepository;

    /**
     * Testa il caso in cui viene recuperato l'elenco degli ordini effettuati
     * Il test risulta superato se vengono recuperati tutti gli ordini
     */
    @Test
    public void testRestituisciOrdini() {
        List<Ordine> ordini = ordineRepository.findAll();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<List> response = restTemplate.exchange(
                "http://localhost:8090/api/ordine/getOrdini",
                HttpMethod.GET, entity, List.class);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(ordini.size(), response.getBody().size());
    }
    /**
     * Testa il caso in cui viene recuperato l'elenco degli ordini effettuati da un utente
     * Il test risulta superato se vengono recuperati tutti gli ordini
     */
    @Test
    public void testVisualizzaOrdiniUtente() {
        Long idUtente = 1L;

        List<Ordine> ordini = ordineRepository.findOrdineByUtente_Id(idUtente);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("idUtente", idUtente);

        ResponseEntity<List> response = restTemplate.exchange(
                "http://localhost:8090/api/ordine/storicoUtente/{idUtente}",
                HttpMethod.GET, entity, List.class, uriVariables);


        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(ordini.size(), response.getBody().size());
    }
}
