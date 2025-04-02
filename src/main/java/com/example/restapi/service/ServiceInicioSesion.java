package com.example.restapi.service;

import com.example.restapi.model.Usuario;
import com.example.restapi.repository.UsuarioRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceInicioSesion {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean login(String email, String contrasenia) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent() && usuario.get().getContrasena().equals(contrasenia)) {
            Usuario usuarioActual = usuario.get();
            usuarioActual.setSesionActiva(true);
            usuarioRepository.save(usuarioActual);
            return true;
        }
        return false;
    }

    public void logout(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            Usuario usuarioActual = usuario.get();
            usuarioActual.setSesionActiva(false);
            usuarioRepository.save(usuarioActual);
        }
    }

    public Usuario obtenerUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }
}
