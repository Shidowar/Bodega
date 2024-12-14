package com.example.utp1.controller;

import com.example.utp1.model.Usuario;
import com.example.utp1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //Obtener la lista de todos los estudiantes registrados
    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getUsuarios();
    }
    //Obtener un estudiante por su id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id){
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }
    //PostMapping
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioService.createUsuario(usuario);
    }
    //PutMapping (Actualiza)
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuario1 = usuarioService.updateUsuario(id, usuario);
        if (usuario1 != null) {
            return ResponseEntity.ok(usuario1);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario != null) {
            usuarioService.deleteUsuario(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
