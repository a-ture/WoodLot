package it.unisa.WoodLot.model.repository;


import it.unisa.WoodLot.model.entity.ResponsabileOrdini;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaccia che definisce le operazioni per la modellazione e l'accesso
 * alle informazioni persistenti relative a un responsabile ordini
 *
 * @author Alessia Ture
 * @see ResponsabileOrdini
 */
public interface ResponsabileOrdiniRepository extends JpaRepository<ResponsabileOrdini, Long> {
    ResponsabileOrdini findByEmailAndPassword(String email, String password);
}
