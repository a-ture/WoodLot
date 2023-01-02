package it.unisa.WoodLot.model.repository;

import it.unisa.WoodLot.model.entity.Beneficio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaccia che definisce le operazioni per la modellazione e l'accesso
 * alle informazioni persistenti relative ad un beneficio
 *
 * @author Alessia Ture
 * @see Beneficio
 */
public interface BeneficioRepository extends JpaRepository<Beneficio, String> {
}
