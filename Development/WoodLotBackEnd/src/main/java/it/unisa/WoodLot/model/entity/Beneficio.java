package it.unisa.WoodLot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe che modella un beneficio
 *
 * @author Alessia Ture
 */
@Data
@Entity
@Table(name = "beneficio")
public class Beneficio implements Serializable {

    @Id
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descrizione", nullable = false, length = 5000)
    private String descrizione;

}
