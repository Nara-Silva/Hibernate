package com.example.hibernate.dominio;
import javax.persistence.*;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Persona extends Usuario {

    @Enumerated(EnumType.STRING) //Opcional. Por default, lo persiste como int
    private GeneroPersona genero;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaDeNacimiento")
    private Date fechaDeNacimiento;

    @Column
    private String telefono;

    @Column
    private String direccion;

    @Column
    private String email;

    // Getters y setters
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
        return "Persona{idUsuario=" + getId() + ", nombre='" + nombre + "', apellido='" + apellido + "'}";
    } //idUsuario  decia esto pero me lo marca como error, es id?? dejé ese y lo toma lo vemos dsp si no
}