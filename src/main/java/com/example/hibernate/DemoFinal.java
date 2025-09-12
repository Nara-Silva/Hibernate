package com.example.hibernate;

import com.example.hibernate.dominio.*;
import com.example.hibernate.utils.BDUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static com.example.hibernate.dominio.Rol.CONVOCADOR;

public class DemoFinal {

    public static void main(String[] args) {

        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);

        Agencia agencia = new Agencia();
        agencia.setNombre("Agencia Creativa");
        agencia.setFechaCreacion(LocalDate.now());
        em.persist(agencia);

        Persona persona = new Persona();
        persona.setNombre("Candela");
        persona.setApellido("Nieva");
        persona.setGenero(GeneroPersona.FEMENINO);
        persona.setEmail("candela@example.com");
        persona.setFechaDeNacimiento(new Date());
        em.persist(persona);

        Usuario creador = new Usuario();
        creador.setRol(CONVOCADOR);
        persona.setRol(Rol.POSTULANTE);
        em.persist(creador);

        //Localización
        Localizacion loc = new Localizacion();
        loc.setPais("Argentina");
        loc.setProvincia("Buenos Aires");
        loc.setMunicipio("La Matanza");
        em.persist(loc);

        ConvocatoriaPublicidad convPub = new ConvocatoriaPublicidad();
        convPub.setNombreProductoOservicio("Nuevo Shampoo");

        // valores a convocatoria:
        convPub.setGeneroBuscado(GeneroBuscado.FEMENINO);
        convPub.setTipoRemuneracion(TipoRemuneracion.PAGO_FIJO);
        convPub.setCreador(creador);
        convPub.setLocalizacion(loc);
        convPub.setFechaPublicacion(new Date());
        convPub.setActiva(true);
        convPub.setRequisitos("Experiencia en cámara");
        convPub.setTiempoDisponible(20);
        convPub.setRangoDesde(18);
        convPub.setRangoHasta(35);

        em.persist(convPub);

        // Update (entidad administrada -> detecta cambios)
        persona.setNombre("Candela Danett");
        System.out.println("ID Candela: " + persona.getId());

        // JPQL Query - Agencia por nombre
        List<Agencia> agencias = em
                .createQuery("select a from Agencia a where a.nombre = :nombre", Agencia.class)
                .setParameter("nombre", "Agencia Creativa")
                .getResultList();
        System.out.println("Agencias: " + agencias);

        // JPQL Query - ConvocatoriaPublicidad por producto/servicio
        List<ConvocatoriaPublicidad> convocatorias = em
                .createQuery("select c from ConvocatoriaPublicidad c where c.nombreProductoOservicio = :nombre", ConvocatoriaPublicidad.class)
                .setParameter("nombre", "Nuevo Shampoo")
                .getResultList();
        System.out.println("Convocatorias: " + convocatorias);

        // Delete de agencias con ese nombre
        List<Agencia> agenciasAEliminar = em
                .createQuery("select a from Agencia a where a.nombre = :nombre", Agencia.class)
                .setParameter("nombre", "Agencia Creativa")
                .getResultList();

        for (Agencia agenciaEliminar : agenciasAEliminar) {
            em.remove(agenciaEliminar);
        }

        BDUtils.commit(em);
        em.close();
    }
}
