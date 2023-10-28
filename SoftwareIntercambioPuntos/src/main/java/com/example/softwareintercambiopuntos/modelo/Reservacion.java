package com.example.softwareintercambiopuntos.modelo;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class Reservacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private Timestamp fechaReservacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Timestamp getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(Timestamp fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }
}
