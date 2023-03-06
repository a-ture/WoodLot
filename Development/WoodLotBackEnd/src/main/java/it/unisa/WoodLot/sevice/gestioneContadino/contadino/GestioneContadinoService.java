package it.unisa.WoodLot.sevice.gestioneContadino.contadino;

import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.ProdottoOrdine;
import it.unisa.WoodLot.model.repository.ContadinoRepository;
import it.unisa.WoodLot.model.repository.ProdottoOrdineRepository;
import it.unisa.WoodLot.sevice.gestioneContadino.eccezioni.ContadinoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;


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

    /**
     * Permette di aggiornare lo stato di albero
     *
     * @param prodottoOrdine l'albero che deve essere aggiornato
     * @return il prodotto aggiornato
     * @throws ContadinoException
     */
    @Override
    @Transactional
    public ProdottoOrdine aggiornaStato(ProdottoOrdine prodottoOrdine) throws ContadinoException {
        ProdottoOrdine p = prodottoOrdineRepository.findById(prodottoOrdine.getId()).orElse(null);
        if (p == null)
            throw new ContadinoException("Non è stato trovato il prodotto ordine");

        if (prodottoOrdine.getStato().equals(ProdottoOrdine.Stato.Riassegnazione)) {
            p.setContadino(prodottoOrdine.getContadino());
            p.setDataModifica(null);
            p.setDataAssegnazione(null);
            p.setStato(ProdottoOrdine.Stato.Riassegnazione);
        } else if (prodottoOrdine.getStato().equals(ProdottoOrdine.Stato.Assegnato)) {
            p.setContadino(prodottoOrdine.getContadino());
            p.setDataModifica(null);
            p.setDataAssegnazione(new Date());
            p.setStato(ProdottoOrdine.Stato.Assegnato);
            p.setDescrizione("Il tuo albero è stato presto in cura dal contadino! Presto verrà piantato");
        } else {
            p.setStato(prodottoOrdine.getStato());
            p.setDescrizione(prodottoOrdine.getDescrizione());
            p.setFrutta(prodottoOrdine.getFrutta());
            p.setDataModifica(new Date());
        }
        return prodottoOrdineRepository.save(p);
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

    /**
     * Restituisce l'elenco dei prodotti che devono essere revisionati dal responsabile ordini
     *
     * @return l'elenco dei prodotti ordini che si trovano nello stato 'revisione'
     */
    @Override
    public Iterable<ProdottoOrdine> prodottiDaRiassegnare() {
        return prodottoOrdineRepository.findAllByStatoIs(ProdottoOrdine.Stato.Riassegnazione);
    }

    /**
     * Restituisce l'elenco dei prodotti che devono essere revisionati dal responsabile ordini
     *
     * @return l'elenco dei prodotti ordini che si trovano nello stato 'revisione'
     */
    @Override
    public Iterable<ProdottoOrdine> prodottiDaRevisionare() {
        return prodottoOrdineRepository.findAllByStatoIs(ProdottoOrdine.Stato.Revisione);
    }
}
