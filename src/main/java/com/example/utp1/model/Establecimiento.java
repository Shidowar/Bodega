package com.example.utp1.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "establecimiento")

public class Establecimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100, unique = true)
    private String codigo;

    @Column(nullable = false, unique = true,  length = 50)
    private int direccion;

    @Column(nullable = false, length = 50)
    private int telefono;

    @Column(nullable = false, length = 50)
    private int correo;

}
