package it.unisa.WoodLot.web.controller.gestioneOrdine.checkout;

import it.unisa.WoodLot.model.entity.Ordine;
import it.unisa.WoodLot.model.entity.Utente;
import it.unisa.WoodLot.sevice.gestioneOrdine.checkout.CheckoutService;
import it.unisa.WoodLot.sevice.gestioneOrdine.eccezioni.OrdineException;
import it.unisa.WoodLot.web.controller.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Controller per la gestione del checkout
 *
 * @author Alessia Ture
 */
@RestController
@RequestMapping("/checkout")
public class ControllerCheckout {

    @Autowired
    private CheckoutService checkoutService;


    /**
     * Metodo POST per effettuare un ordine
     *
     * @return un boolean che indica se l'operazione è andata a buon fine
     */
    @PostMapping()
    public ResponseEntity<Object> effettuareOrdine(@RequestBody Long idUtente) {
        try {
            Ordine o = checkoutService.effettuareOrdine(idUtente);
            return new ResponseEntity<>(o, HttpStatus.CREATED);
        } catch (OrdineException e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }


}
