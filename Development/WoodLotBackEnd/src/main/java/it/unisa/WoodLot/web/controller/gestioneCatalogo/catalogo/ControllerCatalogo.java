package it.unisa.WoodLot.web.controller.gestioneCatalogo.catalogo;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni.AlberoException;
import it.unisa.WoodLot.sevice.gestioneCatalogo.catalogo.CatalogoService;
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
    public boolean inserimentoCatalogo(@RequestBody Albero albero) throws AlberoException {
        Albero a = catalogoService.aggiungiProdotto(albero);
        return a.getNome() == null ? false : true;
    }

    /**
     * Metodo POST per eliminare un prodotto dal catalogo
     *
     * @param idAlbero è l'id del albero da eliminare dal catalogo
     */
    @GetMapping("/eliminaProdotto/{idAlbero}")
    public void eliminaProdottoCatalgo(@PathVariable String idAlbero) {
        catalogoService.eliminaProdotto(idAlbero);
    }

}
