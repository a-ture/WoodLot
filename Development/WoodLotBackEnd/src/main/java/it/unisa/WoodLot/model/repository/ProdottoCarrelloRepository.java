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

    /**
     * Permette di cercare un prodotto in un carrello in base al carrello e all'albero associato al prodotto
     *
     * @param carrello
     * @param albero
     * @return il prodotto cercato
     */
    ProdottoCarrello findByCarrelloAndAlbero(Carrello carrello, Albero albero);

    /**
     * Permette di eliminare i prodotti carrello associati a un carrello
     *
     * @param id l'identificativo del carrello
     */
    void deleteProdottoCarrellosByCarrello_Id(Long id);
}
