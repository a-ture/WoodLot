package it.unisa.WoodLot.service.gestioneUtente.autenticazione;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import it.unisa.WoodLot.sevice.gestioneUtente.autenticazione.GestioneAutenticazioneService;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.LoginException;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.PasswordException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test d'integrazione fra la classe GestioneAutenticazioneService e la repository.
 *
 * @author Alessia Ture
 */
@SpringBootTest
@Transactional
@Rollback
@ExtendWith(SpringExtension.class)
public class AutenticazioneServiceIT {

    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private ContadinoRepository contadinoRepository;
    @Autowired
    private ResponsabileOrdiniRepository responsabileOrdiniRepository;
    @Autowired
    private ResponsabileCatalogoRepository responsabileCatalogoRepository;
    @Autowired
    private GestioneAutenticazioneService gestioneAutenticazioneService;

    /**
     * Testa il caso in cui l'utente riesce a effettuare il login
     * <p>
     * Il test è superato se la classe prodotta dal servizio di login è coincide con il ruolo dell'utente
     */
    @Test
    public void testLoginSuccesso() {
        Utente utente = new Utente();
        utente.setPassword("password");
        utente.setEmail("briciola@gmail.com");
        utente.setNome("Utente");
        utente.setCognome("Cognome");
        utente = utenteRepository.save(utente);
        try {
            UtenteRegistrato result = gestioneAutenticazioneService.login(utente.getEmail(), utente.getPassword());
            assertNotNull(result);
            assertEquals(utente, result);
        } catch (LoginException e) {
            fail(e.getMessage());
        }

        Contadino contadino = new Contadino();
        contadino.setPassword("password");
        contadino.setEmail("contadino@gmail.com");
        contadino.setNome("Utente");
        contadino.setDataDiNascita(new Date());
        contadino.setCognome("Cognome");
        contadino.setCoordinateGeografiche("string");

        contadino = contadinoRepository.save(contadino);
        try {
            UtenteRegistrato result = gestioneAutenticazioneService.login("contadino@gmail.com", "password");

            assertNotNull(result);
            assertEquals(contadino, result);
        } catch (
                LoginException e) {
            fail(e.getMessage());
        }

        ResponsabileOrdini responsabileOrdini = new ResponsabileOrdini();
        responsabileOrdini.setPassword("password");
        responsabileOrdini.setEmail("responsabileordini@gmail.com");
        responsabileOrdini.setNome("Utente");
        responsabileOrdini.setCognome("Cognome");

        responsabileOrdini = responsabileOrdiniRepository.save(responsabileOrdini);
        try {
            UtenteRegistrato result = gestioneAutenticazioneService.login("responsabileordini@gmail.com", "password");

            assertNotNull(result);
            assertEquals(responsabileOrdini, result);
        } catch (
                LoginException e) {
            fail(e.getMessage());
        }

        ResponsabileCatalogo responsabileCatalogo = new ResponsabileCatalogo();
        responsabileCatalogo.setPassword("password");
        responsabileCatalogo.setEmail("responsabilecatalogo@gmail.com");
        responsabileCatalogo.setNome("Utente");
        responsabileCatalogo.setCognome("Cognome");

        responsabileCatalogo = responsabileCatalogoRepository.save(responsabileCatalogo);
        try {
            UtenteRegistrato result = gestioneAutenticazioneService.login("responsabilecatalogo@gmail.com", "password");

            assertNotNull(result);
            assertEquals(responsabileCatalogo, result);
        } catch (
                LoginException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Controlla validità nel caso in cui l'email è null
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testLoginEmailNull() {
        String messaggio = "L'email non può essere nulla";
        try {
            gestioneAutenticazioneService.login(null, "password");
        } catch (
                LoginException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Controlla validità nel caso in cui l'email è null
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testLoginPasswordNull() {
        String messaggio = "La password non può essere nulla";
        String password = null;
        try {
            gestioneAutenticazioneService.login("", password);
        } catch (LoginException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui l'utente riesce a effettuare il login
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testLoginInsuccesso() {
        String messaggio = "E-mail o password errata";
        String password = "briciola01";
        String email = "alessia@gmail.com";
        try {
            gestioneAutenticazioneService.login(email, password);
        } catch (LoginException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui l'utente effettua la reimpostazione della password con successo
     * <p>
     * Il test è superato se la password viene modificata correttamente
     */
    @Test
    public void testReimpostaPasswordSuccesso() {
        Utente utente = new Utente();
        utente.setEmail("test54@test.com");
        utente.setPassword("passwor@d123");
        utente.setCognome("Cognome");
        utente.setNome("Nome");
        utenteRepository.save(utente);

        try {
            gestioneAutenticazioneService.reimpostaPassword("test54@test.com", "password@456");
            Utente utenteResult = utenteRepository.findByEmail("test54@test.com");
            assertEquals("password@456", utenteResult.getPassword());
        } catch (PasswordException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Controlla validità nel caso in cui l'email è null
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testReimpostazionePasswordEmailNull() {
        String messaggio = "L'email non può essere nulla";
        try {
            gestioneAutenticazioneService.reimpostaPassword(null, "password@456");
        } catch (PasswordException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui l'utente inserisce una password con lunghezza non valida (<8)
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testReimpostazionePasswordCorta() {
        String messaggio = "La password deve essere lunga almeno 8 caratteri";
        Utente utente = new Utente();
        utente.setEmail("test1@test.com");
        utente.setPassword("passwor@d123");
        utente.setCognome("Cognome");
        utente.setNome("Nome");
        utenteRepository.save(utente);
        try {
            gestioneAutenticazioneService.reimpostaPassword("test1@test.com", "passwd@456");
        } catch (PasswordException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui l'utente inserisce una password con formato non valido
     * (non è presente almeno un carattere tra @, !, #, $)
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testReimpostazionePasswordFormatoNonValido() {
        String messaggio = "La password deve contenere almeno un carattere tra: @, !, #, $";
        Utente utente = new Utente();
        utente.setEmail("test3@test.com");
        utente.setPassword("passwor@d123");
        utente.setCognome("Cognome");
        utente.setNome("Nome");
        utenteRepository.save(utente);
        try {
            gestioneAutenticazioneService.reimpostaPassword("test3@test.com", "password456");
        } catch (PasswordException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }
}
