package com.example.utp1.service;

import com.example.utp1.model.Boleta;
import com.example.utp1.repository.BoletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletaService {

    @Autowired
    private BoletaRepository boletaRepository;

    // Obtener todos los clientes
    public List<Boleta> getBoletas() {
        return boletaRepository.findAll();
    }

    // Obtener un cliente por su id
    public Boleta getBoletaById(Long id) {
        Optional<Boleta> boleta = boletaRepository.findById(id);
        return boleta.orElse(null); // Retorna null si no encuentra el cliente
    }

    // Crear un nuevo cliente
    public Boleta createBoleta(Boleta boleta) {
        return boletaRepository.save(boleta);
    }

    // Actualizar un cliente existente
    public Boleta updateBoleta(Long id, Boleta boleta) {
        if (boletaRepository.existsById(id)) {
            boleta.setId(id);
            return boletaRepository.save(boleta);
        }
        return null; // Retorna null si el cliente no existe
    }

    // Eliminar un cliente por su id
    public void deleteBoleta(Long id) {
        boletaRepository.deleteById(id);
    }
}
