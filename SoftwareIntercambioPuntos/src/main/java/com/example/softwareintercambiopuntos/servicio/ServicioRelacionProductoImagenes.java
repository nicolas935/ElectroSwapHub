package com.example.softwareintercambiopuntos.servicio;

import com.example.softwareintercambiopuntos.repositorio.RepositorioRelacionProductoImagenesCRUD;
import com.example.softwareintercambiopuntos.modelo.RelacionProductoImagenes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioRelacionProductoImagenes {
    @Autowired
    private RepositorioRelacionProductoImagenesCRUD repositorioRelacionProductoImagenes;

    public List<RelacionProductoImagenes> getAllRelaciones() {
        return repositorioRelacionProductoImagenes.findAll();
    }

    public Optional<RelacionProductoImagenes> findRelacionById(Long id) {
        return repositorioRelacionProductoImagenes.findById(id);
    }

    public RelacionProductoImagenes saveRelacion(RelacionProductoImagenes relacion) {
        return repositorioRelacionProductoImagenes.save(relacion);
    }

    public void deleteRelacionById(Long id) {
        repositorioRelacionProductoImagenes.deleteById(id);
    }
}
