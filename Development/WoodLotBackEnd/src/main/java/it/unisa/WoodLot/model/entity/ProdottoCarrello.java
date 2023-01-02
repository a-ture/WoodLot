package it.unisa.WoodLot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe che modella un prodotto di un carrello
 *
 * @author Alessia Ture
 */
@Data
@Entity
@Table(name = "prodotto_carrello")
public class ProdottoCarrello implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "quantita", nullable = false)
    private int quantita;

    @ManyToOne()
    private Albero albero;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carrello")
    private Carrello carrello;
}
