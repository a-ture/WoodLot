package it.unisa.WoodLot.sevice.gestioneCarrello;


import it.unisa.WoodLot.sevice.gestioneCarrello.eccezzioni.CarrelloException;

/**
 * Interfaccia che fornisce i metodi per la logica di business per la gestione del carrello
 *
 * @author Alessia Ture
 */
public interface CarrelloService {

    void aggiungiProdotto(Long idCarrello, Long idUtente, String nomeAlbero) throws CarrelloException;

    void rimuoviProdotto(Long idCarrello, Long idProdottoCarrello) throws CarrelloException;

    void modificareQuantitaProdotto(Long idCarrello, Long idProdottoCarrello, int quantita) throws CarrelloException;

    void svuotareCarrello(Long idCarrello) throws CarrelloException;


}
