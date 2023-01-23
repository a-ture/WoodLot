package it.unisa.WoodLot.web.controller.gestioneOrdine.checkout;

import it.unisa.WoodLot.model.entity.Ordine;
import it.unisa.WoodLot.model.entity.Utente;
import it.unisa.WoodLot.sevice.gestioneOrdine.checkout.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean effettuareOrdine(@RequestBody Long idUtente) {
        Ordine o = checkoutService.effettuareOrdine(idUtente);
        return o.getId() == null ? false : true;
    }


}
