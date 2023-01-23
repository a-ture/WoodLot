package it.unisa.WoodLot.sevice.gestioneOrdine.ordini;

import it.unisa.WoodLot.model.entity.*;
import it.unisa.WoodLot.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * La classe fornisce i metodi per la logica di business per la gestione degli ordini
 *
 * @author Alessia Ture
 */
@Service
public class GestioneOrdineService implements OrdineService {

    @Autowired
    private OrdineRepository ordineRepository;

    /**
     * Restituisce tutti gli ordini
     *
     * @return tutti gli ordini
     */
    @Override
    public Iterable<Ordine> restituisciOrdini() {
        return this.ordineRepository.findAll();
    }


    /**
     * Permette di avere lo storico degli ordini di un utente
     *
     * @param idUtente l'id dell'utente di cui avere lo storico
     * @return gli ordini dell'utente
     */
    @Override
    public List<Ordine> visualizzaOrdiniUtente(Long idUtente) {
        return ordineRepository.findOrdineByUtente_Id(idUtente);
    }
}
