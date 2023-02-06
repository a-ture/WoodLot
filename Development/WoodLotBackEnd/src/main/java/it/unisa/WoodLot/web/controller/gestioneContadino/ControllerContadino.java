package it.unisa.WoodLot.web.controller.gestioneContadino;

import it.unisa.WoodLot.sevice.gestioneContadino.ContadinoService;
import it.unisa.WoodLot.web.controller.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, contadinoService.getElencoContadini());
    }

    /**
     * Metodo GET per visualizzare l'elenco degli alberi non ancora assegnati
     *
     * @return
     */
    @GetMapping("/alberiNonAssegnati")
    public ResponseEntity<Object> elencoAlberiNonAssegnati() {
        return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, contadinoService.getAlberiNonAssegnati());
    }
}
