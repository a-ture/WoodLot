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
    /**
     * Permette di trovare un responsabile ordini in base all'email e alla password
     *
     * @param email    l'email del responsabile ordini
     * @param password la password del responsabile ordini
     * @return il responsabile ordini
     */
    ResponsabileOrdini findByEmailAndPassword(String email, String password);

    /**
     * Permette di trovare un responsabile ordini in base all'email
     *
     * @param email l'email del responsabile ordini
     * @return il responsabile ordini
     */
    ResponsabileOrdini findByEmail(String email);
}
