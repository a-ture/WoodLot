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
    ResponsabileCatalogo findResponsabileCatalogoByEmailAndPassword(String email, String password);
}
