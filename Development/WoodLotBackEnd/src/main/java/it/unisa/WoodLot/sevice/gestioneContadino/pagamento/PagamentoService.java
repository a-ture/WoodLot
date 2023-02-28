package it.unisa.WoodLot.sevice.gestioneContadino.pagamento;

import it.unisa.WoodLot.model.entity.Pagamento;
import it.unisa.WoodLot.sevice.gestioneContadino.eccezioni.ContadinoException;

/**
 * Interfaccia che fornisce i metodi per la logica di business per la gestione dei pagamenti ai contadini
 *
 * @author Alessia Ture
 */
public interface PagamentoService {

    Iterable<Pagamento> visualizzaElencoPagamenti(Long idContadino);

    Pagamento effettuarePagamento(Pagamento pagamento) throws ContadinoException;
}
