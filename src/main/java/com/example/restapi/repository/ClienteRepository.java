package com.example.restapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.model.Cliente;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    Optional<Cliente> findByNombreUsuario(String nombreUsuario);
    Optional<Cliente> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByNombreUsuario(String nombreUsuario);  
}
