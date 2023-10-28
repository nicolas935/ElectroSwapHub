package com.example.softwareintercambiopuntos.servicio;

import com.example.softwareintercambiopuntos.repositorio.RepositorioUsuarioCRUD;
import com.example.softwareintercambiopuntos.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuario {
    @Autowired
    private static RepositorioUsuarioCRUD repositorioUsuario;

    public static List<Usuario> getAllUsuarios() {
        return repositorioUsuario.findAll();
    }

    public static Optional<Usuario> findUsuarioById(Long id) {
        return repositorioUsuario.findById(id);
    }

    public static Usuario saveUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public static void deleteUsuarioById(Long id) {
        repositorioUsuario.deleteById(id);
    }
}
