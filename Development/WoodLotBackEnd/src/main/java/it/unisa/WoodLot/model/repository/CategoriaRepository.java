package it.unisa.WoodLot.model.repository;

import it.unisa.WoodLot.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaccia che definisce le operazioni per la modellazione e l'accesso
 * alle informazioni persistenti relative ad una categoria
 *
 * @author Alessia Ture
 * @see Categoria
 */
public interface CategoriaRepository extends JpaRepository<Categoria, String> {
}
