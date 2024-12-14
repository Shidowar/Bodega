package com.example.utp1.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "boleta")
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombreCliente;

    @Column(nullable = false,  unique = true)
    private int codigo;

    @Column(nullable = false)
    private int nombreProducto;

    @Column(nullable = false)
    private int precioProducto;

    @Column(nullable = false)
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Boleta boleta;
}
