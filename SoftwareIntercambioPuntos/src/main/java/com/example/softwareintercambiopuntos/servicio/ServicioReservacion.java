package com.example.softwareintercambiopuntos.servicio;

import com.example.softwareintercambiopuntos.modelo.Reservacion;
import com.example.softwareintercambiopuntos.repositorio.RepositorioReservacionCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class ServicioReservacion {
    @Autowired
    private RepositorioReservacionCRUD repositorioReservacion;

    public List<Reservacion> getAllReservaciones() {
        return repositorioReservacion.findAll();
    }

    public Optional<Reservacion> findReservacionById(Long id) {
        return repositorioReservacion.findById(id);
    }

    public Reservacion saveReservacion(Reservacion reservacion) {
        return repositorioReservacion.save(reservacion);
    }

    public void deleteReservacionById(Long id) {
        repositorioReservacion.deleteById(id);
    }
}
