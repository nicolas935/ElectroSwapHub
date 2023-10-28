package com.example.softwareintercambiopuntos.modelo;

import jakarta.persistence.*;

@Entity
public class RelacionProductoImagenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "imagen_id")
    private ImagenProducto imagen;

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

    public ImagenProducto getImagen() {
        return imagen;
    }

    public void setImagen(ImagenProducto imagen) {
        this.imagen = imagen;
    }
}
