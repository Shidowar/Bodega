package com.example.utp1.service;

import com.example.utp1.model.Usuario;
import com.example.utp1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los clientes
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un cliente por su id
    public Usuario getUsuarioById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null); // Retorna null si no encuentra el cliente
    }

    // Crear un nuevo cliente
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Actualizar un cliente existente
    public Usuario updateUsuario(Long id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        return null; // Retorna null si el cliente no existe
    }

    // Eliminar un cliente por su id
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
