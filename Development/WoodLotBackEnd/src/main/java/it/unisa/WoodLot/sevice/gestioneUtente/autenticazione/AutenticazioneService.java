package it.unisa.WoodLot.sevice.gestioneUtente.autenticazione;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.LoginException;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.PasswordException;

/**
 * Interfaccia che fornisce i metodi per la logica di business della gestione dell'autenticazione
 *
 * @author Alessia Ture
 */
public interface AutenticazioneService {

    UtenteRegistrato login(String email, String password) throws LoginException;

    void logout();

    void reimpostaPassword(String email, String password) throws PasswordException;

}
