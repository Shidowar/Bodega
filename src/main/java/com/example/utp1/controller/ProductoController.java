package com.example.utp1.controller;

import com.example.utp1.model.Producto;
import com.example.utp1.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    //Obtener la lista de todos los estudiantes registrados
    @GetMapping
    public List<Producto> getAllProductos(){
        return productoService.getProductos();
    }
    //Obtener un estudiante por su id
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id){
        Producto producto = productoService.getProductoById(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        }
        return ResponseEntity.notFound().build();
    }
    //PostMapping
    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return productoService.createProducto(producto);
    }
    //PutMapping (Actualiza)
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto producto){
        Producto producto1 = productoService.updateProducto(id, producto);
        if (producto1 != null) {
            return ResponseEntity.ok(producto1);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id){
        Producto producto = productoService.getProductoById(id);
        if (producto != null) {
            productoService.deleteProducto(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
