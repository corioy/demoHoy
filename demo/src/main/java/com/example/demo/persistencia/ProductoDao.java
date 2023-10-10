package com.example.demo.persistencia;

import com.example.demo.entidades.Producto;

import java.util.List;

public interface ProductoDao {

    Producto findByCodigo(Integer codigo);
    List<Producto> findAll();
    void save(Producto producto);
    void update(Producto producto);
    void delete(Producto producto);
    List<Producto> listarPortatiles();
}
