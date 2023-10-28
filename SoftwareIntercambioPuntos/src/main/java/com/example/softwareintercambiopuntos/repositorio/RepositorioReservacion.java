package com.example.softwareintercambiopuntos.repositorio;

import com.example.softwareintercambiopuntos.modelo.Reservacion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RepositorioReservacion {
    @Autowired
    private RepositorioReservacionCRUD repositorioReservacionCRUD;

    public List<Reservacion> getAllReservaciones() {
        return repositorioReservacionCRUD.findAll();
    }

    public Optional<Reservacion> findReservacionById(Long id) {
        return repositorioReservacionCRUD.findById(id);
    }

    public Reservacion saveReservacion(Reservacion reservacion) {
        return repositorioReservacionCRUD.save(reservacion);
    }

    public void deleteReservacionById(Long id) {
        repositorioReservacionCRUD.deleteById(id);
    }
}
