package it.unisa.WoodLot.sevice.gestioneOrdine;

import it.unisa.WoodLot.model.entity.Ordine;
import it.unisa.WoodLot.model.repository.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
     * Salva un nuovo ordine
     *
     * @param ordine
     * @return il nuovo ordine
     */
    @Override
    public Ordine effetuaOrdine(Ordine ordine) {
        ordine.setDataOrdine(LocalDate.now());
        return this.ordineRepository.save(ordine);
    }

    @Override
    public void aggiornaOrdine(Ordine ordine) {
        this.ordineRepository.save(ordine);
    }
}
