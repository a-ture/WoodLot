package it.unisa.WoodLot.sevice.gestioneCarrello;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.model.entity.Carrello;
import it.unisa.WoodLot.model.entity.ProdottoCarrello;
import it.unisa.WoodLot.model.entity.Utente;
import it.unisa.WoodLot.model.repository.AlberoRepository;
import it.unisa.WoodLot.model.repository.CarrelloRepository;
import it.unisa.WoodLot.model.repository.ProdottoCarrelloRepository;
import it.unisa.WoodLot.model.repository.UtenteRepository;
import it.unisa.WoodLot.sevice.gestioneCarrello.eccezzioni.CarrelloException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * La classe fornisce i metodi per la logica di business per la gestione del carrello
 *
 * @author Alessia Ture
 */
@Service
public class GestioneCarrelloService implements CarrelloService {

    @Autowired
    private CarrelloRepository carrelloRepository;

    @Autowired
    private ProdottoCarrelloRepository prodottoCarrelloRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private AlberoRepository alberoRepository;

    /**
     * Permette di aggiungere un prodotto a un carrello
     *
     * @param idCarrello l'id del carrello a cui aggiungere il prodotto
     * @param idUtente   l' id dell' utente proprietario del carrello
     * @param nomeAlbero il nome dell'albero che si intende aggiungere
     * @throws CarrelloException lanciata nel caso in cui l'utente o l'albero in input non siano validi
     */
    @Override
    public void aggiungiProdotto(Long idCarrello, Long idUtente, String nomeAlbero) throws CarrelloException {
        Utente utente = utenteRepository.findById(idUtente).orElse(null);
        Albero albero = alberoRepository.findById(nomeAlbero).orElse(null);

        if (utente == null) throw new CarrelloException("L'utente non è stato trovato");
        if (albero == null) throw new CarrelloException("L'albero non è stato trovato");

        Carrello carrello = carrelloRepository.findByUtente_Id(utente.getId());
        if (carrello == null) {
            carrello = new Carrello();
            carrello.setUtente(utente);
            carrello.setProdottiCarrello(new ArrayList<>());
            carrelloRepository.save(carrello);
        }

        ProdottoCarrello prodottoCarrello = prodottoCarrelloRepository.findByCarrelloAndAlbero(carrello, albero);
        if (prodottoCarrello == null) {
            prodottoCarrello = new ProdottoCarrello();
            prodottoCarrello.setAlbero(albero);
            prodottoCarrello.setCarrello(carrello);
            prodottoCarrello.setQuantita(1);
            carrello.aggiungiProdottoCarrello(prodottoCarrello);
        } else {
            prodottoCarrello.setQuantita(prodottoCarrello.getQuantita() + 1);
        }
        prodottoCarrelloRepository.save(prodottoCarrello);
        carrelloRepository.save(carrello);
    }

    /**
     * Permette di rimuovere un prodotto da un carrello
     *
     * @param idCarrello         l'id del carrello a cui aggiungere il prodotto
     * @param idProdottoCarrello l'id del prodotto carrello da eliminare
     * @throws CarrelloException viene lanciata nel caso in cui l'idProdottoCarrello sia nullo
     */
    @Override
    public void rimuoviProdotto(Long idCarrello, Long idProdottoCarrello) throws CarrelloException {
        Carrello carrello = carrelloRepository.findById(idCarrello).orElse(null);
        if (idProdottoCarrello == null)
            throw new CarrelloException("L'id fornito non è valido");

        ProdottoCarrello prodottoCarrello = prodottoCarrelloRepository.findById(idProdottoCarrello).orElse(null);

        if (prodottoCarrello != null)
            carrello.rimuoviProdotto(prodottoCarrello);
        prodottoCarrelloRepository.deleteById(idProdottoCarrello);

    }

    /**
     * Permette di modificare la quantità di un prodotto in un carrello
     *
     * @param idCarrello         l'id del carrello in cui effettuare la modifica
     * @param idProdottoCarrello l'id del prodotto su cui effettuare la modifica
     * @param quantita           la nuova quantità del prodotto (può essere sia un numero positivo che negativo)
     * @throws CarrelloException nel caso in cui la nuova quantità del prodotto sia pari a zero
     */
    @Override
    public void modificareQuantitaProdotto(Long idCarrello, Long idProdottoCarrello, int quantita) throws CarrelloException {
        ProdottoCarrello prodottoCarrello = prodottoCarrelloRepository.findById(idProdottoCarrello).orElseThrow(() -> new CarrelloException("Prodotto non presente nel carrello"));
        int quantitaAttuale = prodottoCarrello.getQuantita();
        int nuovaQuantita = quantitaAttuale + quantita;
        if (nuovaQuantita < 0) {
            throw new CarrelloException("Non è possibile avere una quantità negativa");
        } else {
            prodottoCarrello.setQuantita(nuovaQuantita);
            prodottoCarrelloRepository.save(prodottoCarrello);
        }
    }

    /**
     * Permette di svuotare un carrello
     *
     * @param idCarrello l'id del carrello da svuotare
     * @throws CarrelloException
     */

    @Override
    @Transactional
    public void svuotareCarrello(Long idCarrello) throws CarrelloException {
        Carrello carrello = carrelloRepository.findById(idCarrello).orElseThrow(() -> new CarrelloException("Carrello non trovato"));
        if (carrello != null) {
            carrello.svuotareCarrello();
        }
        carrelloRepository.save(carrello);
        prodottoCarrelloRepository.deleteProdottoCarrellosByCarrello_Id(idCarrello);
    }
}
