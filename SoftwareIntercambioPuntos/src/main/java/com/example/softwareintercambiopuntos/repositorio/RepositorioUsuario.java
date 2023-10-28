package com.example.softwareintercambiopuntos.repositorio;

import com.example.softwareintercambiopuntos.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioUsuario {

    private RepositorioUsuarioCRUD repositorioUsuarioCRUD;

    public List<Usuario> getAllUsuarios() {
        return (List<Usuario>) repositorioUsuarioCRUD.findAll();
    }

    public Optional<Usuario> findUsuarioById(Long id) {
        return repositorioUsuarioCRUD.findById(id);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return repositorioUsuarioCRUD.save(usuario);
    }

    public void deleteUsuarioById(Long id) {
        repositorioUsuarioCRUD.deleteById(id);
    }
}
