package it.unisa.WoodLot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe che modella un contadino
 *
 * @author Alessia Ture
 */
@Data
@Entity
@Table(name = "contadino")
public class Contadino extends UtenteRegistrato {

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "data_di_nascita", nullable = false)
    private Date dataDiNascita;

    @Column(name = "coordinate_geografiche", nullable = false)
    private String coordinateGeografiche;

    @Column(name = "swift")
    private String swift;

    @Column(name = "titolare_conto")
    private String titolareConto;

    public Contadino(){}
    public Contadino(Long id, String email, String password) {
        super(id, email, password);
    }
}
