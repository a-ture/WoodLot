package it.unisa.WoodLot.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataOrdine;

    @OneToMany
    private List<ProdottoOrdine> prodottiOrdine;

    @OneToOne
    @JoinColumn()
    private Utente utente;

    /**
     * Calcola il totale dell'ordine
     *
     * @return restituisce il totale dell'ordine
     */
    @Transient
    public double getTotaleOrdine() {
        double somma = 0;
        for (ProdottoOrdine prodottoOrdine : prodottiOrdine) {
            somma += prodottoOrdine.getPrezzoTotale();
        }
        return somma;
    }

}
