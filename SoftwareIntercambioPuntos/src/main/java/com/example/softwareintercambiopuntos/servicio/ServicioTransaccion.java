package com.example.softwareintercambiopuntos.servicio;

import com.example.softwareintercambiopuntos.modelo.Transaccion;
import com.example.softwareintercambiopuntos.repositorio.RepositorioTransaccionCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioTransaccion {
    @Autowired
    private RepositorioTransaccionCRUD repositorioTransaccion;

    public List<Transaccion> getAllTransacciones() {
        return repositorioTransaccion.findAll();
    }

    public Optional<Transaccion> findTransaccionById(Long id) {
        return repositorioTransaccion.findById(id);
    }

    public Transaccion saveTransaccion(Transaccion transaccion) {
        return repositorioTransaccion.save(transaccion);
    }

    public void deleteTransaccionById(Long id) {
        repositorioTransaccion.deleteById(id);
    }
}
