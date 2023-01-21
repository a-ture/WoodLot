package it.unisa.WoodLot.sevice.gestioneUtente;

import it.unisa.WoodLot.model.entity.Utente;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.AccessoNonAutorizzatoException;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.LoginException;

/**
 * Interfaccia che fornisce i metodi per la logica di business della gestione degli utenti
 *
 * @author Alessia Ture
 */
public interface UtenteService {

    Utente login(String email, String password) throws LoginException;

    void logout(Utente utente) throws AccessoNonAutorizzatoException;

    Utente registrazione(Utente utente) throws IllegalArgumentException;


}
