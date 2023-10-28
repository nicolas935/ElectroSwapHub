package com.example.softwareintercambiopuntos.controlador;

import com.example.softwareintercambiopuntos.modelo.Reservacion;
import com.example.softwareintercambiopuntos.servicio.ServicioReservacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservaciones")
public class ControladorReservacion {
    @Autowired
    private ServicioReservacion servicioReservacion;

    @GetMapping
    public List<Reservacion> getAllReservaciones() {
        return servicioReservacion.getAllReservaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservacion> getReservacionById(@PathVariable Long id) {
        Optional<Reservacion> reservacion = servicioReservacion.findReservacionById(id);
        if (reservacion.isPresent()) {
            return ResponseEntity.ok(reservacion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Reservacion createReservacion(@RequestBody Reservacion reservacion) {
        return servicioReservacion.saveReservacion(reservacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateReservacion(@PathVariable Long id, @RequestBody Reservacion reservacion) {
        if (servicioReservacion.findReservacionById(id).isPresent()) {
            reservacion.setId(id);
            return ResponseEntity.ok(servicioReservacion.saveReservacion(reservacion));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservacion(@PathVariable Long id) {
        if (servicioReservacion.findReservacionById(id).isPresent()) {
            servicioReservacion.deleteReservacionById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
