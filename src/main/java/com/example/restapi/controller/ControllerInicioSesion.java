package com.example.restapi.controller;

import com.example.restapi.service.ServiceInicioSesion;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inicioSesion")
@Tag(name = "Inicio Sesion Controller", description = "API para el inicio de sesión y el cerrar sesión")
public class ControllerInicioSesion {

    @Autowired
    private ServiceInicioSesion serviceInicioSesion;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String contrasenia) {
        boolean respuesta = serviceInicioSesion.login(email, contrasenia);
        if (respuesta) {
            return ResponseEntity.ok("Inicio sesión con éxito");
        } else {
            return ResponseEntity.status(401).body("Datos incorrectos");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestParam String email) {
        serviceInicioSesion.logout(email);
        return ResponseEntity.ok("Sesión cerrada con éxito");
    }
}
