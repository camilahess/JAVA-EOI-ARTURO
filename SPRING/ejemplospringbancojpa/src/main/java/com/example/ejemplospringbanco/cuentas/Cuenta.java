package com.example.ejemplospringbanco.cuentas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Cuenta {
    @Id private int numero;
    @Column(nullable = false)
    private String cliente;
    private double saldo;
}
