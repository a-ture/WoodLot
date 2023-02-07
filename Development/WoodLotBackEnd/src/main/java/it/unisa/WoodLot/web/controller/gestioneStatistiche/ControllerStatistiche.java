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

    @GetMapping("/utente/{idUtente}")
    public ResponseEntity<Object> visualizzaStatisticheUtente(@PathVariable Long idUtente) {
        return new ResponseEntity<>(statisticheService.statistichePaginaUtente(idUtente), HttpStatus.ACCEPTED);
    }
}
