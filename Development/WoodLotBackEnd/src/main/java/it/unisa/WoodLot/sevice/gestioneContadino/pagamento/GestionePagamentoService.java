package it.unisa.WoodLot.sevice.gestioneContadino.pagamento;

import it.unisa.WoodLot.model.entity.Pagamento;
import it.unisa.WoodLot.model.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * La classe fornisce i metodi per la logica di business per la gestione dei pagamenti a un contadino
 *
 * @author Alessia Ture
 */
@Service
public class GestionePagamentoService implements PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    /**
     * Fornisce tutti i pagamenti effettuati verso un contadino
     *
     * @param idContadino l'id del contadino di cui vogliamo visualizzare i pagamenti
     * @return
     */
    @Override
    public Iterable<Pagamento> visualizzaElencoPagamenti(Long idContadino) {
        return pagamentoRepository.findAllByContadino_Id(idContadino);
    }
}
