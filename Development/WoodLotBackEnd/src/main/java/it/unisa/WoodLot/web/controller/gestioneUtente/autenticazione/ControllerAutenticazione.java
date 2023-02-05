package it.unisa.WoodLot.web.controller.gestioneUtente.autenticazione;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.sevice.gestioneUtente.autenticazione.AutenticazioneService;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.LoginException;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.PasswordException;
import it.unisa.WoodLot.web.controller.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller per l'autenticazione
 *
 * @author Alessia Ture
 */
@RestController
@RequestMapping("/api/autenticazione")
public class ControllerAutenticazione {
    @Autowired
    private AutenticazioneService autenticazioneService;
    @Autowired
    HttpServletRequest request;

    /**
     * Metodo POST per effettuare il login
     *
     * @param utenteRegistrato un utente registrato al sistema
     * @return l'utente
     * @throws LoginException se le credenziali sono errate
     */
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UtenteRegistrato utenteRegistrato) {
        try {
            UtenteRegistrato u = autenticazioneService.login(utenteRegistrato.getEmail(), utenteRegistrato.getPassword());
            if (u instanceof Utente)
                return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, "utente", u);
            else if (u instanceof Contadino)
                return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, "contadino", u);
            else if (u instanceof ResponsabileOrdini)
                return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, "responsabileOrdini", u);
            else
                return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, "responsabileCatalogo", u);
        } catch (LoginException e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }

    /**
     * Metodo GET per effettuare il logout
     */
    @GetMapping("/logout")
    public void logout() {
        autenticazioneService.logout();
    }

    /**
     * Metodo POST per reimpostare la password di un utente registrato
     *
     * @param utenteRegistrato
     * @throws PasswordException
     */
    @PostMapping("/reimpostarePassword")
    public ResponseEntity<Object> reimpostarePassword(@RequestBody UtenteRegistrato utenteRegistrato) {
        try {
            autenticazioneService.reimpostaPassword(utenteRegistrato.getEmail(), utenteRegistrato.getPassword());
            return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, "La password è stata cambiata con successo");
        } catch (PasswordException e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }
}
