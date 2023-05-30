package it.unisa.WoodLot.service.gestioneUtente.registrazione;

import it.unisa.WoodLot.model.entity.Utente;
import it.unisa.WoodLot.model.repository.UtenteRepository;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.RegistrazioneException;
import it.unisa.WoodLot.sevice.gestioneUtente.registrazione.GestioneRegistrazioneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test di unità per la classe GestioneRegistrazioneService
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RegistrazioneServiceUT {

    @Mock
    private UtenteRepository utenteRepository;
    @Autowired
    private GestioneRegistrazioneService gestioneRegistrazioneService;
    private Utente utente;

    @BeforeEach
    public void setUp() {
        utente = new Utente(1L, "alessia.ture@gmail.com", "briciola01@@", "Alessia", "Ture");
    }

    /**
     * Testa il caso in cui un utente si registra con successo
     *
     * @result Il test è superato se l'utente viene salvato con successo
     */
    @Test
    public void testRegistrazioneSuccesso() {
        try {
            Utente utenteRegistrato = gestioneRegistrazioneService.registrazione(utente);
            assertNotNull(utenteRegistrato);
            assertEquals(utente, utenteRegistrato);
        } catch (RegistrazioneException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Testa il caso in cui l'utente è nullo
     *
     * @result Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testRegistrazioneUtenteNullo() {
        String messaggio = "Utente non valido";
        Utente utente = null;
        try {
            gestioneRegistrazioneService.registrazione(utente);
        } catch (RegistrazioneException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui email è nulla
     *
     * @result Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testRegistrazioneEmailNulla() {
        String messaggio = "Tutti i campi sono obbligatori";
        String email = null;
        utente.setEmail(email);
        try {
            gestioneRegistrazioneService.registrazione(utente);
        } catch (RegistrazioneException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui la password è nulla
     *
     * @result Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testRegistrazionePasswordNulla() {
        String messaggio = "Tutti i campi sono obbligatori";
        String password = null;
        utente.setPassword(password);
        try {
            gestioneRegistrazioneService.registrazione(utente);
        } catch (RegistrazioneException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il nome è nullo
     *
     * @result Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testRegistrazioneNomeNullo() {
        String messaggio = "Tutti i campi sono obbligatori";
        String nome = null;
        utente.setNome(nome);
        try {
            gestioneRegistrazioneService.registrazione(utente);
        } catch (RegistrazioneException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il nome è nullo
     *
     * @result Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testRegistrazioneCognomeNullo() {
        String messaggio = "Tutti i campi sono obbligatori";
        String cognome = null;
        utente.setCognome(cognome);
        try {
            gestioneRegistrazioneService.registrazione(utente);
        } catch (RegistrazioneException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il formato della email non è valida
     *
     * @result Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testRegistrazioneEmailInvalida() {
        String messaggio = "Indirizzo email non valido";
        String email = "email";
        utente.setEmail(email);
        try {
            gestioneRegistrazioneService.registrazione(utente);
        } catch (RegistrazioneException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui il formato della password non è valida
     *
     * @result Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testRegistrazionePasswordInvalida() {
        String messaggio = "La password deve contenere almeno un carattere tra: @, !, #, $";
        String password = "emailemail";
        utente.setPassword(password);
        try {
            gestioneRegistrazioneService.registrazione(utente);
        } catch (RegistrazioneException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui la lunghezza della password non è valida
     *
     * @result Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testRegistrazioneLunghezzaPasswordInvalida() {
        String messaggio = "La password deve essere lunga almeno 8 caratteri";
        String password = "em";
        utente.setPassword(password);
        try {
            gestioneRegistrazioneService.registrazione(utente);
        } catch (RegistrazioneException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui la lunghezza della password non è valida
     *
     * @result Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testRegistrazioneEmailEsistente() {
        String messaggio = "E-mail già presente nel database";
        String email = "alessiature@gmail.com";
        utente.setEmail(email);
        try {
            gestioneRegistrazioneService.registrazione(utente);
        } catch (RegistrazioneException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }
}
