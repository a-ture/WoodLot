package it.unisa.WoodLot.sevice.gestioneOrdine.eccezioni;

/**
 * Eccezione generata nel caso in cui ci siano dei problemi nell'effettuare un ordine
 *
 * @author Alessia Ture
 */
public class OrdineException extends RuntimeException {
    public OrdineException(String errore) {
        super(errore);
    }
}
