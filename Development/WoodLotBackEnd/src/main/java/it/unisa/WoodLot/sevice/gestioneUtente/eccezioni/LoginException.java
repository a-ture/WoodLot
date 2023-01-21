package it.unisa.WoodLot.sevice.gestioneUtente.eccezioni;

/**
 * Eccezione generata in caso di utente non loggato
 *
 * @author Alessia Ture
 */
public class LoginException extends Exception {
    public LoginException(String errore) {
        super(errore);
    }
}
