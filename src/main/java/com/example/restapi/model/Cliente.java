package com.example.restapi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cliente extends Usuario {

    @OneToMany(mappedBy = "usuario")
    private List<Receta> recetas;

    @OneToMany(mappedBy = "usuario")
    private List<Libro> libros;

    @OneToMany
    private List<Reporte> reportes;

    @Column(nullable = false)
    private String direccion;

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String apellido, String nombreUsuario, String contrasena, String email, String direccion) {
        super(dni, nombre, apellido, nombreUsuario, contrasena, email);
        this.direccion = direccion;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Reporte> getReportes() {
        return reportes;
    }

    public void setReportes(List<Reporte> reportes) {
        this.reportes = reportes;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
