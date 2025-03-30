package com.example.restapi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente extends Usuario {

    private List<Receta> recetas;

    private List<Libro> libros;

    private List<Reporte> reportes;

    private String direccion;

    public Cliente() {
        super();
    }

    public Cliente(String dni, String nombre, String apellido, String email, String nombreUsuario, String contrasena) {
        super(dni, nombre, apellido, email, nombreUsuario, contrasena);
    }

    public Cliente(String dni, String nombre, String apellido, String email, String nombreUsuario, String contrasena, 
    List<Receta> recetas, List<Libro> libros, List<Reporte> reportes, String direccion) {
        super(dni, nombre, apellido, email, nombreUsuario, contrasena);
        this.recetas = recetas;
        this.reportes = reportes;
        this.libros = libros;
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
