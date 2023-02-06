package it.unisa.WoodLot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Classe che modella il carrello di un utente
 *
 * @author Alessia Ture
 */
@Data
@Entity
@Table(name = "carrello")
public class Carrello implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne()
    @JoinColumn()
    private Utente utente;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<ProdottoCarrello> prodottiCarrello;

    public Carrello() {
        prodottiCarrello = new ArrayList<>();
    }

    /**
     * Permette di aggiungere un prodotto al carrello
     *
     * @param prodottoCarrello il prodotto da aggiungere
     */
    public void aggiungiProdottoCarrello(ProdottoCarrello prodottoCarrello) {
        prodottiCarrello.add(prodottoCarrello);
    }

    /**
     * Permette di rimuovere un prodotto dal carrello
     *
     * @param prodottoCarrello il prodotto da rimuovere
     */
    public void rimuoviProdotto(ProdottoCarrello prodottoCarrello) {
        prodottiCarrello.remove(prodottoCarrello);
    }

    /**
     * Permette di svuotare il carrello
     */
    public void svuotareCarrello() {
        prodottiCarrello.clear();
    }

}
