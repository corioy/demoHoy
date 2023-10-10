package com.example.demo.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    private Integer codigo;
    private String nombre;
    private Double precio;

    @ManyToOne
    private Fabricante codigoFabricante;


}
