package com.example.hibernate.dominio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="convocatoriaPublicidad")
public class ConvocatoriaTeatralOCorto extends Convocatoria {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="nombre")
    private String nombre;
}