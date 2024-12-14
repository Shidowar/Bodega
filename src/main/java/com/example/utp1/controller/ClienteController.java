package com.example.utp1.controller;

import com.example.utp1.model.Cliente;
import com.example.utp1.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //Obtener la lista de todos los estudiantes registrados
    @GetMapping
    public List<Cliente> getAllClientes(){
        return clienteService.getClientes();
    }
    //Obtener un estudiante por su id
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
        Cliente cliente = clienteService.getClienteById(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }
    //PostMapping
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente){
        return clienteService.createCliente(cliente);
    }
    //PutMapping (Actualiza)
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        Cliente cliente1 = clienteService.updateCliente(id, cliente);
        if (cliente1 != null) {
            return ResponseEntity.ok(cliente1);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
        Cliente boleta = clienteService.getClienteById(id);
        if (boleta != null) {
            clienteService.deleteCliente(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
