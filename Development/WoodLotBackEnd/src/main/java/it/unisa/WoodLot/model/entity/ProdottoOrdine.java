package it.unisa.WoodLot.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe che modella un prodotto di un ordine
 *
 * @author Alessia Ture
 */
@Data
@Entity
@Table(name = "prodotto_ordine")
public class ProdottoOrdine implements Serializable {
    public enum Stato {
        Assegnato,
        NonAssegnato,
        Piantato,
        Bocciolo,
        Fiore,
        Frutto,
        Dormienza,
        Senescenza
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "prezzo_unitario", nullable = false)
    private double prezzoUnitario;

    @Column(name = "stato", nullable = false)
    private Stato stato;

    @Column(name = "data_assegnazione")
    private Date dataAssegnazione;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "albero")
    private Albero albero;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "contadino")
    private Contadino contadino;

    private String descrizione;

    private double frutta;

}
