package it.unisa.WoodLot.sevice.gestioneOrdine.checkout;

import it.unisa.WoodLot.model.entity.Ordine;

/**
 * Interfaccia che fornisce i metodi per la logica di business del checkout
 *
 * @author Alessia Ture
 */
public interface CheckoutService {
    Ordine effettuareOrdine(Long idUtente);
}
