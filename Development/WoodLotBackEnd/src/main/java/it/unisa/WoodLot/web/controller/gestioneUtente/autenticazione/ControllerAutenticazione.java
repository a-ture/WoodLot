package it.unisa.WoodLot.web.controller.gestioneUtente.autenticazione;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.sevice.gestioneUtente.autenticazione.AutenticazioneService;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @throws LoginException se le credenziali sono errate
     */
    @PostMapping("/login")
    public void login(@RequestBody UtenteRegistrato utenteRegistrato) throws LoginException {
        autenticazioneService.login(utenteRegistrato.getEmail(), utenteRegistrato.getPassword());

    }

    /**
     * Metodo GET per effetuare il logout
     */
    @GetMapping("/logout")
    public void logout() {
        autenticazioneService.logout();
    }
}
