package com.example.restapi.repository;

import com.example.restapi.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    
    boolean existsByTitulo(String titulo);

    
    List<Libro> findByAutor(String autor);

    
    List<Libro> findByAnioPublicacion(int anioPublicacion);

    
    List<Libro> findByTituloContaining(String keyword);

    
    List<Libro> findByAutorAndAnioPublicacion(String autor, int anioPublicacion);


    void deleteByTitulo(String titulo);
}
