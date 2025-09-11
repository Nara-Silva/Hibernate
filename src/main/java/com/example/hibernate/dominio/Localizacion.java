package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity
@Table(name = "localizacion")
public class Localizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localizacion")
    private Integer id;

    @Column(name = "pais", length = 50, nullable = false)
    private String pais;

    @Column(name = "provincia", length = 50, nullable = false)
    private String provincia;

    @Column(name = "municipio", length = 50, nullable = false)
    private String municipio;

    // ===== Getters y Setters =====
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "Localizacion{" +
                "id=" + id +
                ", pais='" + pais + '\'' +
                ", provincia='" + provincia + '\'' +
                ", municipio='" + municipio + '\'' +
                '}';
    }
}
