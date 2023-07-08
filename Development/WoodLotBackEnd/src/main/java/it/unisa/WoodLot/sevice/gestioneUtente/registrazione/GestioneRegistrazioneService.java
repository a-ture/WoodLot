package it.unisa.WoodLot.sevice.gestioneUtente.registrazione;

import it.unisa.WoodLot.model.entity.Utente;
import it.unisa.WoodLot.model.repository.UtenteRepository;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.RegistrazioneException;
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
     * @throws RegistrazioneException in caso di e-mail già presente nel sistema o utente nullo
     */
    @Override
    public Utente registrazione(Utente utente) throws RegistrazioneException {

        if (utente == null)
            throw new RegistrazioneException("Utente non valido");

        if (utenteRepository.existsByEmail(utente.getEmail()))
            throw new RegistrazioneException("E-mail già esistente");

        return utenteRepository.save(utente);
    }

}
