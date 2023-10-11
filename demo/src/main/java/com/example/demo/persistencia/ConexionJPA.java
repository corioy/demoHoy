package com.example.demo.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionJPA {

    private static final String UNIDAD_DE_PERSISTENCIA = "MiUnidadDePersistencia";

    private static EntityManagerFactory entityManagerFactory;

    private ConexionJPA() {
    }

    private static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory =
                    Persistence.createEntityManagerFactory(UNIDAD_DE_PERSISTENCIA);
        }
        return entityManagerFactory;
    }
    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public static void cerrarEntityManagerFactory() {
        if (entityManagerFactory != null &&
                entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }



}
