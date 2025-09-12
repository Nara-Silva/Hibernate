package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity
@Table(name="convocatoriaPublicidad")
@PrimaryKeyJoinColumn(name = "id_convocatoria") //hace que la subclase comparta el mismo id que la superclase
public class ConvocatoriaPublicidad extends Convocatoria {

/* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @Column(name="productoOservicio")
    private String nombreProductoOservicio;

    // Getters y setters
    /*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public String getNombreProductoOservicio() {
        return nombreProductoOservicio;
    }

    public void setNombreProductoOservicio(String nombreProductoOservicio) {
        this.nombreProductoOservicio = nombreProductoOservicio;
    }
}