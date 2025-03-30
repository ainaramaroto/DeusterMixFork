package com.example.restapi.repository;

import com.example.restapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	Optional<Usuario> findBynombreUsuario(String nombreUsuario);
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
}