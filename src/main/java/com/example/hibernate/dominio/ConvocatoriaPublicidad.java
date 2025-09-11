package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity
@Table(name="convocatoriaPublicidad")
public class ConvocatoriaPublicidad extends Convocatoria {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="nombre")
    private String nombre;
}