package com.example.demo.entidades;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String correo;

    public  Usuario(String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
    }
}
