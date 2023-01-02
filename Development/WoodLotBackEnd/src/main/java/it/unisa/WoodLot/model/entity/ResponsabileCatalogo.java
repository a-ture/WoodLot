package it.unisa.WoodLot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Classe che modella un responsabile del catalogo
 *
 * @author Alessia Ture
 */
@Data
@Entity
@Table(name = "responsabile_catalogo")
public class ResponsabileCatalogo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;
}
