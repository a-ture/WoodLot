package it.unisa.WoodLot.sevice.gestioneOrdine;

import it.unisa.WoodLot.model.entity.Ordine;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Interfaccia che fornisce i metodi per la logica di business della gestione degli ordini
 *
 * @author Alessia Ture
 */
public interface OrdineService {

    Iterable<Ordine> restituisciOrdini();

    Ordine effetuaOrdine(@NotNull(message = "L'ordine non può essere null") @Valid Ordine ordine);

    void aggiornaOrdine(@NotNull(message = "L'ordine non può essere null") @Valid Ordine ordine);

}
