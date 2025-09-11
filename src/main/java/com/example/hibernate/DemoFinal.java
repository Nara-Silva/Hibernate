package com.example.hibernate;

import com.example.hibernate.dominio.Alumno;
import com.example.hibernate.dominio.Calificacion;
import com.example.hibernate.dominio.Curso;
import com.example.hibernate.dominio.Examen;
import com.example.hibernate.dominio.Persona2;
import com.example.hibernate.dominio.Profesor;
import com.example.hibernate.utils.BDUtils;
import java.time.LocalDateTime;
import static java.util.Arrays.asList;
import java.util.List;
import javax.persistence.EntityManager;

public class DemoFinal {

    public static void main(String[] args) {

        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);

//        try {
            Alumno marcos = new Alumno();
            //Insert
            em.persist(marcos);
//        } catch (Exception e) {
//            BDUtils.rollback(em);
//            return;
//        }

        //Update
        marcos.setNombre("Marcos"); //Entidad administrada -> detecta cambios
        marcos.setPromedio(6.75);

        Curso dds = new Curso();
        dds.setHorario(LocalDateTime.now());
        em.persist(dds); //antes de asociar entidades deben estar persistidas

        marcos.setCursos(asList(dds));

        System.out.println("ID MARCOS: " + marcos.getId());

        Profesor julian = new Profesor();
        julian.setNombre("Julian");
        julian.setSalario(1000.55);

        em.persist(julian);

        //examen
        Examen examenDeMarcos = new Examen();
        examenDeMarcos.setAlumno(marcos);
        examenDeMarcos.setCalificacion(Calificacion.BIEN);
        examenDeMarcos.setNota(6);

        em.persist(examenDeMarcos);

        //JPQL Query
        List<Persona2> persona2s = em
                // equivalente a: select * from persona where persona.nombre = 'Julian'
                .createQuery("select p from Persona2 p where p.nombre = ?1", Persona2.class) //ojo, query no tipada
                .setParameter(1, "Julian")
                .getResultList();

        System.out.println(persona2s);

        //Delete
        for (Persona2 persona2 : persona2s) {
            em.remove(persona2);
        }

        BDUtils.commit(em);
    }

}
