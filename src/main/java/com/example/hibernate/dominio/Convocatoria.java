package com.example.hibernate.dominio;

import javax.persistence.*;
import com.example.hibernate.dominio.Rango;
import java.time.LocalDateTime;

@Entity
@Table(name = "convocatoria")
@Inheritance (strategy = InheritanceType.JOINED) // porque después heredan las otras
public /*abstract*/ class Convocatoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_convocatoria")
    private Integer id;

    /*@ManyToOne
    @JoinColumn(name = "id_rango", nullable = false)
    private Rango rangoEdad;
    */

    private Integer rangoDesde;
    private Integer rangoHasta;

    @Enumerated(EnumType.STRING) //Opcional. Por default, lo persiste como int
    @Column (name="generoBuscado",nullable = false)
    private GeneroBuscado generoBuscado;


    private LocalDateTime fechaPublicacion;


    @OneToOne
    private Usuario creador;
    private String requisitos;
    @OneToOne
    private Localizacion localización;
    private String infoAdicional;
    @Enumerated(EnumType.STRING)
    private TipoRemuneracion tipoRemuneracion;



    }


