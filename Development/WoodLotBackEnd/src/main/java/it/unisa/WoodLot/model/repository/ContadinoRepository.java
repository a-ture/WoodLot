package it.unisa.WoodLot.model.repository;

import it.unisa.WoodLot.model.entity.Contadino;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaccia che definisce le operazioni per la modellazione e l'accesso
 * alle informazioni persistenti relative ad un contadino
 *
 * @author Alessia Ture
 * @see Contadino
 */
public interface ContadinoRepository extends JpaRepository<Contadino, Long> {
    Contadino findContadinoByEmailAndPassword(String email, String password);
}
