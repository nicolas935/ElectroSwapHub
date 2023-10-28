package com.example.softwareintercambiopuntos.controlador;

import com.example.softwareintercambiopuntos.modelo.ImagenProducto;
import com.example.softwareintercambiopuntos.servicio.ServicioImagenProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/imagenes")
public class ControladorImagenProducto {
    @Autowired
    private ServicioImagenProducto servicioImagenProducto;

    @GetMapping
    public List<ImagenProducto> getAllImagenes() {
        return servicioImagenProducto.getAllImagenes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImagenProducto> getImagenById(@PathVariable Long id) {
        Optional<ImagenProducto> imagen = servicioImagenProducto.findImagenById(id);
        if (imagen.isPresent()) {
            return ResponseEntity.ok(imagen.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ImagenProducto createImagen(@RequestBody ImagenProducto imagen) {
        return servicioImagenProducto.saveImagen(imagen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImagenProducto> updateImagen(@PathVariable Long id, @RequestBody ImagenProducto imagen) {
        if (servicioImagenProducto.findImagenById(id).isPresent()) {
            imagen.setId(id);
            return ResponseEntity.ok(servicioImagenProducto.saveImagen(imagen));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImagen(@PathVariable Long id) {
        if (servicioImagenProducto.findImagenById(id).isPresent()) {
            servicioImagenProducto.deleteImagenById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
