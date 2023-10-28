package com.example.softwareintercambiopuntos.repositorio;

import com.example.softwareintercambiopuntos.modelo.Transaccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioTransaccionCRUD extends CrudRepository<Transaccion, Long> {
    List<Transaccion> findAll();
    Optional<Transaccion> findById(Long id);
    Transaccion save(Transaccion transaccion);
    void deleteById(Long id);
}
