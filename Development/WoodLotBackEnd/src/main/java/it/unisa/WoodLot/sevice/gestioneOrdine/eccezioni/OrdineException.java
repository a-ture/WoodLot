package it.unisa.WoodLot.sevice.gestioneOrdine.eccezioni;


public class OrdineException extends RuntimeException {
    public OrdineException(String errore) {
        super(errore);
    }
}
