package it.unisa.WoodLot.web.controller.gestioneCatalogo;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.sevice.gestioneCatalogo.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    /**
     * Metodo GET che restituisce i prodotti ordinati in base al prezzo crescente o decrescente
     *
     * @param parametro indica come vogliamo effettuare l'ordinamento, specificare prezzoCrescente per ordinare per prezzo crescente,
     *                  specificare prezzoDecrecente per ordinare per prezzo decrescente
     * @return i prodotti ordinati in base al prezzo crescete o decrescente
     */
    @GetMapping("/filtroPrezzo/{prezzo}")
    public Set<Albero> restituisciProdottiFiltratiByPrezzo(@PathVariable(value = "prezzo") String parametro) {
        return catalogoService.getProdottiFiltratiByPrezzo(parametro);
    }

    /**
     * Metodo GET che restituisce i prodotti filtrati in base al paese in cui vengono piantati
     *
     * @param parametro il paese usato per il filtraggio
     * @return un set degli alberi che vengono piantati nel paese indicato
     */
    @GetMapping("/filtroPaese/{nomePaese}")
    public Set<Albero> restituisciProdottiFiltratiByPaese(@PathVariable(value = "nomePaese") String parametro) {
        return catalogoService.getProdottiFiltratiByPaese(parametro);
    }

    /**
     * Metodo GET che restituisce i prodotti filtrati in base all'uso locale
     *
     * @param parametro l'uso locale in base al quale effettuare il filtraggio
     * @return un set di alberi che ha l'uso locale specificato
     */
    @GetMapping("/filtroUsoLocale/{nomeUsoLocale}")
    public Set<Albero> restituisciProdottiFiltratiByUsoLocale(@PathVariable(value = "nomeUsoLocale") String parametro) {
        return catalogoService.getProdottiFiltratiByUsoLocale(parametro);
    }

    /**
     * Restituisce tutti i prodotti presenti nel catalogo filtrati in base alla categoria
     *
     * @param parametro la categoria in base alla quale effettuare il filtraggio
     * @return un set di alberi che ha come categoria quella indicata
     */
    @GetMapping("/filtroCategoria/{nomeCategoria}")
    public Set<Albero> restituisciProdottiByCategoria(@PathVariable(value = "nomeCategoria") String parametro) {
        return catalogoService.getProdottiFiltratiByCategoria(parametro);
    }

    /**
     * Restituisce tutti i prodotti presenti nel catalogo ordinati in base all'anidride carbonica
     *
     * @param parametro rappresenta il parametro di filtraggio dell'anidride carbonica
     * @return tutti i prodotti presenti nel db ordinati in base al valore dell'anidride carboncica crescete o descrecente
     */
    @GetMapping("/filtroAndirideCarbonica/{anidrideCarbonica}")
    public Set<Albero> restituisciProdottiByAnidrideCarbonica(@PathVariable(value = "anidrideCarbonica") String parametro) {
        return catalogoService.getProdottiFiltratiByAnidrideCarbonica(parametro);
    }

    /**
     * Restituisce tutti i prodotti del catalogo
     *
     * @return un set contenente tutti i prodotti
     */
    @GetMapping("/prodotti")
    public Set<Albero> restituisciProdotti() {
        return catalogoService.getProdotti();
    }
}
