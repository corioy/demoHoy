package com.example.demo.persistencia;

import com.example.demo.entidades.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
@Component
@RequiredArgsConstructor
public class ProductoDAOJPA  implements  ProductoDao{
    private final EntityManager entityManager;



    @Override
    public Producto findByCodigo(Integer codigo) {
        return entityManager.find(Producto.class, codigo);

    }

    @Override
    public List<Producto> findAll() {
        return entityManager.createQuery( "SELECT p FROM producto p", Producto.class).getResultList();
    }

    @Override
    public void save(Producto producto) {
        entityManager.persist(producto);

    }

    @Override
    public void update(Producto producto) {
        entityManager.merge(producto);

    }

    @Override
    public void delete(Producto producto) {
        entityManager.remove(producto );
    }

    @Override
    public List<Producto> listarPortatiles() {
        return entityManager.createQuery("SELECT p FROM producto WHERE nombre LIKE '%portatil%'", Producto.class)
                .getResultList();
    }


}
