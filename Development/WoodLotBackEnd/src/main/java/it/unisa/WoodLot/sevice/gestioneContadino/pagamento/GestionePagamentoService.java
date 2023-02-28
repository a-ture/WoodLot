package it.unisa.WoodLot.sevice.gestioneContadino.pagamento;

import it.unisa.WoodLot.model.entity.Contadino;
import it.unisa.WoodLot.model.entity.Pagamento;
import it.unisa.WoodLot.model.repository.ContadinoRepository;
import it.unisa.WoodLot.model.repository.PagamentoRepository;
import it.unisa.WoodLot.sevice.gestioneContadino.eccezioni.ContadinoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * La classe fornisce i metodi per la logica di business per la gestione dei pagamenti a un contadino
 *
 * @author Alessia Ture
 */
@Service
public class GestionePagamentoService implements PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private ContadinoRepository contadinoRepository;

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

    /**
     * Permette di creare un nuovo pagamento
     *
     * @param pagamento
     * @return
     */
    @Override
    public Pagamento effettuarePagamento(Pagamento pagamento) throws ContadinoException {
        Contadino contadino = contadinoRepository.findById(pagamento.getContadino().getId()).orElse(null);
        if (contadino == null)
            throw new ContadinoException("L'id fornito non è valido");

        Pagamento p = new Pagamento();
        p.setMotivazioni(pagamento.getMotivazioni());
        p.setDataPagamento(new Date());
        p.setImporto(pagamento.getImporto());
        p.setContadino(contadino);
        return pagamentoRepository.save(p);
    }
}
