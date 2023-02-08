package it.unisa.WoodLot.web.controller.gestioneStatistiche;

import it.unisa.WoodLot.sevice.gestioneStatistiche.StatisticheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller per visualizzare le statistiche
 *
 * @author Alessia Ture
 */
@RestController
@RequestMapping("/api/statistiche")
public class ControllerStatistiche {

    @Autowired
    private StatisticheService statisticheService;

    /**
     * Metodo GET per visualizzare le statistiche della pagina dell'utente
     *
     * @param idUtente l'id dell'utente di cuii si vogliono visualizzare le statistiche
     */
    @GetMapping("/utente/{idUtente}")
    public ResponseEntity<Object> visualizzaStatisticheUtente(@PathVariable Long idUtente) {
        return new ResponseEntity<>(statisticheService.statistichePaginaUtente(idUtente), HttpStatus.ACCEPTED);
    }

    /**
     * Metodo GET per visualizzare le statistiche della pagina del responsabile catalogo e della pagina diventa un contadino
     */
    @GetMapping("/responsabileCatalogo")
    public ResponseEntity<Object> visualizzaStatisticheResponsabile() {
        return new ResponseEntity<>(statisticheService.statistichePaginaResponsabileCatalogo(), HttpStatus.ACCEPTED);
    }

    /**
     * Metodo GET per visualizzare le statistiche della pagina del contadino
     */
    @GetMapping("/contadino/{idContadino}")
    public ResponseEntity<Object> visualizzaStatisticheContadino(@PathVariable Long idContadino) {
        return new ResponseEntity<>(statisticheService.statistichePaginaContadino(idContadino), HttpStatus.ACCEPTED);
    }

    @GetMapping("/responsabileOrdini")
    public ResponseEntity<Object> visualizzaStatisticheOrdini() {
        return new ResponseEntity<>(statisticheService.statistichePaginaResponsabileOrdini(), HttpStatus.ACCEPTED);
    }
}
