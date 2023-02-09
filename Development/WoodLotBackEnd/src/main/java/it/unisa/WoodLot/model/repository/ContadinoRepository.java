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
    /**
     * Permette di trovare un contadino in base all'email e alla password
     *
     * @param email    l'email del contadino
     * @param password la password del contadino
     * @return il contadino
     */
    Contadino findContadinoByEmailAndPassword(String email, String password);

    /**
     * Permette di trovare un contadino in base alle sua email
     *
     * @param email
     * @return
     */
    Contadino findByEmail(String email);

}
