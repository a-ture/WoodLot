package it.unisa.WoodLot.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
        Senescenza,
        Revisione,
        Riassegnazione
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prezzo_unitario", nullable = false)
    private double prezzoUnitario;

    @OneToOne()
    @JoinColumn(name = "paese_origine", referencedColumnName = "nome")
    private PaeseOrigine paeseOrigine;

    @Column(name = "stato", nullable = false)
    private Stato stato;

    @Column(name = "data_assegnazione")
    private Date dataAssegnazione;

    @Column(name = "data_modifica")
    private Date dataModifica;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "contadino")
    private Contadino contadino;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "frutta")
    private Double frutta;

    @Column(name = "CO2", nullable = false)
    private int anidrideCarbonicaAssorbita;

    @Column(name = "nome_albero")
    private String nomeAlbero;

    @ManyToMany
    @JoinColumn(name = "uso_locale", referencedColumnName = "nome")
    private List<UsoLocale> usiLocali;

    @ManyToMany
    @JoinColumn(name = "beneficio", referencedColumnName = "nome")
    private List<Beneficio> benefici;

    public ProdottoOrdine() {
        frutta = (double) 0;
    }

    public double getFrutta() {
        if (frutta == null)
            return 0;
        else return frutta;
    }
}
