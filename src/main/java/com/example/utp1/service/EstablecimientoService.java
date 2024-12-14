package com.example.utp1.service;

import com.example.utp1.model.Establecimiento;
import com.example.utp1.repository.EstablecimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstablecimientoService {

    @Autowired
    private EstablecimientoRepository establecimientoRepository;

    // Obtener todos los clientes
    public List<Establecimiento> getEstablecimientos() {
        return establecimientoRepository.findAll();
    }

    // Obtener un cliente por su id
    public Establecimiento getEstablecimientoById(Long id) {
        Optional<Establecimiento> establecimiento = establecimientoRepository.findById(id);
        return establecimiento.orElse(null); // Retorna null si no encuentra el cliente
    }

    // Crear un nuevo cliente
    public Establecimiento createEstablecimiento(Establecimiento establecimiento) {
        return establecimientoRepository.save(establecimiento);
    }

    // Actualizar un cliente existente
    public Establecimiento updateEstablecimiento(Long id, Establecimiento establecimiento) {
        if (establecimientoRepository.existsById(id)) {
            establecimiento.setId(id);
            return establecimientoRepository.save(establecimiento);
        }
        return null; // Retorna null si el cliente no existe
    }

    // Eliminar un cliente por su id
    public void deleteEstablecimiento(Long id) {
        establecimientoRepository.deleteById(id);
    }
}
