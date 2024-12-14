package com.example.utp1.controller;

import com.example.utp1.model.Establecimiento;
import com.example.utp1.service.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/establecimientos")
public class EstablecimientoController {

    @Autowired
    private EstablecimientoService establecimientoService;

    //Obtener la lista de todos los estudiantes registrados
    @GetMapping
    public List<Establecimiento> getAllEstablecimientos(){
        return establecimientoService.getEstablecimientos();
    }
    //Obtener un estudiante por su id
    @GetMapping("/{id}")
    public ResponseEntity<Establecimiento> getEstablecimientoById(@PathVariable Long id){
        Establecimiento establecimiento = establecimientoService.getEstablecimientoById(id);
        if (establecimiento != null) {
            return ResponseEntity.ok(establecimiento);
        }
        return ResponseEntity.notFound().build();
    }
    //PostMapping
    @PostMapping
    public Establecimiento createEstablecimiento(@RequestBody Establecimiento establecimiento){
        return establecimientoService.createEstablecimiento(establecimiento);
    }
    //PutMapping (Actualiza)
    @PutMapping("/{id}")
    public ResponseEntity<Establecimiento> updateEstablecimiento(@PathVariable Long id, @RequestBody Establecimiento establecimiento){
        Establecimiento establecimiento1 = establecimientoService.updateEstablecimiento(id, establecimiento);
        if (establecimiento1 != null) {
            return ResponseEntity.ok(establecimiento1);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstablecimiento(@PathVariable Long id){
        Establecimiento establecimiento = establecimientoService.getEstablecimientoById(id);
        if (establecimiento != null) {
            establecimientoService.deleteEstablecimiento(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
