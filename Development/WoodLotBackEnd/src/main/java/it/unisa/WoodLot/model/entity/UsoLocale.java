package it.unisa.WoodLot.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe che modella un uso locale
 *
 * @author Alessia Ture
 */
@Data
@Entity
@Table(name = "uso_locale")
public class UsoLocale {

    @Id
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descrizione", nullable = false)
    private String descrizione;
}
