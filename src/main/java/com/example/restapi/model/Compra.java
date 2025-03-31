package com.example.restapi.model;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @Column(nullable = false)
    private String dniCliente;
    
    @ManyToMany
    @JoinTable(
        name = "compra_libro",
        joinColumns = @JoinColumn(name = "compra_id"),
        inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    private List<Libro> librosComprados; 
    
    @Enumerated(EnumType.STRING)
    private String dniCliente; 
    private List<String> librosComprados;
    private Pago pago; 

    public String getDniCliente() { 
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) { 
        this.dniCliente = dniCliente;
    }

    public List<Libro> getLibrosComprados() { 
        return librosComprados;
    }

    public void setLibrosComprados(List<Libro> librosComprados) { 
        this.librosComprados = librosComprados;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
}