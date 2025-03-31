package com.example.restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pago")
public enum Pago {
    BIZUM, TARJETA_CRÉDITO, PAYPAL
}