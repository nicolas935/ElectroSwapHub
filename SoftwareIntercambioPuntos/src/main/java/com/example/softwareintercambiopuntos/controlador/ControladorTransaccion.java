package com.example.softwareintercambiopuntos.controlador;

import com.example.softwareintercambiopuntos.modelo.Transaccion;
import com.example.softwareintercambiopuntos.servicio.ServicioTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacciones")
public class ControladorTransaccion {
    @Autowired
    private ServicioTransaccion servicioTransaccion;

    @GetMapping
    public List<Transaccion> getAllTransacciones() {
        return servicioTransaccion.getAllTransacciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaccion> getTransaccionById(@PathVariable Long id) {
        Optional<Transaccion> transaccion = servicioTransaccion.findTransaccionById(id);
        if (transaccion.isPresent()) {
            return ResponseEntity.ok(transaccion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Transaccion createTransaccion(@RequestBody Transaccion transaccion) {
        return servicioTransaccion.saveTransaccion(transaccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaccion> updateTransaccion(@PathVariable Long id, @RequestBody Transaccion transaccion) {
        if (servicioTransaccion.findTransaccionById(id).isPresent()) {
            transaccion.setId(id);
            return ResponseEntity.ok(servicioTransaccion.saveTransaccion(transaccion));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaccion(@PathVariable Long id) {
        if (servicioTransaccion.findTransaccionById(id).isPresent()) {
            servicioTransaccion.deleteTransaccionById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
