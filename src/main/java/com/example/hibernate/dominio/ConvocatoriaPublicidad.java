package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity
@Table(name="convocatoriaPublicidad")
public class ConvocatoriaPublicidad extends Convocatoria {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="productoOservicio")
    private String nombreProductoOservicio;

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProductoOservicio() {
        return nombreProductoOservicio;
    }

    public void setNombreProductoOservicio(String nombreProductoOservicio) {
        this.nombreProductoOservicio = nombreProductoOservicio;
    }
}