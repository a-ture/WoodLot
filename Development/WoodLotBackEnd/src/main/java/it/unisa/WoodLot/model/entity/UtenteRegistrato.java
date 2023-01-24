package it.unisa.WoodLot.model.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe che modella un generico utente registrato
 *
 * @author Alessia Ture
 */
@MappedSuperclass
public class UtenteRegistrato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    public UtenteRegistrato(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public UtenteRegistrato() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
