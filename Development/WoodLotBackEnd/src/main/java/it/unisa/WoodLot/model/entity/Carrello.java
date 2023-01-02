package it.unisa.WoodLot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Classe che modella il carrello di un utente
 *
 * @author Alessia Ture
 */
@Data
@Entity
@Table(name = "carrello")
public class Carrello implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne()
    @JoinColumn()
    private Utente utente;

}
