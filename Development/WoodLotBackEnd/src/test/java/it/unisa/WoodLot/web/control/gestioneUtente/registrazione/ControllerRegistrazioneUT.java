package it.unisa.WoodLot.web.control.gestioneUtente.registrazione;

import it.unisa.WoodLot.model.entity.Utente;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.RegistrazioneException;
import it.unisa.WoodLot.sevice.gestioneUtente.registrazione.RegistrazioneService;
import it.unisa.WoodLot.web.controller.gestioneUtente.registrazione.ControllerRegistrazione;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Test di unità per la classe ControllerRegistrazione
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerRegistrazioneUT {

    @Mock
    private RegistrazioneService registrazioneService;
    @InjectMocks
    private ControllerRegistrazione registrazioneController;

    /**
     * Testa il caso in cui un utente effettua correttamente la registrazione
     * Il test è superato se l'utente viene registrato correttamente
     */
    @Test
    void testRegistrazione() throws RegistrazioneException {
        Utente utente = new Utente();
        utente.setNome("Mario");
        utente.setCognome("Rossi");
        utente.setEmail("mario.rossi@example.com");
        utente.setPassword("password");

        when(registrazioneService.registrazione(utente)).thenReturn(new Utente(1L, "mario.rossi@example.com", "password", "Mario", "Rossi", new Date()));

        ResponseEntity<Object> response = registrazioneController.registrazione(utente);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(Utente.class, response.getBody().getClass());
        Utente nuovoUtente = (Utente) response.getBody();
        assertEquals(1L, nuovoUtente.getId());
        assertEquals("Mario", nuovoUtente.getNome());
        assertEquals("Rossi", nuovoUtente.getCognome());
        assertEquals("mario.rossi@example.com", nuovoUtente.getEmail());
        assertEquals("password", nuovoUtente.getPassword());
    }

    /**
     * Testa il caso in cui un utente effettua la registrazione ma si verifica un errore
     * Il test è superato se la risposta HTTP generata dal sistema è uguale a quella
     * previsto dall'oracolo.
     */
    @Test
    void testRegistrazioneException() throws RegistrazioneException {
        Utente utente = new Utente();
        utente.setNome("Mario");
        utente.setCognome("Rossi");
        utente.setEmail("mario.rossi@example.com");
        utente.setPassword("password");

        when(registrazioneService.registrazione(utente)).thenThrow(new RegistrazioneException("Registrazione fallita"));
        ResponseEntity<Object> response = registrazioneController.registrazione(utente);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}