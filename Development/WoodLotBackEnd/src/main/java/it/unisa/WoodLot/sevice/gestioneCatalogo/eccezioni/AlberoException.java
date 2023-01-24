package it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni;

/**
 * Eccezione generata nel caso in cui ci siano dei problemi nell'inserimento di un prodotto
 *
 * @author Alessia Ture
 */
public class AlberoException extends Exception {
    public AlberoException(String errore) {
        super(errore);
    }
}
