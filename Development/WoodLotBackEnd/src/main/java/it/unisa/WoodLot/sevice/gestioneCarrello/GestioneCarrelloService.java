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
     * Permette di recuperare il carrello di un utente
     * Se non esiste nessun carrello associato all'utente  lo crea
     *
     * @param idUtente
     * @return
     */
    @Override
    public Carrello getCarrello(Long idUtente) throws CarrelloException {
        Utente utente = utenteRepository.findById(idUtente).orElse(null);
        if (utente == null)
            throw new CarrelloException("L'idUtente fornito non risulta associato a nessun utente");
        Carrello carrello = carrelloRepository.findByUtente_Id(idUtente);
        if (carrello == null) {
            carrello = new Carrello();
            carrello.setUtente(utente);
            carrelloRepository.save(carrello);
        }
        return carrello;
    }

    /**
     * Permette di aggiungere un prodotto a un carrello
     *
     * @param idCarrello l'id del carrello a cui aggiungere il prodotto
     * @param nomeAlbero il nome dell'albero che si intende aggiungere
     * @throws CarrelloException lanciata nel caso in cui l'utente o l'albero in input non siano validi
     */
    @Override
    public Carrello aggiungiProdotto(Long idCarrello, String nomeAlbero) throws CarrelloException {

        Albero albero = alberoRepository.findById(nomeAlbero).orElse(null);

        if (albero == null) throw new CarrelloException("L'albero non è stato trovato");

        Carrello carrello = carrelloRepository.findById(idCarrello).orElse(null);

        if (carrello == null)
            throw new CarrelloException("Il carrello non  è stato trovato");

        ProdottoCarrello prodottoCarrello = new ProdottoCarrello();
        prodottoCarrello.setAlbero(albero);
        carrello.aggiungiProdottoCarrello(prodottoCarrello);

        prodottoCarrelloRepository.save(prodottoCarrello);
        return carrelloRepository.save(carrello);
    }

    /**
     * Permette di rimuovere un prodotto da un carrello
     *
     * @param idCarrello         l'id del carrello a cui aggiungere il prodotto
     * @param idProdottoCarrello l'id del prodotto carrello da eliminare
     * @throws CarrelloException viene lanciata nel caso in cui l'idProdottoCarrello sia nullo
     */
    @Override
    public Carrello rimuoviProdotto(Long idCarrello, Long idProdottoCarrello) throws CarrelloException {
        Carrello carrello = carrelloRepository.findById(idCarrello).orElse(null);
        if (idProdottoCarrello == null)
            throw new CarrelloException("L'id fornito non è valido");

        ProdottoCarrello prodottoCarrello = prodottoCarrelloRepository.findById(idProdottoCarrello).orElse(null);

        carrello.rimuoviProdotto(prodottoCarrello);
        carrelloRepository.save(carrello);
        prodottoCarrelloRepository.deleteById(idProdottoCarrello);
        return carrelloRepository.findById(idCarrello).orElse(null);
    }


    /**
     * Permette di svuotare un carrello
     *
     * @param idCarrello l'id del carrello da svuotare
     * @throws CarrelloException
     */

    @Override
    @Transactional
    public Carrello svuotareCarrello(Long idCarrello) throws CarrelloException {
        Carrello carrello = carrelloRepository.findById(idCarrello).orElseThrow(() -> new CarrelloException("Carrello non trovato"));
        carrelloRepository.deleteById(idCarrello);
        Carrello carrello1 = new Carrello();
        carrello1.setUtente(carrello.getUtente());
        return carrelloRepository.save(carrello1);
    }
}
