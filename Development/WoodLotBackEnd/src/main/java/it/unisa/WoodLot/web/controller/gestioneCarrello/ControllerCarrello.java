package it.unisa.WoodLot.web.controller.gestioneCarrello;


import it.unisa.WoodLot.model.entity.ProdottoCarrello;
import it.unisa.WoodLot.sevice.gestioneCarrello.CarrelloService;
import it.unisa.WoodLot.sevice.gestioneCarrello.eccezzioni.CarrelloException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/carrello")
public class ControllerCarrello {

    @Autowired
    private CarrelloService carrelloService;

    /**
     * Metodo POST per aggiungere un prodotto a un carrello
     *
     * @param prodottoCarrello l'id del prodotto da aggiungere
     * @throws CarrelloException
     */
    @PostMapping("/aggiungiProdotto")
    public void aggiungiProdotto(@RequestBody ProdottoCarrello prodottoCarrello) throws CarrelloException {
        carrelloService.aggiungiProdotto(prodottoCarrello.getCarrello().getId(), prodottoCarrello.getCarrello().getUtente().getId(), prodottoCarrello.getAlbero().getNome());
    }

    /**
     * Metodo PUT per modificare la quantità di un prodotto
     *
     * @param prodottoCarrello l'id del prodotto da modificare
     * @throws CarrelloException
     */
    @PutMapping("/modificareQuantitaProdotto")
    public void modificareQuantitaProdotto(@RequestBody ProdottoCarrello prodottoCarrello) throws CarrelloException {
        carrelloService.modificareQuantitaProdotto(prodottoCarrello.getCarrello().getId(), prodottoCarrello.getId(), prodottoCarrello.getQuantita());
    }

    /**
     * Metodo DELETE per svuotare il carrello
     *
     * @param idCarrello l'id del carrello da svuotare
     * @throws CarrelloException
     */
    @DeleteMapping("/svuotareCarrello/{idCarrello}")
    public void svuotareCarrello(@PathVariable Long idCarrello) throws CarrelloException {
        carrelloService.svuotareCarrello(idCarrello);
    }

    /**
     * Metodo DELETE per rimuovere un prodotto da un carrello
     *
     * @param idCarrello         l'id del carrello da cui rimuovere il prodotto
     * @param idProdottoCarrello l'id del prodotto da rimuovere
     * @throws CarrelloException
     */
    @DeleteMapping("/rimuoviProdotto/{idCarrello}/{idProdottoCarrello}/")
    public void rimuoviProdotto(@PathVariable Long idCarrello, @PathVariable Long idProdottoCarrello) throws CarrelloException {
        carrelloService.rimuoviProdotto(idCarrello, idProdottoCarrello);
    }

}

