package com.example.softwareintercambiopuntos.repositorio;

import java.util.List;
import java.util.Optional;
import com.example.softwareintercambiopuntos.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioProducto {
    @Autowired
    private RepositorioProductoCRUD repositorioProductoCRUD;

    public List<Producto> getAllProductos() {
        return (List<Producto>) repositorioProductoCRUD.findAll();
    }

    public Optional<Producto> findProductoById(Long id) {
        return repositorioProductoCRUD.findById(id);
    }

    public Producto saveProducto(Producto producto) {
        return repositorioProductoCRUD.save(producto);
    }

    public void deleteProductoById(Long id) {
        repositorioProductoCRUD.deleteById(id);
    }
}
