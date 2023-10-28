package com.example.softwareintercambiopuntos.servicio;

import com.example.softwareintercambiopuntos.repositorio.RepositorioProductoCRUD;
import com.example.softwareintercambiopuntos.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioProducto {
    @Autowired
    private RepositorioProductoCRUD repositorioProductoCRUD;

    public List<Producto> getAllProductos() {
        return repositorioProductoCRUD.findAll();
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
