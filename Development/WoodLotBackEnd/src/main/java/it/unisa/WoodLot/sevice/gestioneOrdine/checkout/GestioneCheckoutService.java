package it.unisa.WoodLot.sevice.gestioneOrdine.checkout;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import it.unisa.WoodLot.sevice.gestioneOrdine.eccezioni.OrdineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe fornisce i metodi per la logica di business per il checkout
 *
 * @author Alessia Ture
 */
@Service
public class GestioneCheckoutService implements CheckoutService {
    @Autowired
    private OrdineRepository ordineRepository;

    @Autowired
    private CarrelloRepository carrelloRepository;
    @Autowired
    private ProdottoOrdineRepository prodottoOrdineRepository;

    @Autowired
    private ProdottoCarrelloRepository prodottoCarrelloRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    /**
     * Permette di creare un nuovo
     *
     * @param idUtente l'id dell'utente che deve effettuare l'ordine
     * @return il nuovo ordine
     */
    @Transactional
    public Ordine effettuareOrdine(Long idUtente) {

        Utente utente = utenteRepository.findById(idUtente).orElse(null);
        if (utente == null)
            throw new OrdineException("L'utente non è stato trovato");

        Carrello carrello = carrelloRepository.findByUtente_Id(idUtente);
        Ordine ordine = new Ordine();
        if (carrello == null)
            throw new OrdineException("Il tuo carrello è nullo");
        if (carrello.getProdottiCarrello().size() == 0)
            throw new OrdineException("Il tuo carrello è vuoto! Aggiungi degli alberi prima di continuare");

        ordine.setDataOrdine(LocalDate.now());
        ordine.setUtente(utente);

        List<ProdottoCarrello> prodottiCarrello = carrello.getProdottiCarrello();
        for (ProdottoCarrello prodottoCarrello : prodottiCarrello) {
            ProdottoOrdine prodottoOrdine = new ProdottoOrdine();
            prodottoOrdine.setAnidrideCarbonicaAssorbita(prodottoCarrello.getAlbero().getAnidrideCarbonicaAssorbita());
            // facciamo una nuova lista per evitare la condivisione della lista
            List<Beneficio> benefici = new ArrayList<>(prodottoCarrello.getAlbero().getBenefici());
            prodottoOrdine.setBenefici(benefici);
            // facciamo una nuova lista per evitare la condivisione della lista
            List<UsoLocale> usi = new ArrayList<>(prodottoCarrello.getAlbero().getUsiLocali());
            prodottoOrdine.setUsiLocali(usi);
            prodottoOrdine.setNomeAlbero(prodottoCarrello.getAlbero().getNome());
            prodottoOrdine.setPrezzoUnitario(prodottoCarrello.getAlbero().getPrezzo());
            prodottoOrdine.setStato(ProdottoOrdine.Stato.NonAssegnato);
            prodottoOrdine.setPaeseOrigine(prodottoCarrello.getAlbero().getPaeseOrigine());
            prodottoOrdine.setDescrizione("Il tuo albero presto conoscerà il suo contadino!");
            ordine.aggiungiProdotto(prodottoOrdine);
            prodottoCarrelloRepository.deleteById(prodottoCarrello.getId());
        }

        carrello.svuotareCarrello();
        carrelloRepository.save(carrello);
        prodottoOrdineRepository.saveAll(ordine.getProdottiOrdine());
        ordine = ordineRepository.save(ordine);
        return ordine;

    }

}
