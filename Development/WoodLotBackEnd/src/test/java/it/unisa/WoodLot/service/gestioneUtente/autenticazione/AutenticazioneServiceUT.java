package it.unisa.WoodLot.service.gestioneUtente.autenticazione;


import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.ContadinoRepository;
import it.unisa.WoodLot.model.repository.ResponsabileCatalogoRepository;
import it.unisa.WoodLot.model.repository.ResponsabileOrdiniRepository;
import it.unisa.WoodLot.model.repository.UtenteRepository;
import it.unisa.WoodLot.sevice.gestioneUtente.autenticazione.GestioneAutenticazioneService;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.LoginException;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.PasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


/**
 * Test di unità per la classe Gestione AutenticazioneService
 *
 * @author Alessia Ture
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AutenticazioneServiceUT {

    @Autowired
    @InjectMocks
    private GestioneAutenticazioneService gestioneAutenticazioneService;
    @Mock
    @Autowired
    private UtenteRepository utenteRepository;
    @Mock
    private ContadinoRepository contadinoRepository;
    @Mock
    private ResponsabileOrdiniRepository responsabileOrdiniRepository;
    @Mock
    private ResponsabileCatalogoRepository responsabileCatalogoRepository;

    private Utente utente;
    private Contadino contadino;
    private ResponsabileCatalogo responsabileCatalogo;
    private ResponsabileOrdini responsabileOrdini;

    @BeforeEach
    public void setUp() {
        utente = new Utente(1L, "alessiature@gmail.com", "briciola", "Alessia", "Ture", new Date(2001 - 02 - 23));
        contadino = new Contadino(1L, "pedrogarcia@gmail.com", "alessiature01");
        responsabileCatalogo = new ResponsabileCatalogo(1L, "catalogo@gmail.com", "catalogo");
        responsabileOrdini = new ResponsabileOrdini(1L, "ordini@gmail.com", "ordini");
    }

    /**
     * Testa il caso in cui l'utente riesce a effettuare il login
     * <p>
     * Il test è superato se la classe prodotta dal servizio di login è coincide con il ruolo dell'utente
     */
    @Test
    public void testLoginSuccesso() {
        try {
            // Test case: login effettuato con successo come utente
            UtenteRegistrato expectedResult = new Utente();
            when(utenteRepository.findByEmailAndPassword(utente.getEmail(), utente.getPassword())).thenReturn((Utente) expectedResult);
            UtenteRegistrato result = gestioneAutenticazioneService.login(utente.getEmail(), utente.getPassword());
            assertEquals(expectedResult, result);

        } catch (LoginException e) {
            fail(e.getMessage());
        }
        try {
            // Test case: login effettuato con successo come contadino
            UtenteRegistrato expectedResult = new Contadino();
            when(contadinoRepository.findContadinoByEmailAndPassword(contadino.getEmail(), contadino.getPassword())).thenReturn((Contadino) expectedResult);
            UtenteRegistrato result = gestioneAutenticazioneService.login(contadino.getEmail(), contadino.getPassword());
            assertEquals(expectedResult, result);
        } catch (LoginException e) {
            fail(e.getMessage());
        }
        try {
            // Test case: login effettuato con successo come responsabile catalogo
            UtenteRegistrato expectedResult = new ResponsabileCatalogo();
            when(responsabileCatalogoRepository.findResponsabileCatalogoByEmailAndPassword(responsabileCatalogo.getEmail(), responsabileCatalogo.getPassword())).thenReturn((ResponsabileCatalogo) expectedResult);
            UtenteRegistrato result = gestioneAutenticazioneService.login(responsabileCatalogo.getEmail(), responsabileCatalogo.getPassword());
            assertEquals(expectedResult, result);
        } catch (LoginException e) {
            fail(e.getMessage());
        }

        try {
            // Test case: login effettuato con successo come responsabile ordini
            UtenteRegistrato expectedResult = new ResponsabileOrdini();
            when(responsabileOrdiniRepository.findByEmailAndPassword(responsabileOrdini.getEmail(), responsabileOrdini.getPassword())).thenReturn((ResponsabileOrdini) expectedResult);
            UtenteRegistrato result = gestioneAutenticazioneService.login(responsabileOrdini.getEmail(), responsabileOrdini.getPassword());
            assertEquals(expectedResult, result);
        } catch (LoginException e) {
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
        String eMail = null;
        try {
            gestioneAutenticazioneService.login(eMail, "");
        } catch (LoginException e) {
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
     * Testa il caso in cui l'utente non riesce a effettuare il login
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
        //Test Case: utente reimposta la password con successo
        try {
            Utente utente = new Utente();
            utente.setEmail("email@email.com");
            when(utenteRepository.findByEmail("email@email.com")).thenReturn(utente);

            gestioneAutenticazioneService.reimpostaPassword("email@email.com", "Password1@");

            verify(utenteRepository, times(1)).save(utente);
            assertEquals("Password1@", utente.getPassword());
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
        String eMail = null;
        try {
            gestioneAutenticazioneService.reimpostaPassword(eMail, "");
        } catch (PasswordException e) {
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
    public void testReimpostazionePasswordNull() {
        String messaggio = "La password non può essere nulla";
        String password = null;
        try {
            gestioneAutenticazioneService.reimpostaPassword(utente.getEmail(), password);
        } catch (PasswordException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }

    /**
     * Testa il caso in cui l'utente inserisce una e-mail non presente nel DB
     * <p>
     * Il test è superato se il messaggio generato dal sistema è uguale a quello
     * previsto dall'oracolo.
     */
    @Test
    public void testReimpostazionePasswordEmailInesistente() {
        String messaggio = "L' email inserita non è associata a nessun utente";
        String eMail = "questaemail@nonesiste.it";
        try {
            gestioneAutenticazioneService.reimpostaPassword(eMail, "");
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
        String password = "er@4";
        try {
            Utente utente = new Utente();
            utente.setEmail("email@email.com");
            utente.setPassword(password);
            when(utenteRepository.findByEmail("email@email.com")).thenReturn(utente);

            gestioneAutenticazioneService.reimpostaPassword("email@email.com", "Password1@");
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
        String password = "erfdferea";
        try {
            // Preparazione
            Utente utente = new Utente();
            utente.setEmail("email@email.com");
            utente.setPassword(password);
            when(utenteRepository.findByEmail("email@email.com")).thenReturn(utente);

            gestioneAutenticazioneService.reimpostaPassword("email@email.com", "Password1@");
        } catch (PasswordException e) {
            assertEquals(messaggio, e.getMessage());
        }
    }
}
