package com.example.restapi.service;

import com.example.restapi.model.Cliente;
import com.example.restapi.model.Libro;
import com.example.restapi.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLibro {

    @Autowired
    private LibroRepository libroRepository;

    // Método para buscar libros por autor
    public List<Libro> buscarPorAutor(Cliente cliente) {
        return libroRepository.findByCliente(cliente);
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
