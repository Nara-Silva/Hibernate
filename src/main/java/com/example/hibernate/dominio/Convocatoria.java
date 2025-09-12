package com.example.hibernate.dominio;

import javax.persistence.*;
import com.example.hibernate.dominio.Rango;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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

    // Relación bidireccional
    @OneToMany(mappedBy = "convocatoria")
    private List<Postulacion> postulaciones;


    @Column
    private Integer rangoDesde;


    
    @Column
    private Integer rangoHasta;

    @Enumerated(EnumType.STRING) //Opcional. Por default, lo persiste como int
    @Column (name="generoBuscado",nullable = false)
    private GeneroBuscado generoBuscado;

    @ManyToOne
    @JoinColumn(name = "id_creador", nullable = false)
    private Usuario creador;

    @ManyToOne
    @JoinColumn(name = "id_localizacion", nullable = false)
    private Localizacion localizacion;

    @Enumerated(EnumType.STRING) //Opcional. Por default, lo persiste como int
    @Column (name="tipo_de_REMUNERACION",nullable = false)
    private TipoRemuneracion tipoRemuneracion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_publicacion", nullable = false)
    private Date fechaPublicacion;

    @Column(name = "activa", nullable = false)
    private Boolean activa;

    @Column(name = "requisitos", length = 250, nullable = false)
    private String requisitos;

    @Column(name = "info_adicional", length = 250)
    private String infoAdicional;

    @Column(name = "tiempo_disponible", nullable = false)
    private Integer tiempoDisponible;

    // ===== Getters y Setters =====
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRangoDesde() {
        return rangoDesde;
    }

    public Integer getRangoHasta() {
        return rangoHasta;
    }

    public void setRangoDesde(Integer rango) {
        this.rangoDesde = rango;
    }

    public void setRangoHasta(Integer rango) {
        this.rangoHasta = rango;
    }

    public GeneroBuscado getGeneroBuscado() {
        return generoBuscado;
    }

    public void setGeneroBuscado(GeneroBuscado generoBuscado) {
        this.generoBuscado = generoBuscado;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }

    public TipoRemuneracion getTipoRemuneracion() {
        return tipoRemuneracion;
    }

    public void setTipoRemuneracion(TipoRemuneracion tipoRemuneracion) {
        this.tipoRemuneracion = tipoRemuneracion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }

    public Integer getTiempoDisponible() {
        return tiempoDisponible;
    }

    public void setTiempoDisponible(Integer tiempoDisponible) {
        this.tiempoDisponible = tiempoDisponible;
    }

}


