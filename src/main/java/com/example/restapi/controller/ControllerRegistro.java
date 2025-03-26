package com.example.restapi.controller;

import com.example.restapi.model.Usuario;

import com.example.restapi.service.ServiceRegistro;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/registro")
public class ControllerRegistro {

    @Autowired
    private ServiceRegistro serviceRegistro;

    @PostMapping
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioRegistrado = serviceRegistro.registrarUsuario(usuario);
            return new ResponseEntity<>(usuarioRegistrado, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
