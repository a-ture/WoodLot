package it.unisa.WoodLot.sevice.gestioneCatalogo.prodotto;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import it.unisa.WoodLot.sevice.gestioneCatalogo.eccezioni.AlberoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * La classe fornisce i metodi per la logica di business della gestione di un prodotto
 *
 * @author Alessia Ture
 */
@Service
public class GestioneProdottoService implements ProdottoService {

    @Autowired
    private AlberoRepository alberoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsoLocaleRepository usoLocaleRepository;

    @Autowired
    private BeneficioRepository beneficioRepository;

    @Autowired
    private PaeseOrigineRepository paeseOrigineRepository;

    /**
     * Ricerca un prodotto in base al suo id
     *
     * @param nomeAlbero id dell'albero da ricerca
     * @return l'albero ricercato
     * @throws AlberoException lanciata nel caso in cui l'id non sia associata a nessun albero nel database
     */
    @Override
    public Albero getProdotto(String nomeAlbero) throws AlberoException {
        Albero albero = alberoRepository.findById(nomeAlbero).orElse(null);
        if (albero == null)
            throw new AlberoException("L'albero non è stato trovato");
        return albero;
    }

    /**
     * Restituisce tutte le categorie presente nel database
     *
     * @return l'elenco delle categorie
     */
    @Override
    public Iterable<Categoria> getCategorie() {
        return categoriaRepository.findAll();
    }

    /**
     * Restituisce l'elenco degli usi locali presenti nel database
     * @return l'elenco degli usi locali
     */
    @Override
    public Iterable<UsoLocale> getUsiLocali() {
        return usoLocaleRepository.findAll();
    }

    /**
     * Restituisce l'elenco dei benefici presenti nel database
     * @return l'elenco dei benefici
     */
    @Override
    public Iterable<Beneficio> getBenefici() {
        return beneficioRepository.findAll();
    }

    /**
     * Restituisce l'elenco dei paesi presenti nel database
     * @return l'elenco dei paesi di origine
     */
    @Override
    public Iterable<PaeseOrigine> getPaesiDiOrigine() {
        return paeseOrigineRepository.findAll();
    }
}
