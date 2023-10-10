package com.example.demo.persistencia;

import com.example.demo.entidades.Fabricante;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
@RequiredArgsConstructor
public class FabricanteDAOJPA implements FabricanteDao{

    private  final EntityManager entityManager;

    @Override
    public void save(Fabricante fabricante) {
        entityManager.persist(fabricante);
    }
}
