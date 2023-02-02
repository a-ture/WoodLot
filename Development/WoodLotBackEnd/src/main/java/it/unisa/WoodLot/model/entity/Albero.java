package it.unisa.WoodLot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Classe che modella un albero
 *
 * @author Alessia Ture
 */
@Data
@Entity
@Table(name = "albero")
public class Albero implements Serializable {

    @Id
    @Column(name = "nome")
    private String nome;

    @Column(name = "specie_scientifica", nullable = false)
    private String specieScientifica;

    @Column(name = "descrizione_breve", nullable = false, columnDefinition = "TEXT")
    private String descrizioneBreve;

    @Column(name = "descrizione", nullable = false, columnDefinition = "TEXT")
    private String descrizione;

    @Column(name = "prezzo", nullable = false)
    private double prezzo;

    @Column(name = "CO2", nullable = false)
    private int anidrideCarbonicaAssorbita;

    @Column(name = "salvaguardia", nullable = false)
    private int salvaguardia;

    @OneToOne()
    @JoinColumn(name = "categoria", referencedColumnName = "nome")
    private Categoria categoria;

    @OneToOne()
    @JoinColumn(name = "paese_origine", referencedColumnName = "nome")
    private PaeseOrigine paeseOrigine;

    @ManyToMany
    @JoinColumn(name = "uso_locale", referencedColumnName = "nome")
    private List<UsoLocale> usiLocali;

    @ManyToMany
    @JoinColumn(name = "beneficio", referencedColumnName = "nome")
    private List<Beneficio> benefici;
}
