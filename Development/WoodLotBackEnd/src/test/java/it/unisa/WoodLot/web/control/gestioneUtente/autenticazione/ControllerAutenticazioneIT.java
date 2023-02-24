package it.unisa.WoodLot.web.control.gestioneUtente.autenticazione;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unisa.WoodLot.model.entity.Utente;
import it.unisa.WoodLot.model.entity.UtenteRegistrato;
import it.unisa.WoodLot.model.repository.UtenteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerAutenticazioneIT {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private UtenteRepository utenteRepository;

    /**
     * Testa il caso in cui un utente effettua correttamente il login
     * Il test è superato se l'utente è recuperato correttamente
     */
    @Test
    void testLogin() throws ParseException {
        UtenteRegistrato utenteRegistrato = new UtenteRegistrato();
        utenteRegistrato.setEmail("alessiature@gmail.com");
        utenteRegistrato.setPassword("briciola");
        Utente utente = utenteRepository.findById(1L).orElse(null);

        ResponseEntity<Object> response = restTemplate.postForEntity("http://localhost:8090/api/autenticazione/login",
                utenteRegistrato, Object.class);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        Map<String, Object> responseMap = (Map<String, Object>) response.getBody();
        assertNotNull(responseMap);

        Map<String, Object> dataMap = (Map<String, Object>) responseMap.get("data");
        assertNotNull(dataMap);

        Utente utenteResponse = new ObjectMapper().convertValue(dataMap.get("utente"), Utente.class);
        assertEquals(utente.getId(), utenteResponse.getId());
        assertEquals(utente.getEmail(), utenteResponse.getEmail());
        assertEquals(utente.getPassword(), utenteResponse.getPassword());
        assertEquals(utente.getNome(), utenteResponse.getNome());
        assertEquals(utente.getCognome(), utenteResponse.getCognome());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date expectedDate = sdf.parse("2001-02-23 00:00:00.0");
        Date actualDate = sdf.parse(sdf.format(utenteResponse.getDataDiNascita()));
        assertEquals(expectedDate, actualDate);
    }

    /**
     * Testa il caso in cui un utente effettua il login ma si verifica un errore
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    void testLoginException() {
        UtenteRegistrato utenteRegistrato = new UtenteRegistrato();
        utenteRegistrato.setEmail("alessiature@gmail.com");
        utenteRegistrato.setPassword("briciola01");

        ResponseEntity<Object> response = restTemplate.postForEntity("http://localhost:8090/api/autenticazione/login",
                utenteRegistrato, Object.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    /**
     * Testa il caso in cui un utente effettua correttamente la reimpostazione della password
     * Il test è superato se l'utente cambia la password correttamente
     */
    @Test
    void testReimpostarePassword() {
        UtenteRegistrato utenteRegistrato = new UtenteRegistrato();
        utenteRegistrato.setEmail("alessiature@gmail.com");
        utenteRegistrato.setPassword("nuovaPassword!044");

        ResponseEntity<Object> response = restTemplate.postForEntity("http://localhost:8090/api/autenticazione/reimpostarePassword",
                utenteRegistrato, Object.class);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());

        Map<String, Object> responseMap = (Map<String, Object>) response.getBody();
        assertNotNull(responseMap);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals("La password è stata cambiata con successo", ((Map) response.getBody()).get("data"));
    }

    /**
     * Testa il caso in cui un utente effettua la reimpostazione della password ma si verifica un errore
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    void testReimpostarePasswordException() {
        UtenteRegistrato utenteRegistrato = new UtenteRegistrato();
        utenteRegistrato.setEmail("alessiature@gmail.com");
        utenteRegistrato.setPassword("nuovaPassw044");

        ResponseEntity<Object> response = restTemplate.postForEntity("http://localhost:8090/api/autenticazione/reimpostarePassword",
                utenteRegistrato, Object.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
