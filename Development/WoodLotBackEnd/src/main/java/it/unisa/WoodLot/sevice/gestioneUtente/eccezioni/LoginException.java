package it.unisa.WoodLot.sevice.gestioneUtente.eccezioni;

/**
 * Eccezione generata in caso di problemi nel login
 *
 * @author Alessia Ture
 */
public class LoginException extends Exception {
    public LoginException(String errore) {
        super(errore);
    }
}
