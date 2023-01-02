package it.unisa.WoodLot.model.repository;

import it.unisa.WoodLot.model.entity.Albero;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaccia che definisce le operazioni per la modellazione e l'accesso
 * alle informazioni persistenti relative ad un albero
 *
 * @author Alessia Ture
 * @see Albero
 */
public interface AlberoRepository extends JpaRepository<Albero, String> {
}
