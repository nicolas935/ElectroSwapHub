package com.example.softwareintercambiopuntos.repositorio;

import com.example.softwareintercambiopuntos.modelo.Reservacion;
import com.example.softwareintercambiopuntos.modelo.Transaccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioReservacionCRUD extends CrudRepository<Reservacion, Long> {
    List<Reservacion> findAll();
    Optional<Reservacion> findById(Long id);
    Reservacion save(Reservacion reservacion);
    void deleteById(Long id);
}
