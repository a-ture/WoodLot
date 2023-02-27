package it.unisa.WoodLot.web.controller.gestioneContadino;

import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.ProdottoOrdine;
import it.unisa.WoodLot.sevice.gestioneContadino.ContadinoService;
import it.unisa.WoodLot.sevice.gestioneContadino.eccezioni.ContadinoException;
import it.unisa.WoodLot.web.controller.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller per la gestione dei contadini
 */
@RestController
@RequestMapping("/api/contadino")
public class ControllerContadino {

    @Autowired
    private ContadinoService contadinoService;

    /**
     * Metodo GET per visualizzare l'elenco dei contadini
     *
     * @return
     */
    @GetMapping("")
    public ResponseEntity<Object> visualizzaElencoContadini() {
        return new ResponseEntity<>(contadinoService.getElencoContadini(), HttpStatus.ACCEPTED);
    }

    /**
     * Metodo GET per visualizzare l'elenco degli alberi non ancora assegnati
     *
     * @return
     */
    @GetMapping("/alberiNonAssegnati")
    public ResponseEntity<Object> elencoAlberiNonAssegnati() {
        return new ResponseEntity<>(contadinoService.getAlberiNonAssegnati(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/aggiornaStato")
    public ResponseEntity<Object> aggiornaStato(@RequestBody ProdottoOrdine prodottoOrdine) {
        try {
            return new ResponseEntity<>(contadinoService.aggiornaStato(prodottoOrdine), HttpStatus.CREATED);
        } catch (ContadinoException e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/alberiContadino/{idContadino}")
    public ResponseEntity<Object> restituisceAlberiContadino(@PathVariable Long idContadino) {
        return new ResponseEntity<>(contadinoService.elencoAlberiContadino(idContadino), HttpStatus.ACCEPTED);
    }
}
