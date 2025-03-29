package com.example.restapi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Administrador extends Usuario {

    @OneToMany
    private List<Reporte> reportesRevisados;

    // Constructor
    public Administrador(String dni, String nombre, String apellido, String email, String nombreUsuario, String contrasena) {
        super(dni, nombre, apellido, email, nombreUsuario, contrasena);
    }

    // Getter and Setter
    public List<Reporte> getReportesRevisados() {
        return reportesRevisados;
    }

    public void setReportesRevisados(List<Reporte> reportesRevisados) {
        this.reportesRevisados = reportesRevisados;
    }

    // toString method
    @Override
    public String toString() {
        return "Administrador{" +
                "reportesRevisados=" + reportesRevisados +
                ", dni='" + getDni() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", nombreUsuario='" + getNombreUsuario() + '\'' +
                ", contrasena='" + getContrasena() + '\'' +
                '}';
    }
}
