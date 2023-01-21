package it.unisa.WoodLot.web.controller.gestioneCatalogo.filtri;

import it.unisa.WoodLot.model.entity.Albero;

import it.unisa.WoodLot.sevice.gestioneCatalogo.filtri.FiltriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller per i filtri del catalogo
 *
 * @author Alessia Ture
 */
@RestController
@RequestMapping("/api/filtri")
public class ControllerFiltri {

    @Autowired
    private FiltriService filtriService;

    /**
     * Metodo GET per restituire tutti i prodotti del catalogo
     *
     * @return un set contenente tutti i prodotti
     */
    @GetMapping("/prodotti")
    public Iterable<Albero> restituisciProdotti() {
        return filtriService.getProdotti();
    }

    /**
     * Metodo GET che restituisce i prodotti ordinati in base al prezzo crescente o decrescente
     *
     * @param parametro indica come vogliamo effettuare l'ordinamento, specificare prezzoCrescente per ordinare per prezzo crescente,
     *                  specificare prezzoDecrecente per ordinare per prezzo decrescente
     * @return i prodotti ordinati in base al prezzo crescete o decrescente
     */
    @GetMapping("/filtroPrezzo/{prezzo}")
    public Iterable<Albero> restituisciProdottiFiltratiByPrezzo(@PathVariable(value = "prezzo") String parametro) {
        return filtriService.getProdottiFiltratiByPrezzo(parametro);
    }

    /**
     * Metodo GET che restituisce i prodotti filtrati in base al paese in cui vengono piantati
     *
     * @param parametro il paese usato per il filtraggio
     * @return un set degli alberi che vengono piantati nel paese indicato
     */
    @GetMapping("/filtroPaese/{nomePaese}")
    public Iterable<Albero> restituisciProdottiFiltratiByPaese(@PathVariable(value = "nomePaese") String parametro) {
        return filtriService.getProdottiFiltratiByPaese(parametro);
    }

    /**
     * Metodo GET che restituisce i prodotti filtrati in base all'uso locale
     *
     * @param parametro l'uso locale in base al quale effettuare il filtraggio
     * @return un set di alberi che ha l'uso locale specificato
     */
    @GetMapping("/filtroUsoLocale/{nomeUsoLocale}")
    public Iterable<Albero> restituisciProdottiFiltratiByUsoLocale(@PathVariable(value = "nomeUsoLocale") String parametro) {
        return filtriService.getProdottiFiltratiByUsoLocale(parametro);
    }

    /**
     * Metodo GET che restituisce tutti i prodotti presenti nel catalogo filtrati in base alla categoria
     *
     * @param parametro la categoria in base alla quale effettuare il filtraggio
     * @return un set di alberi che ha come categoria quella indicata
     */
    @GetMapping("/filtroCategoria/{nomeCategoria}")
    public Iterable<Albero> restituisciProdottiByCategoria(@PathVariable(value = "nomeCategoria") String parametro) {
        return filtriService.getProdottiFiltratiByCategoria(parametro);
    }

    /**
     * Metodo GET che restituisce tutti i prodotti presenti nel catalogo ordinati in base all'anidride carbonica
     *
     * @param parametro rappresenta il parametro di filtraggio dell'anidride carbonica
     * @return tutti i prodotti presenti nel db ordinati in base al valore dell'anidride carboncica crescete o descrecente
     */
    @GetMapping("/filtroAndirideCarbonica/{anidrideCarbonica}")
    public Iterable<Albero> restituisciProdottiByAnidrideCarbonica(@PathVariable(value = "anidrideCarbonica") String parametro) {
        return filtriService.getProdottiFiltratiByAnidrideCarbonica(parametro);
    }
}
