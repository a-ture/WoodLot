package it.unisa.WoodLot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe che modella un pagamento a un contadino
 *
 * @author Alessia Ture
 */
@Data
@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "importo")
    private double importo;

    @Column(name = "data_pagamento")
    private Date dataPagamento;

    @Column(name = "motivazioni")
    private String motivazioni;

    @OneToOne
    @JoinColumn()
    private Contadino contadino;
}
