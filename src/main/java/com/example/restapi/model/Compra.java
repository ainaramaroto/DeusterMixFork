package com.example.restapi.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dniCliente; 
    private List<String> librosComprados; 
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