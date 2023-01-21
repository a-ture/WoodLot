package it.unisa.WoodLot.sevice.gestioneUtente;

import it.unisa.WoodLot.model.entity.Utente;
import it.unisa.WoodLot.model.repository.UtenteRepository;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.AccessoNonAutorizzatoException;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * La classe fornisce i metodi per la logica di business della gestione degli utenti
 *
 * @author Alessia Ture
 */
@Service
public class GestioneUtenteService implements UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    /**
     * Permette l'autenticazione di un utente nel sistema
     *
     * @param email    Stringa che rappresenta l'email dell'utente
     * @param password Stringa che rappresenta la password dell'utente
     * @return utente
     * @throws LoginException se la coppia (email, password) non è presente nel sistema,
     *                        o se l'email o la password sono nulli
     */
    @Override
    public Utente login(String email, String password) throws LoginException {
        if (password == null)
            throw new LoginException("La password non può essere nulla");
        if (email == null)
            throw new LoginException("L'email non può essere nulla");
        Utente utente = utenteRepository.findByEmailAndPassword(email, password);
        if (utente != null)
            return utente;
        throw new LoginException("E-mail o password errati");
    }

    /**
     * Permette la rimozione di un utente dalla sessione
     *
     * @param utente
     */
    @Override
    public void logout(Utente utente) throws AccessoNonAutorizzatoException {
        if (utente == null)
            throw new AccessoNonAutorizzatoException("Errore durante il logout");

    }

    /**
     * Permette di registrare un nuovo utente
     *
     * @param utente nuovo utente
     * @return utente registrato
     * @throws IllegalArgumentException in caso di e-mail già presente nel sistema o utente nullo
     */
    @Override
    public Utente registrazione(Utente utente) throws IllegalArgumentException {
        if (utente == null)
            throw new IllegalArgumentException("Utente non valido");
        if (utenteRepository.existsByEmail(utente.getEmail()))
            throw new IllegalArgumentException("E-mail già presente nel database");
        return utenteRepository.save(utente);
    }


}
