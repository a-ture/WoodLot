package it.unisa.WoodLot.model.repository;


import it.unisa.WoodLot.model.entity.UsoLocale;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaccia che definisce le operazioni per la modellazione e l'accesso
 * alle informazioni persistenti relative ad un uso locale
 *
 * @author Alessia Ture
 * @see UsoLocale
 */
public interface UsoLocaleRepository extends JpaRepository<UsoLocale, String> {
}
