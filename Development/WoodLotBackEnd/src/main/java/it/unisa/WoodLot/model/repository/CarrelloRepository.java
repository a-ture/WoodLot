package it.unisa.WoodLot.model.repository;

import it.unisa.WoodLot.model.entity.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaccia che definisce le operazioni per la modellazione e l'accesso
 * alle informazioni persistenti relative ad un carrello
 *
 * @author Alessia Ture
 * @see Carrello
 */
public interface CarrelloRepository extends JpaRepository<Carrello, Long> {
}
