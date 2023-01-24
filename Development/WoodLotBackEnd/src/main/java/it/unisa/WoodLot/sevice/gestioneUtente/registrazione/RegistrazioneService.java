package it.unisa.WoodLot.sevice.gestioneUtente.registrazione;

import it.unisa.WoodLot.model.entity.Utente;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.RegistazioneException;

/**
 * Interfaccia che fornisce i metodi per la logica di registrazione degli utenti
 *
 * @author Alessia Ture
 */
public interface RegistrazioneService {

    Utente registrazione(Utente utente) throws RegistazioneException;
}
