package com.example.softwareintercambiopuntos.servicio;

import com.example.softwareintercambiopuntos.repositorio.RepositorioImagenProductoCRUD;
import com.example.softwareintercambiopuntos.modelo.ImagenProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioImagenProducto {
    @Autowired
    private RepositorioImagenProductoCRUD repositorioImagenProducto;

    public List<ImagenProducto> getAllImagenes() {
        return repositorioImagenProducto.findAll();
    }

    public Optional<ImagenProducto> findImagenById(Long id) {
        return repositorioImagenProducto.findById(id);
    }

    public ImagenProducto saveImagen(ImagenProducto imagen) {
        return repositorioImagenProducto.save(imagen);
    }

    public void deleteImagenById(Long id) {
        repositorioImagenProducto.deleteById(id);
    }
}
