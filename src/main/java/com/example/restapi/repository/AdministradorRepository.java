package com.example.restapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.model.Administrador;

import java.util.Optional;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, String> {
    Optional<Administrador> findByNombreUsuario(String nombreUsuario);
    Optional<Administrador> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByNombreUsuario(String nombreUsuario);  
}