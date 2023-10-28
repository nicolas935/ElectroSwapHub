package com.example.softwareintercambiopuntos.repositorio;

import com.example.softwareintercambiopuntos.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioUsuarioCRUD extends CrudRepository<Usuario, Long> {
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
    void deleteById(Long id);
}
