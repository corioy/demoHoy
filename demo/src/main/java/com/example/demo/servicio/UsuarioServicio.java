package com.example.demo.servicio;

import com.example.demo.entidades.Usuario;
import com.example.demo.persistencia.ConexionJPA;
import com.example.demo.persistencia.UsuarioDAO;


public class UsuarioServicio {

    private  UsuarioDAO usuarioDAO;


    public UsuarioServicio() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarioDAO.agregarUsuario(usuario);
    }
    public Usuario obtenerUsuarioPorId(int id){
      return usuarioDAO.obtenerUsuarioPorId(id);
    }

    public void cerrarRecursos() {
        ConexionJPA.cerrarEntityManagerFactory();
    }
}
