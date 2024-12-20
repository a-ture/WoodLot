package it.unisa.WoodLot.model.repository;

import it.unisa.WoodLot.model.entity.ResponsabileCatalogo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaccia che definisce le operazioni per la modellazione e l'accesso
 * alle informazioni persistenti relative a un responsabile catalogo
 *
 * @author Alessia Ture
 * @see ResponsabileCatalogo
 */
public interface ResponsabileCatalogoRepository extends JpaRepository<ResponsabileCatalogo, Long> {
    /**
     * Permette di trovare un responsabile catalogo in base all'email e alla password
     *
     * @param email    l'email del responsabile del catalogo
     * @param password la password del responsabile del catalogo
     * @return il responsabile del catalogo
     */
    ResponsabileCatalogo findResponsabileCatalogoByEmailAndPassword(String email, String password);

    /**
     * Permette di trovare un responsabile catalogo in base all'email
     *
     * @param email l'email del responsabile del catalogo
     * @return il responsabile del catalogo
     */
    ResponsabileCatalogo findResponsabileCatalogoByEmail(String email);
}
