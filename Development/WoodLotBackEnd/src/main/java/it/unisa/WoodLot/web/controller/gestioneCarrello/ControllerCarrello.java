package it.unisa.WoodLot.web.controller.gestioneCarrello;


import it.unisa.WoodLot.model.entity.Carrello;
import it.unisa.WoodLot.model.entity.ProdottoCarrello;
import it.unisa.WoodLot.sevice.gestioneCarrello.CarrelloService;
import it.unisa.WoodLot.sevice.gestioneCarrello.eccezzioni.CarrelloException;
import it.unisa.WoodLot.web.controller.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller per la gestione del carrello
 */
@RestController
@RequestMapping("/api/carrello")
public class ControllerCarrello {

    @Autowired
    private CarrelloService carrelloService;

    /**
     * Metodo POST per aggiungere un prodotto a un carrello
     *
     * @throws CarrelloException
     */
    @GetMapping("/aggiungiProdotto/{nomeAlbero}/{idCarrello}")
    public ResponseEntity<Object> aggiungiProdotto(@PathVariable String nomeAlbero, @PathVariable Long idCarrello) {
        try {
            Carrello carrello = carrelloService.aggiungiProdotto(idCarrello, nomeAlbero);
            return new ResponseEntity<>(carrello, HttpStatus.ACCEPTED);
        } catch (CarrelloException e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }

    /**
     * Metodo POST per svuotare il carrello
     *
     * @param idCarrello l'id del carrello da svuotare
     * @throws CarrelloException
     */
    @GetMapping("/svuotareCarrello/{idCarrello}")
    public ResponseEntity<Object> svuotareCarrello(@PathVariable Long idCarrello) {
        try {
            Carrello carrello = carrelloService.svuotareCarrello(idCarrello);
            return new ResponseEntity<>(carrello, HttpStatus.ACCEPTED);
        } catch (CarrelloException e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }

    /**
     * Metodo POST per rimuovere un prodotto da un carrello
     *
     * @param idCarrello         l'id del carrello da cui rimuovere il prodotto
     * @param idProdottoCarrello l'id del prodotto da rimuovere
     */
    @GetMapping("/rimuoviProdotto/{idCarrello}/{idProdottoCarrello}/")
    public ResponseEntity<Object> rimuoviProdotto(@PathVariable Long idCarrello, @PathVariable Long idProdottoCarrello) {
        try {
            Carrello carrello = carrelloService.rimuoviProdotto(idCarrello, idProdottoCarrello);
            return new ResponseEntity<>(carrello, HttpStatus.ACCEPTED);
        } catch (CarrelloException e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }

    /**
     * Metodo GET per visualizzare il carrello
     *
     * @param idUtente
     * @return
     */
    @GetMapping("/{idUtente}")
    public ResponseEntity<Object> visualizzaCarrello(@PathVariable Long idUtente) {
        try {
            Carrello carrello = carrelloService.getCarrello(idUtente);
            return new ResponseEntity<>(carrello, HttpStatus.ACCEPTED);
        } catch (CarrelloException e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}

