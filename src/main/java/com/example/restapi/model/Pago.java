package com.example.restapi.model;

public class Pago {
    private Usuario usuario;
    private String tipoPago;

    // Constructor
    public Pago(Usuario usuario, String tipoPago) {
        this.usuario = usuario;
        this.tipoPago = tipoPago;
    }

    // Getters and Setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    // toString method
    @Override
    public String toString() {
        return "Pago{" +
                "usuario=" + usuario +
                ", tipoPago='" + tipoPago + '\'' +
                '}';
    }
}