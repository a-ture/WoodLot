package it.unisa.WoodLot.sevice.gestioneCatalogo;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.model.repository.AlberoRepository;
import it.unisa.WoodLot.model.repository.CategoriaRepository;
import it.unisa.WoodLot.model.repository.PaeseOrigineRepository;
import it.unisa.WoodLot.model.repository.UsoLocaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * La classe fornisce i metodi per la logica di business della gestione del catalgo
 *
 * @author Alessia Ture
 */
@Service
public class GestioneCatalogoService implements CatalogoService {

    @Autowired
    private AlberoRepository alberoRepository;

    @Autowired
    private PaeseOrigineRepository paeseOrigineRepository;

    @Autowired
    private UsoLocaleRepository usoLocaleRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    /**
     * Restituisce tutti i prodotti presenti nel catalogo
     *
     * @return i prodotto presenti nel DB
     */
    @Override
    public Set<Albero> getProdotti() {
        Spliterator<Albero> prodotti = alberoRepository.findAll().spliterator();
        return StreamSupport.stream(prodotti, false).collect(Collectors.toSet());
    }

    /**
     * Restituisce i prodotti ordinati in base al prezzo crescente o decrescente
     *
     * @param parametro rappresenta il paramentro di filtraggio,
     *                  può essere: prezzoCrescente, prezzoDecrescente
     * @return i prodotti ordinati in base al prezzo crescete o descrecente
     */
    @Override
    public Set<Albero> getProdottiFiltratiByPrezzo(String parametro) {
        if (parametro.equalsIgnoreCase("prezzoCrescente")) {
            return alberoRepository.findAllByOrderByPrezzoAsc();
        } else if (parametro.equalsIgnoreCase("prezzoDecrescente")) {
            return alberoRepository.findAllByOrderByPrezzoDesc();
        }
        return null;  // restituisce null nel caso il parametro sia sbagliato
    }

    /**
     * Restituisce tutti i prodotti presenti nel catalogo ordinati  in base al valore dell'anidride carbonica
     *
     * @param parametro rappresenta il paramentro di filtraggio,
     *                  può essere: anidrideCrescente, anidrideDecrescente
     * @return i prodotti ordinati in base al valore dell'anidride carbonica
     */
    @Override
    public Set<Albero> getProdottiFiltratiByAnidrideCarbonica(String parametro) {
        if (parametro.equalsIgnoreCase("anidrideCrescente")) {
            return alberoRepository.findAllByOrderByAnidirdeCarbonicaAssorbitaAsc();
        } else if (parametro.equalsIgnoreCase("anidrideDecrescente")) {
            return alberoRepository.findAllByOrderByAnidirdeCarbonicaAssorbitaDesc();
        }
        return null;  // restituisce null nel caso il parametro sia sbagliato
    }

    /**
     * Restituisce tutti i prodotti presenti nel catalogo filtrati in base al paese in cui vengono piantati
     *
     * @param nomePaese rappresenta il paramentro di filtraggio,
     * @return un set degli alberi che vengono piantati nel paese indicato
     */
    @Override
    public Set<Albero> getProdottiFiltratiByPaese(String nomePaese) {

        return alberoRepository.findAllByPaeseOrigine(paeseOrigineRepository.findById(nomePaese));

    }

    /**
     * Restituisce tutti i prodotti presenti nel catalogo filtrati in base ad un loro uso locale
     *
     * @param usoLocale l'uso locale in base al quale effettuare il filtraggio
     * @return un set di alberi che ha l'uso locale specificato
     */
    @Override
    public Set<Albero> getProdottiFiltratiByUsoLocale(String usoLocale) {
        return alberoRepository.findAllByUsiLocali(usoLocaleRepository.findById(usoLocale));
    }

    /**
     * Restituisce tutti i prodotti presenti nel catalogo filtrati in base alla categoria
     *
     * @param nomeCategoria la categoria in base alla quale effettuare il filtraggio
     * @return un set di alberi che ha come categoria quella indicata
     */
    @Override
    public Set<Albero> getProdottiFiltratiByCategoria(String nomeCategoria) {
        return alberoRepository.findAllByCategoria(categoriaRepository.findById(nomeCategoria));
    }

    /**
     * Permette di aggiungere un prodotto nel catalogo
     *
     * @param albero è il prodotto da inserire
     * @return albero il prdotto inserito nel database.
     */
    @Override
    public Albero aggiungiProdotto(Albero albero) {
        return alberoRepository.save(albero);
    }

    /**
     * Permette di eliminare un albero dal catalogo
     *
     * @param albero l'albero da eliminare
     */
    @Override
    public void eliminaProdotto(Albero albero) {
        alberoRepository.delete(albero);
    }
}
