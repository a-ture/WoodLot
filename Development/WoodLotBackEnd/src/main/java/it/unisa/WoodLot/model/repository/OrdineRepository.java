package it.unisa.WoodLot.model.repository;

import it.unisa.WoodLot.model.entity.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interfaccia che definisce le operazioni per la modellazione e l'accesso
 * alle informazioni persistenti relative ad un ordine
 *
 * @author Alessia Ture
 * @see Ordine
 */
public interface OrdineRepository extends JpaRepository<Ordine, Long> {
    List<Ordine> findOrdineByUtente_Id(Long idUtente);
}
