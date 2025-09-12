package com.example.hibernate.dominio;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="convocatoriaTaotralOCorto")
@PrimaryKeyJoinColumn(name = "id_convocatoria")
public class ConvocatoriaTeatralOCorto extends Convocatoria {

    /*@Id
    @GeneratedValue
    private Long id;*/

    @Enumerated(EnumType.STRING) //Opcional. Por default, lo persiste como int
    private GeneroObra generoObra;

    // Getters y setters

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public GeneroObra getGeneroObra() {
        return generoObra;
    }

    public void setGeneroObra(GeneroObra generoObra) {
        this.generoObra = generoObra;
    }
}