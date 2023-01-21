package it.unisa.WoodLot.sevice.gestioneUtente.eccezioni;

/**
 * Eccezione generata in caso di accesso non autorizzato.
 *
 * @author Alessia Ture
 */
public class AccessoNonAutorizzatoException extends Exception {
    public AccessoNonAutorizzatoException(String errore) {
        super(errore);
    }
}
