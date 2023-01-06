package it.unisa.WoodLot.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Classe che modella un paese d'origine
 *
 * @author Alessia Ture
 */
@Data
@Entity
@Table(name = "paese_origine")
public class PaeseOrigine implements Serializable {

    @Id
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descrizione", nullable = false, length = 5000)
    private String descrizione;
}
