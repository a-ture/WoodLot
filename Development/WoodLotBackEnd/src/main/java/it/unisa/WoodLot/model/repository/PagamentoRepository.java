package it.unisa.WoodLot.model.repository;


import it.unisa.WoodLot.model.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * Interfaccia che definisce le operazioni per la modellazione e l'accesso
 * alle informazioni persistenti relative ai pagamenti ai contadini
 *
 * @author Alessia Ture
 * @see Pagamento
 */
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    ArrayList<Pagamento> findAllByContadino_Id(Long idContadino);
}
