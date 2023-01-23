package it.unisa.WoodLot.sevice.gestioneOrdine.ordini;

import it.unisa.WoodLot.model.entity.Ordine;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Interfaccia che fornisce i metodi per la logica di business della gestione degli ordini
 *
 * @author Alessia Ture
 */
public interface OrdineService {

    Iterable<Ordine> restituisciOrdini();

    List<Ordine> visualizzaOrdiniUtente(Long idUtente);
}
