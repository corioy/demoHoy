package com.example.demo.controller;

import com.example.demo.entidades.Producto;
import com.example.demo.servicio.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {
     private  final ProductoService productoService;


     @GetMapping
     List<Producto> listarProductos(){
       return   productoService.listarProductos();
     }

    @PostMapping("/save")
    String guardarProducto(@RequestBody Producto producto){
       return productoService.guardarProducto(producto);
    }


}
