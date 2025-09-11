package com.example.hibernate.dominio;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Persona {

    @Id
    private Long idUsuario;

    @OneToOne
    @MapsId
    private Usuario usuario;

    @Enumerated(EnumType.STRING) //Opcional. Por default, lo persiste como int
    private GeneroPersona genero;

    private String nombre;
    private String apellido;
    @Temporal(TemporalType.DATE)
    private Date fechadDeNacimiento;
    private String telefono;
    private String direccion;
    private String email;
    private Date fechaDeNacimiento;

    // Getters y setters
    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public GeneroPersona getGenero() {
        return genero;
    }
    public void setGenero(GeneroPersona genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" + "idUsuario=" + idUsuario + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + '}';
    }
}