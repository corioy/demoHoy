package com.example.demo.persistencia;

import com.example.demo.entidades.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UsuarioDAO {

    public void agregarUsuario(Usuario usuario) {
        EntityManager entityManager = ConexionJPA.getEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public Usuario obtenerUsuarioPorId(int id) {
        EntityManager entityManager = ConexionJPA.getEntityManager();
        Usuario usuario = null;
        try {
            usuario = entityManager.find(Usuario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return usuario;
    }

}
