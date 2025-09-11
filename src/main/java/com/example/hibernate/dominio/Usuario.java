package com.example.hibernate.dominio;
import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) //Opcional. Por default, lo persiste como int
    private Rol rol;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Persona persona;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Agencia agencia;

    // Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
        if (persona != null) {
            persona.setUsuario(this);
        }
    }

    public Agencia getAgencia() {
        return agencia;
    }
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
        if (agencia != null) {
            agencia.setUsuario(this);
        }
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", rol=" + rol + '}';
    }
}