package it.unisa.WoodLot.model.repository;

import it.unisa.WoodLot.model.entity.ProdottoOrdine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * Interfaccia che definisce le operazioni per la modellazione e l'accesso
 * alle informazioni persistenti relative ad un prodotto ordine
 *
 * @author Alessia Ture
 * @see ProdottoOrdine
 */
public interface ProdottoOrdineRepository extends JpaRepository<ProdottoOrdine, Long> {

    Iterable<ProdottoOrdine> findAllByStatoIs(ProdottoOrdine.Stato stato);

    ArrayList<ProdottoOrdine> findAllByContadino_Id(Long id);
}
