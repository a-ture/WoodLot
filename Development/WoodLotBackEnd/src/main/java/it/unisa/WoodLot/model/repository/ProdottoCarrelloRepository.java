package it.unisa.WoodLot.model.repository;

import it.unisa.WoodLot.model.entity.Albero;
import it.unisa.WoodLot.model.entity.Carrello;
import it.unisa.WoodLot.model.entity.ProdottoCarrello;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interfaccia che definisce le operazioni per la modellazione e l'accesso
 * alle informazioni persistenti relative a un prodotto in un carrello
 *
 * @author Alessia Ture
 * @see ProdottoCarrello
 */
public interface ProdottoCarrelloRepository extends JpaRepository<ProdottoCarrello, Long> {


}
