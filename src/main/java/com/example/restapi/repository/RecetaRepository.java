package com.example.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.model.Receta;
import com.example.restapi.model.Usuario;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {
	List<Receta> findByUsuario_Email(String email);
    List<Receta> findByUsuario(Usuario usuario);
}
