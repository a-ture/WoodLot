package it.unisa.WoodLot.model.repository;

import it.unisa.WoodLot.model.entity.ProdottoCarrello;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaccia che definisce le operazioni per la modellazione e l'accesso
 * alle informazioni persistenti relative ad un prodotto in un carrello
 *
 * @author Alessia Ture
 * @see ProdottoCarrello
 */
public interface ProdottoCarrelloRepository extends JpaRepository<ProdottoCarrello, Long> {
}
