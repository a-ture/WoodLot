package it.unisa.WoodLot.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che modella un ordine
 *
 * @author Alessia Ture
 */
@Data
@Entity
@Table(name = "ordine")
public class Ordine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "dataOrdine", nullable = false)
    private LocalDate dataOrdine;

    @OneToMany
    private List<ProdottoOrdine> prodottiOrdine;
    private double totale;

    @OneToOne
    @JoinColumn()
    private Utente utente;

    public Ordine() {
        this.totale = 0;
        prodottiOrdine = new ArrayList<>();
    }

    /**
     * Calcola il totale dell'ordine
     *
     * @return restituisce il totale dell'ordine
     */
    @Transient
    public double setTotale() {
        double somma = 0;
        for (ProdottoOrdine prodottoOrdine : prodottiOrdine) {
            somma += prodottoOrdine.getPrezzoUnitario();
        }
        return somma;
    }

    public void aggiungiProdotto(ProdottoOrdine prodottoOrdine) {
        prodottiOrdine.add(prodottoOrdine);
        totale += prodottoOrdine.getPrezzoUnitario();
    }
}
