package com.example.hibernate.dominio;
import javax.persistence.*;
import java.time.LocalDate;

@Entity @Table(name = "agencia")
public class Agencia extends Usuario {

    @Id @GeneratedValue
    private Long id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDate fechaCreacion;

    // Getters y setters
    /*
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
