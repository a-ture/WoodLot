package it.unisa.WoodLot.sevice.gestioneCarrello;


import it.unisa.WoodLot.model.entity.Carrello;
import it.unisa.WoodLot.sevice.gestioneCarrello.eccezzioni.CarrelloException;

/**
 * Interfaccia che fornisce i metodi per la logica di business per la gestione del carrello
 *
 * @author Alessia Ture
 */
public interface CarrelloService {

    Carrello getCarrello(Long idUtente) throws CarrelloException;

    Carrello aggiungiProdotto(Long idCarrello, String nomeAlbero) throws CarrelloException;

    Carrello rimuoviProdotto(Long idCarrello, Long idProdottoCarrello) throws CarrelloException;

    Carrello svuotareCarrello(Long idCarrello) throws CarrelloException;

}
