package it.unisa.WoodLot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe che modella un utente
 *
 * @author Alessia Ture
 */
@Data
@Entity
@Table(name = "utente")
public class Utente extends UtenteRegistrato {
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "data_di_nascita", nullable = false)
    private Date dataDiNascita;

    public Utente() {

    }

    public Utente(Long id, String email, String password, String nome, String cognome, Date dataDiNascita) {
        super(id, email, password);
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

}
