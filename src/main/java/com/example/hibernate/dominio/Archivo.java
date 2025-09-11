package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity
@Table(name = "archivo")
public class Archivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Double tamanio;

    private String formato;

    private String ruta;

    //@ManyToOne
    //@JoinColumn(name = "id_postulacion") // FK a Postulacion
    //private Postulacion postulacion;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTamanio() {
        return tamanio;
    }

    public void setTamanio(Double tamanio) {
        this.tamanio = tamanio;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /*public Postulacion getPostulacion() {
        return postulacion;
    }

    //public void setPostulacion(Postulacion postulacion) {
        this.postulacion = postulacion;
    }*/

    @Override
    public String toString() {
        return "Archivo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tamanio=" + tamanio +
                ", formato='" + formato + '\'' +
                ", ruta='" + ruta + '\'' +
                '}';
    }

}
