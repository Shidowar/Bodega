package com.example.utp1.service;

import com.example.utp1.model.Cliente;
import com.example.utp1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    // Obtener un cliente por su id
    public Cliente getClienteById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null); // Retorna null si no encuentra el cliente
    }

    // Crear un nuevo cliente
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente existente
    public Cliente updateCliente(Long id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        return null; // Retorna null si el cliente no existe
    }

    // Eliminar un cliente por su id
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
