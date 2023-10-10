package com.example.demo;

import java.util.ArrayList;

public class UserService {
    UsuarioDao usuarioDao = new UsuarioDao();
    public void mostrarUsuarios() {
        System.out.println("Se muestra la lista..");
        ArrayList<User> usuarios = usuarioDao.listarUsuarios();
        for (User usuario : usuarios) {
            System.out.println(usuario);
        }


    }    }
