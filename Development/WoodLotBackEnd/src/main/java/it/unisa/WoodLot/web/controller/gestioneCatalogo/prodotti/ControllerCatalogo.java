package it.unisa.WoodLot.web.controller.gestioneCatalogo.prodotti;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.sevice.gestioneCatalogo.prodotti.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Controller per la gestione del catalogo
 *
 * @author Alessia Ture
 */

@RestController
@RequestMapping("/api/catalogo")
public class ControllerCatalogo {

    @Autowired
    private CatalogoService catalogoService;

    /**
     * Metodo POST per inserire un prodotto nel catalogo
     *
     * @param albero è il prodotto da inserire nel catalogo
     * @return true se l'inserimento ha avuto esito positivo, false altrimenti
     */
    @PostMapping("/inserimentoProdotto")
    public boolean inserimentoCatalogo(@RequestBody Albero albero) {
        Albero a = catalogoService.aggiungiProdotto(albero);
        return a.getNome() == null ? false : true;
    }

    /**
     * Metodo POST per eliminare un prodotto dal catalogo
     *
     * @param albero è il prodotto da eliminare dal catalogo
     */
    @PostMapping("/eliminaProdotto")
    public void eliminaProdottoCatalgo(@RequestBody Albero albero) {
        catalogoService.eliminaProdotto(albero);
    }

}
