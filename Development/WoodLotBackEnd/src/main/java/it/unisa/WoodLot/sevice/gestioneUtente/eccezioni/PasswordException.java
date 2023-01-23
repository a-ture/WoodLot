package it.unisa.WoodLot.sevice.gestioneUtente.eccezioni;

/**
 * Eccezione generata nel caso in cui ci siano dei problemi nel reimpostare la password di un utente
 *
 * @author Alessia Ture
 */
public class PasswordException extends Exception {
    public PasswordException(String errore) {
        super(errore);
    }
}
