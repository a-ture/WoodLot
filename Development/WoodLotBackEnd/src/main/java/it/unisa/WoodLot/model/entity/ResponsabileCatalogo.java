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
public class ResponsabileCatalogo extends UtenteRegistrato {
    @Column()
    private String nome;

    @Column()
    private String cognome;

    public ResponsabileCatalogo(Long id, String email, String password) {
        super(id, email, password);
    }

    public ResponsabileCatalogo() {
    }
}
