package it.unisa.WoodLot.web.controller.gestioneOrdine.ordini;

import it.unisa.WoodLot.model.entity.Ordine;
import it.unisa.WoodLot.sevice.gestioneOrdine.ordini.OrdineService;
import it.unisa.WoodLot.web.controller.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> restituisciOrdini() {
        return new ResponseEntity<>(ordineService.restituisciOrdini(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/storicoUtente/{idUtente}")
    public ResponseEntity<Object> visualizzaOrdiniUtente(@PathVariable Long idUtente) {
        return new ResponseEntity<>(ordineService.visualizzaOrdiniUtente(idUtente), HttpStatus.ACCEPTED);
    }
}
