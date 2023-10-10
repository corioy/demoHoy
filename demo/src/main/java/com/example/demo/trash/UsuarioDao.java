package com.example.demo.trash;

import com.example.demo.trash.ConexionDAO;

import java.util.ArrayList;

public class UsuarioDao  extends ConexionDAO {
    public ArrayList<User> listarUsuarios() {
        ArrayList<User> usuarios = new ArrayList();
        try {
            String query = "SELECT id, nombre, clave, mail, edad FROM public.user_";
            consultarBd(query);
            User usuario = null;
            while (resultado.next()) {
                usuario = new User();
                usuario.setId(resultado.getInt(1));
                usuario.setNombre(resultado.getString(2));
                usuario.setClave(resultado.getString(3));
                usuario.setMail(resultado.getString(4));
                usuario.setEdad(resultado.getInt(5));
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            desconectarBd();
        }
        return usuarios;
    }
}
