package com.example.hibernate.dominio.ejemplo;

import javax.persistence.Entity;

@Entity
public class Profesor extends Persona2 {

    private Double salario;
    
    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

}
