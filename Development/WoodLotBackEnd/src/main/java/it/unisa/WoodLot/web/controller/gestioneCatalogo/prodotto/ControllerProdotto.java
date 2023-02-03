package it.unisa.WoodLot.web.controller.gestioneCatalogo.prodotto;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni.AlberoException;
import it.unisa.WoodLot.sevice.gestioneCatalogo.prodotto.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/{nomeProdotto}")
    public Albero restituisciProdotto(@PathVariable(value = "nomeProdotto") String parametro) throws AlberoException {
        return prodottoService.getProdotto(parametro);
    }


}
