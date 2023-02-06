package it.unisa.WoodLot.model.repository;

import it.unisa.WoodLot.model.entity.Carrello;
import it.unisa.WoodLot.model.entity.ProdottoCarrello;
import it.unisa.WoodLot.model.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Interfaccia che definisce le operazioni per la modellazione e l'accesso
 * alle informazioni persistenti relative a un carrello
 *
 * @author Alessia Ture
 * @see Carrello
 */
public interface CarrelloRepository extends JpaRepository<Carrello, Long> {
    /**
     * Permette di cercare il carrello in base all'id del utente proprietario
     *
     * @param id l'identificativo del utente
     * @return il carrello cercato
     */
    Carrello findByUtente_Id(Long id);

    void deleteByProdottiCarrelloAndId(Long idProdotto, Long idCarrello);
}
