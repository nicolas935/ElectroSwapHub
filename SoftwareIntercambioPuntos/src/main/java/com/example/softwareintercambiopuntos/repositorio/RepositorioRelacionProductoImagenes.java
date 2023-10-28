package com.example.softwareintercambiopuntos.repositorio;

import com.example.softwareintercambiopuntos.modelo.RelacionProductoImagenes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioRelacionProductoImagenes {
    @Autowired
    private RepositorioRelacionProductoImagenesCRUD repositorioRelacionProductoImagenesCRUD;

    public List<RelacionProductoImagenes> getAllRelaciones() {
        return repositorioRelacionProductoImagenesCRUD.findAll();
    }

    public Optional<RelacionProductoImagenes> findRelacionById(Long id) {
        return repositorioRelacionProductoImagenesCRUD.findById(id);
    }

    public RelacionProductoImagenes saveRelacion(RelacionProductoImagenes relacion) {
        return repositorioRelacionProductoImagenesCRUD.save(relacion);
    }

    public void deleteRelacionById(Long id) {
        repositorioRelacionProductoImagenesCRUD.deleteById(id);
    }
}
