package it.unisa.WoodLot.web.control.gestioneStatistiche;

import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.Utente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerStatisticheIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testVisualizzaStatisticheUtente() {
        Utente utente = new Utente();
        utente.setNome("Alessia");
        utente.setCognome("Ture");
        utente.setId(1L);

        ResponseEntity<Object> response = restTemplate.getForEntity("http://localhost:8090/api/statistiche/utente/" + utente.getId(), Object.class);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());

        assertNotNull(response.getBody());
    }

    @Test
    void testVisualizzaStatisticheResponsabile() {
        ResponseEntity<Object> response = restTemplate.getForEntity("http://localhost:8090/api/statistiche/responsabileCatalogo", Object.class);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());

        assertNotNull(response.getBody());
    }

    @Test
    void testStatistichePaginaContadino() {
        Contadino contadino = new Contadino();
        contadino.setId(1L);

        ResponseEntity<Object> response = restTemplate.getForEntity("http://localhost:8090/api/statistiche/contadino/" + contadino.getId(), Object.class);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());

        assertNotNull(response.getBody());
    }

    @Test
    void testStatistichePaginaResponsabileOrdini() {
        ResponseEntity<Object> response = restTemplate.getForEntity("http://localhost:8090/api/statistiche/responsabileOrdini", Object.class);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());

        assertNotNull(response.getBody());
    }
}
