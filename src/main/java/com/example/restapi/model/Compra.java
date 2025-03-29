package com.example.restapi.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    @Column(nullable = false, unique = true)
    private String dniCliente; 
    @Column(nullable = false, unique = true)
    private List<String> librosComprados; 
    @Column(nullable = false, unique = true)
    private Pago pago; 

    public String getDniCliente() { 
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) { 
        this.dniCliente = dniCliente;
    }

    public List<String> getLibrosComprados() { 
        return librosComprados;
    }

    public void setLibrosComprados(List<String> librosComprados) { 
        this.librosComprados = librosComprados;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
}