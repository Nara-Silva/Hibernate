package com.example.hibernate.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "postulacion")
public class Postulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPostulacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    // Relacion muchos a uno con Convocatoria
    @ManyToOne
    @JoinColumn(name = "id_convocatoria", referencedColumnName = "id_convocatoria", nullable = false)
    private Convocatoria convocatoria;

    @Enumerated(EnumType.STRING) //Opcional. Por default, lo persiste como int
    private EstadoPostulacion estado;

    @ManyToOne
    @JoinColumn(name = "id_archivo_cv", referencedColumnName = "id", nullable = false)
    private Archivo archivoCV;

    @Column(length = 250, nullable = false)
    private String reel;

    @Column(name = "drive_fotos", length = 250, nullable = false)
    private String driveFotos;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    // Getters y Setters
    public Long getIdPostulacion() {
        return idPostulacion;
    }

    public void setIdPostulacion(Long idPostulacion) {
        this.idPostulacion = idPostulacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Convocatoria getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
    }

    public EstadoPostulacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoPostulacion estado) {
        this.estado = estado;
    }

    public Archivo getArchivoCV() {
        return archivoCV;
    }

    public void setArchivoCV(Archivo archivoCV) {
        this.archivoCV = archivoCV;
    }

    public String getReel() {
        return reel;
    }

    public void setReel(String reel) {
        this.reel = reel;
    }

    public String getDriveFotos() {
        return driveFotos;
    }

    public void setDriveFotos(String driveFotos) {
        this.driveFotos = driveFotos;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}

