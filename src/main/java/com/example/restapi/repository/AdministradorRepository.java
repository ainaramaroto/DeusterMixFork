package com.deustermix.repository;

import com.deustermix.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, String> {
    Optional<Administrador> findByNombreUsuario(String nombreUsuario);
    Optional<Administrador> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByNombreUsuario(String nombreUsuario);  
}