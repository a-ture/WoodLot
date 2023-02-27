package it.unisa.WoodLot.sevice.gestioneContadino;

import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.ProdottoOrdine;
import it.unisa.WoodLot.model.repository.ContadinoRepository;
import it.unisa.WoodLot.model.repository.ProdottoOrdineRepository;
import it.unisa.WoodLot.sevice.gestioneContadino.eccezioni.ContadinoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * La classe fornisce i metodi per la logica di business per la gestione dei contadini
 *
 * @author Alessia Ture
 */
@Service
public class GestioneContadinoService implements ContadinoService {
    @Autowired
    private ContadinoRepository contadinoRepository;

    @Autowired
    private ProdottoOrdineRepository prodottoOrdineRepository;

    /**
     * Restituisce l'elenco dei contadini presenti nel database
     *
     * @return l'elenco dei contadini
     */
    @Override
    public Iterable<Contadino> getElencoContadini() {
        return contadinoRepository.findAll();
    }

    /**
     * Restituisce l'elenco degli alberi che non sono stati assegnati a un contadino
     *
     * @return l'elenco degli alberi nello stato 'non assegnato'
     */

    @Override
    public Iterable<ProdottoOrdine> getAlberiNonAssegnati() {
        return prodottoOrdineRepository.findAllByStatoIs(ProdottoOrdine.Stato.NonAssegnato);
    }

    @Override
    @Transactional
    public ProdottoOrdine aggiornaStato(ProdottoOrdine prodottoOrdine) throws ContadinoException {
        ProdottoOrdine p = prodottoOrdineRepository.findById(prodottoOrdine.getId()).orElse(null);
        if (p == null)
            throw new ContadinoException("Non è stato trovato il prodotto ordine");
        p.setStato(prodottoOrdine.getStato());
        p.setDescrizione(prodottoOrdine.getDescrizione());
        p.setFrutta(prodottoOrdine.getFrutta());
        return prodottoOrdineRepository.save(prodottoOrdine);
    }

    /**
     * Restituisce l'elenco degli alberi assegnati a un contadino
     *
     * @param idContadino l'id del contadino
     * @return
     */
    @Override
    public Iterable<ProdottoOrdine> elencoAlberiContadino(Long idContadino) {
        return prodottoOrdineRepository.findAllByContadino_Id(idContadino);
    }
}
