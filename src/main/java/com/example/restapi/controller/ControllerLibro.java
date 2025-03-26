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

    // Endpoint para buscar libros por autor
    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<Libro>> buscarPorAutor(@PathVariable String autor) {
        List<Libro> libros = serviceLibro.buscarPorAutor(autor);
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    // Endpoint para buscar libros por año de publicación
    @GetMapping("/anio/{anioPublicacion}")
    public ResponseEntity<List<Libro>> buscarPorAnioPublicacion(@PathVariable int anioPublicacion) {
        List<Libro> libros = serviceLibro.buscarPorAnioPublicacion(anioPublicacion);
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    // Endpoint para buscar libros cuyo título contenga una palabra clave
    @GetMapping("/buscar")
    public ResponseEntity<List<Libro>> buscarPorTituloConteniendo(@RequestParam String keyword) {
        List<Libro> libros = serviceLibro.buscarPorTituloConteniendo(keyword);
        return new ResponseEntity<>(libros, HttpStatus.OK);
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

    // Endpoint para eliminar un libro por título
    @DeleteMapping("/titulo")
    public ResponseEntity<Void> eliminarPorTitulo(@RequestParam String titulo) {
        serviceLibro.eliminarPorTitulo(titulo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
