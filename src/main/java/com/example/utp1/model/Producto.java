package com.example.utp1.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,  unique = true, length = 10)
    private String nombre;

    @Column(nullable = false, length = 50)
    private int precio;

    @Column(nullable = false, length = 100)
    private String marca;

    @Column(nullable = false, length = 50)
    private String categoria;

    @Column(nullable = false, length = 50)
    private String descripcion;

    @Column(nullable = false, length = 50)
    private int unidades;

    @Column(nullable = false, length = 50)
    private String fechaProduccion;

    @Column(nullable = false, length = 50)
    private String fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "boleta_id")
    private Boleta boleta;
}
