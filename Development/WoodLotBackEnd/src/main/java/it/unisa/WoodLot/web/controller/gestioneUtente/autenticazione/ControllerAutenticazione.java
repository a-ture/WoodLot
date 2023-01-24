package it.unisa.WoodLot.web.controller.gestioneUtente.autenticazione;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.sevice.gestioneUtente.autenticazione.AutenticazioneService;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.LoginException;
import it.unisa.WoodLot.sevice.gestioneUtente.eccezioni.PasswordException;
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
     * @return l'utente
     * @throws LoginException se le credenziali sono errate
     */
    @PostMapping("/login")
    public UtenteRegistrato login(@RequestBody UtenteRegistrato utenteRegistrato) throws LoginException {
        return autenticazioneService.login(utenteRegistrato.getEmail(), utenteRegistrato.getPassword());
    }

    /**
     * Metodo GET per effettuare il logout
     */
    @GetMapping("/logout")
    public void logout() {
        autenticazioneService.logout();
    }


    @PostMapping("/reimpostarePassword")
    public void reimpostarePassword(@RequestBody UtenteRegistrato utenteRegistrato) throws PasswordException {
        autenticazioneService.reimpostaPassword(utenteRegistrato.getEmail(), utenteRegistrato.getPassword());
    }
}
