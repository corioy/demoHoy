package com.example.demo.servicio;

import com.example.demo.entidades.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> listarProductos();

    List<String> listarPrecioYNombre ();

    List<Producto> listaEntrePrecios();

    List<Producto> listarPortatiles();

    String productoMásBarato();

   String guardarProducto( Producto producto);

   String editarProducto(Producto producto);


}
