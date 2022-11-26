package it.unisa.WoodLot.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data //Crea i getter and setter per ogni fild della classe
@Entity //Fa diventare la classe un entita del database
@Table(name = "orsetto")
public class Orso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String name;
}

