package it.unisa.WoodLot.web.control.gestioneUtente.registrazione;

import it.unisa.WoodLot.model.entity.Utente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerRegistrazioneIT {
    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Testa il caso in cui un utente effettua correttamente la registrazione
     * Il test è superato se l'utente viene registrato correttamente
     */
    @Test
    void testRegistrazione() {
        Utente utente = new Utente();
        utente.setNome("Mariano");
        utente.setCognome("Rossi");
        utente.setEmail("mariano.rossi@example.com");
        utente.setPassword("password!@123");

        ResponseEntity<Utente> response = restTemplate.postForEntity("http://localhost:8090/api/registrazione/registrazioneUtente", utente, Utente.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        Utente nuovoUtente = response.getBody();
        assertNotNull(nuovoUtente.getId());
        assertEquals(utente.getNome(), nuovoUtente.getNome());
        assertEquals(utente.getCognome(), nuovoUtente.getCognome());
        assertEquals(utente.getEmail(), nuovoUtente.getEmail());
        assertEquals(utente.getPassword(), nuovoUtente.getPassword());
    }

    /**
     * Testa il caso in cui un utente effettua la registrazione ma si verifica un errore
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    void testRegistrazioneException() {
        Utente utente = new Utente();
        utente.setNome("Mariano");
        utente.setCognome("Rossi");
        utente.setEmail("mariano.rossi@example.com");
        utente.setPassword("password!@123");

        ResponseEntity<Utente> response = restTemplate.postForEntity("http://localhost:8090/api/registrazione/registrazioneUtente", utente, Utente.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
