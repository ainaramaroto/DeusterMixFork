package com.example.restapi.model;

public class Administrador extends Usuario {
    private String rol;

    // Constructor
    public Administrador(String dni, String nombre, String apellido, String email, String telefono, String nombreUsuario, String contrasena, String direccion, String rol) {
        super(dni, nombre, apellido, email, telefono, nombreUsuario, contrasena, direccion);
        this.rol = rol;
    }

    // Getter and Setter
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // toString method
    @Override
    public String toString() {
        return "Administrador{" +
                "rol='" + rol + '\'' +
                ", dni='" + getDni() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", nombreUsuario='" + getNombreUsuario() + '\'' +
                ", contrasena='" + getContrasena() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                '}';
    }
}
