package com.example.restapi.service;

import com.example.restapi.model.Usuario;
import com.example.restapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceInicioSesion {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean login(String email, String contrasenia) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && usuario.getContrasena().equals(contrasenia)) {
            return true;
        }
        return false;
    }

    public void logout(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null) {
            usuario.setSesionActiva(false);
            usuarioRepository.save(usuario);
        }
    }

    public Usuario obtenerUsuarioPorEmail(String email) {
        if (!usuarioRepository.findByEmail(email).isPresent()) {
            return null;
        } else {
            return usuarioRepository.findByEmail(email).get();
        }
    }
}
