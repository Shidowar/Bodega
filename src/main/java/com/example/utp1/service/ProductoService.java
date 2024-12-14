package com.example.utp1.service;

import com.example.utp1.model.Producto;
import com.example.utp1.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los clientes
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    // Obtener un cliente por su id
    public Producto getProductoById(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.orElse(null); // Retorna null si no encuentra el cliente
    }

    // Crear un nuevo cliente
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Actualizar un cliente existente
    public Producto updateProducto(Long id, Producto producto) {
        if (productoRepository.existsById(id)) {
            producto.setId(id);
            return productoRepository.save(producto);
        }
        return null; // Retorna null si el cliente no existe
    }

    // Eliminar un cliente por su id
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
