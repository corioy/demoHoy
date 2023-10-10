package com.example.demo.servicio;

import com.example.demo.entidades.Producto;
import com.example.demo.persistencia.ProductoDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService{

     private final ProductoDao productoDao;

    @Override
    public List<Producto> listarProductos() {
        return  productoDao.findAll();

    }

    @Override
    public List<String> listarPrecioYNombre() {
        List<Producto> lista = productoDao.findAll();
       return  lista.stream().map(producto -> producto.getNombre() + producto.getPrecio())
               .collect(Collectors.toList());
    }

    @Override
    public List<Producto> listaEntrePrecios() {
        List<Producto> lista = productoDao.findAll();
        return  lista.stream().filter(producto -> producto.getPrecio() >= 120
                && producto.getPrecio() <= 202).collect(Collectors.toList());
    }

    @Override
    public List<Producto> listarPortatiles() {
        return productoDao.listarPortatiles();
    }

    @Override
    public String productoMásBarato() {
        List<Producto> lista = productoDao.findAll();
        return lista.stream().min(Comparator.comparingDouble(Producto::getPrecio))
             .map(producto1 -> producto1.getNombre() + producto1.getPrecio()).orElseThrow();

    }

    @Override
    public String guardarProducto(Producto producto) {
         productoDao.save(producto);
         return  "Producto guardado";
    }

    @Override
    public String editarProducto( Producto producto) {
        productoDao.update(producto);
        return " Producto actualizado";
    }
}
