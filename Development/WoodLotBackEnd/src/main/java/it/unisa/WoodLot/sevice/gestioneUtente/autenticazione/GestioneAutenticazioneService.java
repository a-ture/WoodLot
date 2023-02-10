package it.unisa.WoodLot.sevice.gestioneUtente.autenticazione;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.LoginException;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.PasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * La classe fornisce i metodi per la logica di business della gestione dell'autenticazione degli utenti
 *
 * @author Alessia Ture
 */
@Service
public class GestioneAutenticazioneService implements AutenticazioneService {


    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private ContadinoRepository contadinoRepository;
    @Autowired
    ResponsabileOrdiniRepository responsabileOrdiniRepository;
    @Autowired
    private ResponsabileCatalogoRepository responsabileCatalogoRepository;

    /**
     * Permette l'autenticazione di un utente generico (che esso sia un utente, un contadino,
     * un responsabile catalogo, un responsabile ordine) nel sistema
     *
     * @param email    Stringa che rappresenta l'email dell'utente
     * @param password Stringa che rappresenta la password dell'utente
     * @return String che rappresenta il ruolo del utente
     * @throws LoginException se la coppia (email, password) non è presente nel sistema,
     *                        o se l'email o la password sono nulli
     */
    @Override
    public UtenteRegistrato login(String email, String password) throws LoginException {

        if (password == null)
            throw new LoginException("La password non può essere nulla");
        if (email == null)
            throw new LoginException("L'email non può essere nulla");

        Utente utente = utenteRepository.findByEmailAndPassword(email, password);
        Contadino contadino = contadinoRepository.findContadinoByEmailAndPassword(email, password);
        ResponsabileCatalogo responsabileCatalogo = responsabileCatalogoRepository.findResponsabileCatalogoByEmailAndPassword(email, password);
        ResponsabileOrdini responsabileOrdini = responsabileOrdiniRepository.findByEmailAndPassword(email, password);

        if (utente != null)
            return utente;
        else if (contadino != null)
            return contadino;
        else if (responsabileCatalogo != null)
            return responsabileCatalogo;
        else if (responsabileOrdini != null)
            return responsabileOrdini;
        throw new LoginException("E-mail o password errata");
    }

    /**
     * Permette la rimozione di un utente dalla sessione
     */
    @Override
    public void logout() {
        request.getSession().invalidate();
    }

    /**
     * Permette di reimpostare la password di un utente
     *
     * @param email    l'email dell'utente
     * @param password la nuova password
     */
    @Override
    public void reimpostaPassword(String email, String password) throws PasswordException {

        if (email == null)
            throw new PasswordException("L'email non può essere nulla");
        if (password == null)
            throw new PasswordException("La password non può essere nulla");

        Utente utente = utenteRepository.findByEmail(email);
        Contadino contadino = contadinoRepository.findByEmail(email);
        ResponsabileCatalogo responsabileCatalogo = responsabileCatalogoRepository.findResponsabileCatalogoByEmail(email);
        ResponsabileOrdini responsabileOrdini = responsabileOrdiniRepository.findByEmail(email);

        if (utente == null && contadino == null && responsabileCatalogo == null && responsabileOrdini == null)
            throw new PasswordException("L' email inserita non è associata a nessun utente");

        if (password.length() < 8)
            throw new PasswordException("La password deve essere lunga almeno 8 caratteri");

        if (!password.matches(".*[@!#$].*"))
            throw new IllegalArgumentException("La password deve contenere almeno un carattere tra: @, !, #, $");

        if (utente != null) {
            utente.setPassword(password);
            utenteRepository.save(utente);
        } else if (contadino != null) {
            contadino.setPassword(password);
            contadinoRepository.save(contadino);
        } else if (responsabileOrdini != null) {
            responsabileOrdini.setPassword(password);
            responsabileOrdiniRepository.save(responsabileOrdini);
        } else {
            responsabileCatalogo.setPassword(password);
            responsabileCatalogoRepository.save(responsabileCatalogo);
        }
    }

}
