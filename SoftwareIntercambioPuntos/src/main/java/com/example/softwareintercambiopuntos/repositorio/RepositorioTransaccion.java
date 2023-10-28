package com.example.softwareintercambiopuntos.repositorio;

import java.util.List;
import java.util.Optional;
import com.example.softwareintercambiopuntos.modelo.Transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTransaccion {
    @Autowired
    private RepositorioTransaccionCRUD repositorioTransaccionCRUD;

    public List<Transaccion> getAllTransacciones() {
        return repositorioTransaccionCRUD.findAll();
    }

    public Optional<Transaccion> findTransaccionById(Long id) {
        return repositorioTransaccionCRUD.findById(id);
    }

    public Transaccion saveTransaccion(Transaccion transaccion) {
        return repositorioTransaccionCRUD.save(transaccion);
    }

    public void deleteTransaccionById(Long id) {
        repositorioTransaccionCRUD.deleteById(id);
    }
}
