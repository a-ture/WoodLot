package it.unisa.WoodLot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe che modella un responsabile ordini
 *
 * @author Alessia Ture
 */
@Data
@Entity
@Table(name = "responsabile_ordini")
public class ResponsabileOrdini extends UtenteRegistrato {

    @Column()
    private String nome;

    @Column()
    private String cognome;

    public ResponsabileOrdini(Long id, String email, String password) {
        super(id, email, password);
    }

    public ResponsabileOrdini() {
    }
}
