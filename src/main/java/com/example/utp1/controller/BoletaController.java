package com.example.utp1.controller;

import com.example.utp1.model.Boleta;
import com.example.utp1.service.BoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boletas")
public class BoletaController {

    @Autowired
    private BoletaService boletaService;

    //Obtener la lista de todos los boleta registrados
    @GetMapping
    public List<Boleta> getAllBoletas(){
        return boletaService.getBoletas();
    }
    //Obtener un boleta por su id
    @GetMapping("/{id}")
    public ResponseEntity<Boleta> getBoletaById(@PathVariable Long id){
        Boleta boleta = boletaService.getBoletaById(id);
        if (boleta != null) {
            return ResponseEntity.ok(boleta);
        }
        return ResponseEntity.notFound().build();
    }
    //PostMapping
    @PostMapping
    public Boleta createBoleta(@RequestBody Boleta boleta){
        return boletaService.createBoleta(boleta);
    }
    //PutMapping (Actualiza)
    @PutMapping("/{id}")
    public ResponseEntity<Boleta> updateBoleta(@PathVariable Long id, @RequestBody Boleta boleta){
        Boleta boleta1 = boletaService.updateBoleta(id, boleta);
        if (boleta1 != null) {
            return ResponseEntity.ok(boleta1);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoleta(@PathVariable Long id){
        Boleta boleta = boletaService.getBoletaById(id);
        if (boleta != null) {
            boletaService.deleteBoleta(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
