package com.example.softwareintercambiopuntos.repositorio;

import com.example.softwareintercambiopuntos.modelo.RelacionProductoImagenes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioRelacionProductoImagenesCRUD extends CrudRepository<RelacionProductoImagenes, Long> {
    List<RelacionProductoImagenes> findAll();
    Optional<RelacionProductoImagenes> findById(Long id);
    RelacionProductoImagenes save(RelacionProductoImagenes relacionProductoImagenes);
    void deleteById(Long id);
}
