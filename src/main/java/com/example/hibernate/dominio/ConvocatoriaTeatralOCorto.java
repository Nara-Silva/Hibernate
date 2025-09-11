package com.example.hibernate.dominio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="convocatoriaPublicidad")
public class ConvocatoriaTeatralOCorto extends Convocatoria {

    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING) //Opcional. Por default, lo persiste como int
    private GeneroObra generoObra;

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GeneroObra getGeneroObra() {
        return generoObra;
    }

    public void setGeneroObra(GeneroObra generoObra) {
        this.generoObra = generoObra;
    }
}