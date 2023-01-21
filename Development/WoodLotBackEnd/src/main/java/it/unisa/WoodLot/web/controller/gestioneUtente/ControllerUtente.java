package it.unisa.WoodLot.web.controller.gestioneUtente;

import it.unisa.WoodLot.model.entity.Utente;
import it.unisa.WoodLot.sevice.gestioneUtente.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utente")
public class ControllerUtente {

    @Autowired
    private UtenteService utenteService;


    @PostMapping("/registrazione")
    public Utente registrazione(@RequestBody Utente utente) {
        return utenteService.registrazione(utente);
    }

}
