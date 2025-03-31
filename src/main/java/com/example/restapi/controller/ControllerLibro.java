package com.example.restapi.controller;

import com.example.restapi.model.Libro;
import com.example.restapi.service.ServiceLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class ControllerLibro {

    @Autowired
    private ServiceLibro serviceLibro;

    // Endpoint para obtener todos los libros
    @GetMapping
    public ResponseEntity<List<Libro>> obtenerTodosLosLibros() {
        List<Libro> libros = serviceLibro.obtenerTodosLosLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    // Endpoint para buscar un libro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarPorId(@PathVariable Long id) {
        Libro libro = serviceLibro.buscarPorId(id);
        if (libro != null) {
            return new ResponseEntity<>(libro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para guardar un libro
    @PostMapping
    public ResponseEntity<Libro> guardarLibro(@RequestBody Libro libro) {
        Libro libroGuardado = serviceLibro.guardarLibro(libro);
        return new ResponseEntity<>(libroGuardado, HttpStatus.CREATED);
    }

    // Endpoint para eliminar un libro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        serviceLibro.eliminarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
