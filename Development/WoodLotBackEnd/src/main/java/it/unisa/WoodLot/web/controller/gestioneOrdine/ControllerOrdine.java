package it.unisa.WoodLot.web.controller.gestioneOrdine;

import it.unisa.WoodLot.model.entity.Ordine;
import it.unisa.WoodLot.sevice.gestioneOrdine.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller per la gestione degli ordini
 *
 * @author Alessia Ture
 */
@RestController
@RequestMapping("/api/ordine")
public class ControllerOrdine {

    @Autowired
    private OrdineService ordineService;

    /**
     * Metodo GET che restituisce tutti gli ordini presenti
     *
     * @return la lista degli alberi
     */
    @GetMapping("ordine/getOrdini")
    public Iterable<Ordine> restituisciOrdini() {
        return ordineService.restituisciOrdini();
    }

    /**
     * Metodo POST per effettuare un ordine
     *
     * @return l'ordine appena creato
     */
    @PostMapping("ordine/checkout")
    public Ordine effettuareOrdine(@RequestBody Ordine ordine) {
        return ordineService.effetuaOrdine(ordine);
    }


}
