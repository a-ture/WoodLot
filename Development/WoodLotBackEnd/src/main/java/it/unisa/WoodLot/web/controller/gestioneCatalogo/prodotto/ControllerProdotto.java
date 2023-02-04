package it.unisa.WoodLot.web.controller.gestioneCatalogo.prodotto;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni.AlberoException;
import it.unisa.WoodLot.sevice.gestioneCatalogo.prodotto.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller per la gestione di un prodotto
 *
 * @author Alessia Ture
 */
@RestController
@RequestMapping("/api/prodotto")
public class ControllerProdotto {

    @Autowired
    private ProdottoService prodottoService;


    /**
     * Metodo GET per ricercare un prodotto in base al suo id
     *
     * @param parametro l'id dell'albero da cercare
     * @return l'albero cercato
     * @throws AlberoException lanciata nel caso in cui l'albero non viene trovato
     */
    @GetMapping("/{nomeProdotto}")
    public Albero restituisciProdotto(@PathVariable(value = "nomeProdotto") String parametro) throws AlberoException {
        return prodottoService.getProdotto(parametro);
    }

    /**
     * Metodo GET per restituire tutte le categorie
     */
    @GetMapping("/categorie")
    public Iterable<Categoria> restituisciCategorie() {
        return prodottoService.getCategorie();
    }

    /**
     * Metodo GET per restituire tutti i paesi
     */
    @GetMapping("/paesi")
    public Iterable<PaeseOrigine> restituisciPaesi() {
        return prodottoService.getPaesiDiOrigine();
    }
    /**
     * Metodo GET per restituire tutti gli usi locali
     */
    @GetMapping("/usiLocali")
    public Iterable<UsoLocale> restituisciUsiLocali() {
        return prodottoService.getUsiLocali();
    }
    /**
     * Metodo GET per restituire tutti i benefici
     */
    @GetMapping("/benefici")
    public Iterable<Beneficio> restituisciBenefici() {
        return prodottoService.getBenefici();
    }

}
