package it.unisa.WoodLot.web.controller.gestioneUtente.registrazione;

import it.unisa.WoodLot.model.entity.Utente;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.RegistrazioneException;
import it.unisa.WoodLot.sevice.gestioneUtente.registrazione.RegistrazioneService;
import it.unisa.WoodLot.web.controller.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller per la registrazione utente
 *
 * @author Alessia Ture
 */
@RestController
@RequestMapping("/api/registrazione")
public class ControllerRegistrazione {

    @Autowired
    private RegistrazioneService registrazioneService;

    /**
     * Metodo POST per registrare un nuovo utente
     *
     * @param utente l'utente da registrare
     * @return l'utente registrato
     */
    @PostMapping("/registrazioneUtente")
    public ResponseEntity<Object> registrazione(@RequestBody Utente utente) {
        try {
            Utente nuovoUtente = registrazioneService.registrazione(utente);
            return new ResponseEntity<>(nuovoUtente, HttpStatus.CREATED);
        } catch (RegistrazioneException e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }

}
