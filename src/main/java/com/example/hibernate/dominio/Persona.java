package com.example.hibernate.dominio;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Persona extends Usuario {

    @Id @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING) //Opcional. Por default, lo persiste como int
    private GeneroPersona genero;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Temporal(TemporalType.DATE)
    private Date fechadDeNacimiento;
    @Column
    private String telefono;
    @Column
    private String direccion;
    @Column
    private String email;
    @Column
    private Date fechaDeNacimiento;

    // Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;



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