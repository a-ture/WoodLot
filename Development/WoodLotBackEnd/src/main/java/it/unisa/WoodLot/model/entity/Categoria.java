package it.unisa.WoodLot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Classe che modella una categoria
 *
 * @author Alessia Ture
 */
@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descrizione", nullable = false, length = 5000)
    private String descrizione;

}
