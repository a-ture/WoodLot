package it.unisa.WoodLot.sevice.gestioneCatalogo.prodotto;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.model.repository.AlberoRepository;
import it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni.AlberoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * La classe fornisce i metodi per la logica di business della gestione di un prodotto
 *
 * @author Alessia Ture
 */
@Service
public class GestioneProdottoService implements ProdottoService {

    @Autowired
    private AlberoRepository alberoRepository;


    @Override
    public Albero getProdotto(String nomeAlbero) throws AlberoException {
        Albero albero = alberoRepository.findById(nomeAlbero).orElse(null);
        if (albero == null)
          throw  new AlberoException("L'albero non è stato trovato");
        return albero;
    }
}
