package com.example.ejemplospringbanco.cuentas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentasRepository extends JpaRepository <Cuenta, Integer> {
    
}
