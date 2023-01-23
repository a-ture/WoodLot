package it.unisa.WoodLot.sevice.gestioneCarrello.eccezzioni;

import it.unisa.WoodLot.model.entity.Carrello;

public class CarrelloException extends Exception {
    public CarrelloException(String errore) {
        super(errore);
    }
}
