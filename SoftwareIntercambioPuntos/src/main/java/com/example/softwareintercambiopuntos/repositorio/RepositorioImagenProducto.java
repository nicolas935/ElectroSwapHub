package com.example.softwareintercambiopuntos.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.softwareintercambiopuntos.modelo.ImagenProducto;
import java.util.List;
import java.util.Optional;

public class RepositorioImagenProducto {
    @Autowired
    private RepositorioImagenProductoCRUD repositorioImagenProductoCRUD;

    public List<ImagenProducto> getAllImagenes() {
        return (List<ImagenProducto>) repositorioImagenProductoCRUD.findAll();
    }

    public Optional<ImagenProducto> findImagenById(Long id) {
        return repositorioImagenProductoCRUD.findById(id);
    }

    public ImagenProducto saveImagen(ImagenProducto imagen) {
        return repositorioImagenProductoCRUD.save(imagen);
    }

    public void deleteImagenById(Long id) {
        repositorioImagenProductoCRUD.deleteById(id);
    }
}
