package it.unisa.WoodLot.sevice.gestioneUtente.eccezioni;

/**
 * Eccezione generata nel caso in cui ci siano dei problemi nel registrare un utente
 *
 * @author Alessia Ture
 */
public class RegistrazioneException extends Exception {
    public RegistrazioneException(String errore) {
        super(errore);
    }
}
