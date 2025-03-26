package com.example.restapi.service;

import com.example.restapi.model.Libro;
import com.example.restapi.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLibro {

    @Autowired
    private LibroRepository libroRepository;

    // Método para verificar si un libro existe por su título
    public boolean existePorTitulo(String titulo) {
        return libroRepository.existsByTitulo(titulo);
    }

    // Método para buscar libros por autor
    public List<Libro> buscarPorAutor(String autor) {
        return libroRepository.findByAutor(autor);
    }

    // Método para buscar libros por año de publicación
    public List<Libro> buscarPorAnioPublicacion(int anioPublicacion) {
        return libroRepository.findByAnioPublicacion(anioPublicacion);
    }

    // Método para buscar libros cuyo título contenga una palabra clave
    public List<Libro> buscarPorTituloConteniendo(String keyword) {
        return libroRepository.findByTituloContaining(keyword);
    }

    // Método para buscar libros por autor y año de publicación
    public List<Libro> buscarPorAutorYAnioPublicacion(String autor, int anioPublicacion) {
        return libroRepository.findByAutorAndAnioPublicacion(autor, anioPublicacion);
    }

    // Método para eliminar un libro por su título
    public void eliminarPorTitulo(String titulo) {
        libroRepository.deleteByTitulo(titulo);
    }

    // Método para guardar un libro en la base de datos
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // Método para obtener todos los libros
    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    // Método para buscar un libro por su ID
    public Libro buscarPorId(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    // Método para eliminar un libro por su ID
    public void eliminarPorId(Long id) {
        libroRepository.deleteById(id);
    }
}
