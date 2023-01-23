package it.unisa.WoodLot.web.controller.gestioneOrdine.ordini;

import it.unisa.WoodLot.model.entity.Ordine;
import it.unisa.WoodLot.sevice.gestioneOrdine.ordini.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller per la gestione degli ordini
 *
 * @author Alessia Ture
 */
@RestController
@RequestMapping("/api/ordine")
public class ControllerOrdini {

    @Autowired
    private OrdineService ordineService;

    /**
     * Metodo GET che restituisce tutti gli ordini presenti
     *
     * @return la lista degli alberi
     */
    @GetMapping("/getOrdini")
    public Iterable<Ordine> restituisciOrdini() {
        return ordineService.restituisciOrdini();
    }

    @GetMapping("/storicoUtente/{idUtente}")
    public List<Ordine> visualizzaOrdiniUtente(@PathVariable Long idUtente) {
        return ordineService.visualizzaOrdiniUtente(idUtente);
    }
}
