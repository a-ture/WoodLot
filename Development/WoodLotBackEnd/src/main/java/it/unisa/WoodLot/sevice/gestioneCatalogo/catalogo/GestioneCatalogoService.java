package it.unisa.WoodLot.sevice.gestioneCatalogo.catalogo;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.model.repository.AlberoRepository;
import it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni.AlberoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Albero aggiungiProdotto(Albero albero) throws AlberoException {

        if (alberoRepository.existsById(albero.getNome()))
            throw new AlberoException("Questo nome è già presente nel catalogo! Scegline un altro");
        return alberoRepository.save(albero);
    }

    /**
     * Permette di eliminare un albero dal catalogo
     *
     * @param idAlbero l'id dell'albero da eliminare
     */
    @Override
    public void eliminaProdotto(String idAlbero) {

        alberoRepository.deleteById(idAlbero);
    }
}
