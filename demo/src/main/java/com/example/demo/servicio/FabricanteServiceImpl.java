package com.example.demo.servicio;

import com.example.demo.entidades.Fabricante;
import com.example.demo.persistencia.FabricanteDao;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FabricanteServiceImpl implements FabricanteService{

    private final FabricanteDao fabricanteDao;
    @Override
    public String guardarFabricante(Fabricante fabricante) {
       fabricanteDao.save(fabricante);
       return "Fabricante guardado";
    }
}
