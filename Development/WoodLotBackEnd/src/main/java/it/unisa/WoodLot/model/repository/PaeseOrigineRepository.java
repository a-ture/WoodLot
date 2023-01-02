package it.unisa.WoodLot.model.repository;

import it.unisa.WoodLot.model.entity.PaeseOrigine;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaccia che definisce le operazioni per la modellazione e l'accesso
 * alle informazioni persistenti relative ad un paese d'origine
 *
 * @author Alessia Ture
 * @see PaeseOrigine
 */
public interface PaeseOrigineRepository extends JpaRepository<PaeseOrigine, String> {
}
