package it.unisa.WoodLot.sevice.gestioneCatalogo.prodotti;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.model.repository.AlberoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * La classe fornisce i metodi per la logica di business della gestione del catalogo
 *
 * @author Alessia Ture
 */
@Service
public class GestioneCatalogoService implements CatalogoService {

    @Autowired
    private AlberoRepository alberoRepository;


    /**
     * Permette di aggiungere un prodotto nel catalogo
     *
     * @param albero è il prodotto da inserire
     * @return albero il prodotto inserito nel database.
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
