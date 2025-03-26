package com.example.restapi.service;

import com.example.restapi.model.Usuario;

import com.example.restapi.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class ServiceRegistro {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario) {
        // Validar si el usuario ya existe
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("El usuario con este correo ya existe.");
        }

        // Guardar el usuario en la base de datos
        return usuarioRepository.save(usuario);
    }
}
