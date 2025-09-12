package com.example.hibernate;

import com.example.hibernate.dominio.Agencia;
import com.example.hibernate.dominio.ConvocatoriaPublicidad;
import com.example.hibernate.dominio.GeneroPersona;
import com.example.hibernate.dominio.Persona;
import com.example.hibernate.dominio.ejemplo.Alumno;
import com.example.hibernate.dominio.ejemplo.Calificacion;
import com.example.hibernate.dominio.ejemplo.Curso;
import com.example.hibernate.dominio.ejemplo.Examen;
import com.example.hibernate.dominio.ejemplo.Persona2;
import com.example.hibernate.dominio.ejemplo.Profesor;
import com.example.hibernate.utils.BDUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.util.Arrays.asList;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

public class DemoFinal {

    public static void main(String[] args) {

        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);

        Agencia agencia = new Agencia();
        agencia.setNombre("Agencia Creativa");
        agencia.setFechaCreacion(LocalDate.now());
        em.persist(agencia);

        // Crear y persistir Persona
        Persona persona = new Persona();
        persona.setNombre("Candela");
        persona.setApellido("Nieva");
        persona.setGenero(GeneroPersona.FEMENINO);
        persona.setEmail("candela@example.com");
        persona.setFechaDeNacimiento(new Date());
        em.persist(persona);

        ConvocatoriaPublicidad convocatoriaPub = new ConvocatoriaPublicidad();
        convocatoriaPub.setNombreProductoOservicio("Nuevo Shampoo");
        em.persist(convocatoriaPub);

        //Update
        persona.setNombre("Candela Danett"); //Entidad administrada  -> detecta cambios
        System.out.println("ID Candela: " + persona.getId());


        //JPQL Query
        // Consulta JPQL para Agencia por nombre
        List<Agencia> agencias = em
                .createQuery("select a from Agencia a where a.nombre = :nombre", Agencia.class)
                .setParameter("nombre", "Agencia Creativa")
                .getResultList();
        System.out.println("Agencias: " + agencias);

        List<ConvocatoriaPublicidad> convocatorias = em
                .createQuery("select c from ConvocatoriaPublicidad c where c.nombreProductoOservicio = :nombre", ConvocatoriaPublicidad.class)
                .setParameter("nombre", "Nuevo Shampoo")
                .getResultList();
        System.out.println("Convocatorias: " + convocatorias);

        List<Agencia> agenciasAEliminar = em
                .createQuery("select a from Agencia a where a.nombre = :nombre", Agencia.class)
                .setParameter("nombre", "Agencia Creativa")
                .getResultList();

        //Delete
        for (Agencia agenciaeliminar : agenciasAEliminar) {
            em.remove(agenciaeliminar);
        }

        BDUtils.commit(em);
        em.close();
    }

}
