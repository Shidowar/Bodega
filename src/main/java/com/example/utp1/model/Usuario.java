package com.example.utp1.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String nombre;

    @Column(nullable = false, unique = true,  length = 50)
    private int codigo;

    @Column(nullable = false, length = 100)
    private String correo;

    @Column(nullable = false, length = 50)
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "boleta_id")
    private Boleta boleta;
}
