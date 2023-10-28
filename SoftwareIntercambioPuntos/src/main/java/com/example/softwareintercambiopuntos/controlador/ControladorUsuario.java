package com.example.softwareintercambiopuntos.controlador;

import com.example.softwareintercambiopuntos.modelo.Usuario;
import com.example.softwareintercambiopuntos.servicio.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {
    @Autowired
    private ServicioUsuario servicioUsuario;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return ServicioUsuario.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuario = ServicioUsuario.findUsuarioById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return ServicioUsuario.saveUsuario(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (ServicioUsuario.findUsuarioById(id).isPresent()) {
            usuario.setId(id);
            return ResponseEntity.ok(ServicioUsuario.saveUsuario(usuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        if (ServicioUsuario.findUsuarioById(id).isPresent()) {
            ServicioUsuario.deleteUsuarioById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
