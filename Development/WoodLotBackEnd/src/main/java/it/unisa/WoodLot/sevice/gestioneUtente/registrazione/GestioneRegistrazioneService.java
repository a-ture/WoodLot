package it.unisa.WoodLot.sevice.gestioneUtente.registrazione;

import it.unisa.WoodLot.model.entity.Utente;
import it.unisa.WoodLot.model.repository.UtenteRepository;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.RegistazioneException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * La classe fornisce i metodi per la logica di business della gestione della registrazione degli utenti
 *
 * @author Alessia Ture
 */
@Service
public class GestioneRegistrazioneService implements RegistrazioneService {
    @Autowired
    private UtenteRepository utenteRepository;

    /**
     * Permette di registrare un nuovo utente
     *
     * @param utente nuovo utente
     * @return utente registrato
     * @throws IllegalArgumentException in caso di e-mail già presente nel sistema o utente nullo
     */
    @Override
    public Utente registrazione(Utente utente) throws RegistazioneException {

        if (utente == null)
            throw new RegistazioneException("Utente non valido");

        if (utente.getNome() == null || utente.getEmail() == null || utente.getPassword() == null)
            throw new RegistazioneException("Tutti i campi sono obbligatori");

        String email = utente.getEmail();
        String pattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        if (!email.matches(pattern))
            throw new RegistazioneException("Indirizzo email non valido");

        if (utente.getPassword().length() < 8)
            throw new RegistazioneException("La password deve essere lunga almeno 8 caratteri");

        if (!utente.getPassword().matches(".*[@!#$].*"))
            throw new IllegalArgumentException("La password deve contenere almeno un carattere tra: @, !, #, $");

        if (utenteRepository.existsByEmail(utente.getEmail()))
            throw new RegistazioneException("E-mail già presente nel database");

        return utenteRepository.save(utente);
    }
}
