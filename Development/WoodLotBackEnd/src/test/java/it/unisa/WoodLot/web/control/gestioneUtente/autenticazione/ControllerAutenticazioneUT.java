package it.unisa.WoodLot.web.control.gestioneUtente.autenticazione;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unisa.WoodLot.model.entity.Utente;
import it.unisa.WoodLot.model.entity.UtenteRegistrato;
import it.unisa.WoodLot.sevice.gestioneUtente.autenticazione.GestioneAutenticazioneService;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.LoginException;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.PasswordException;
import it.unisa.WoodLot.web.controller.gestioneUtente.autenticazione.ControllerAutenticazione;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * Test di unità per la classe ControllerAutenticazione
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerAutenticazioneUT {
    @Mock
    private GestioneAutenticazioneService autenticazioneService;
    @InjectMocks
    private ControllerAutenticazione controllerAutenticazione;

    /**
     * Testa il caso in cui un utente effettua correttamente il login
     * Il test è superato se l'utente è recuperato correttamente
     */
    @Test
    void testLogin() throws LoginException {
        UtenteRegistrato utenteRegistrato = new UtenteRegistrato();
        utenteRegistrato.setEmail("test@example.com");
        utenteRegistrato.setPassword("password");
        Utente utente = new Utente();
        utente.setNome("Test");
        utente.setCognome("Cognome");
        utente.setEmail("test@example.com");
        utente.setPassword("password");

        when(autenticazioneService.login(utenteRegistrato.getEmail(), utenteRegistrato.getPassword())).thenReturn(utente);

        ResponseEntity<Object> responseEntity = controllerAutenticazione.login(utenteRegistrato);

        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        Map<String, Object> responseMap = (Map<String, Object>) responseEntity.getBody();
        assertNotNull(responseMap);

        Map<String, Object> dataMap = (Map<String, Object>) responseMap.get("data");
        assertNotNull(dataMap);

        Utente utenteResponse = new ObjectMapper().convertValue(dataMap.get("utente"), Utente.class);
        assertEquals(utente, utenteResponse);
    }

    /**
     * Testa il caso in cui un utente effettua il login ma si verifica un errore
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    void testLoginException() throws LoginException {
        String errore = "E-mail o password sono sbagliati";

        UtenteRegistrato utenteRegistrato = new UtenteRegistrato();
        utenteRegistrato.setEmail("test@example.com");
        utenteRegistrato.setPassword("password");

        when(autenticazioneService.login(utenteRegistrato.getEmail(), utenteRegistrato.getPassword())).thenThrow(new LoginException(errore));

        ResponseEntity<Object> responseEntity = controllerAutenticazione.login(utenteRegistrato);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(errore, ((Map) responseEntity.getBody()).get("data"));
    }

    /**
     * Testa il caso in cui un utente effettua correttamente la reimpostazione della password
     * Il test è superato se l'utente cambia la password correttamente
     */
    @Test
    public void testReimpostarePassword() {
        UtenteRegistrato utenteRegistrato = new UtenteRegistrato();
        utenteRegistrato.setEmail("test@example.com");
        utenteRegistrato.setPassword("nuovaPassword");

        ResponseEntity<Object> response = controllerAutenticazione.reimpostarePassword(utenteRegistrato);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals("La password è stata cambiata con successo", ((Map) response.getBody()).get("data"));
    }

    /**
     * Testa il caso in cui un utente effettua la reimpostazione della password ma si verifica un errore
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    public void testReimpostarePasswordException() throws PasswordException {
        String errore = "E-mail o password sono sbagliati";
        UtenteRegistrato utenteRegistrato = new UtenteRegistrato();
        utenteRegistrato.setEmail("test@example.com");
        utenteRegistrato.setPassword("nuovaPassword");

        doThrow(new PasswordException(errore)).when(autenticazioneService).reimpostaPassword(utenteRegistrato.getEmail(), utenteRegistrato.getPassword());

        ResponseEntity<Object> response = controllerAutenticazione.reimpostarePassword(utenteRegistrato);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
