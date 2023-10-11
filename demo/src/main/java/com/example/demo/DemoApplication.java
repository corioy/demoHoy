package com.example.demo;

import com.example.demo.entidades.Usuario;
import com.example.demo.servicio.UsuarioServicio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Usuario nuevoUsuario = new Usuario( "John Doe",	"john.doe@example.com");

		UsuarioServicio usuarioServicio = new UsuarioServicio();
		usuarioServicio.agregarUsuario(nuevoUsuario);
		System.out.println("Usuario agregado: " + nuevoUsuario);

		int usuarioId = nuevoUsuario.getId();
		Usuario usuarioRecuperado =
				usuarioServicio.obtenerUsuarioPorId(usuarioId);
		System.out.println("Usuario recuperado: " + usuarioRecuperado);

		usuarioServicio.cerrarRecursos();
	}
}
