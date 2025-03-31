package com.example.restapi.repository;

import com.example.restapi.model.Cliente;
import com.example.restapi.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByCliente(Cliente cliente);
    List<Libro> findByTitulo(String titulo);
}
