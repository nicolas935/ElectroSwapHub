package com.example.softwareintercambiopuntos.controlador;

import com.example.softwareintercambiopuntos.modelo.Producto;
import com.example.softwareintercambiopuntos.servicio.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ControladorProducto {
    @Autowired
    private ServicioProducto servicioProducto;

    @GetMapping
    public List<Producto> getAllProductos() {
        return servicioProducto.getAllProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        Optional<Producto> producto = servicioProducto.findProductoById(id);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return servicioProducto.saveProducto(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        if (servicioProducto.findProductoById(id).isPresent()) {
            producto.setId(id);
            return ResponseEntity.ok(servicioProducto.saveProducto(producto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        if (servicioProducto.findProductoById(id).isPresent()) {
            servicioProducto.deleteProductoById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
