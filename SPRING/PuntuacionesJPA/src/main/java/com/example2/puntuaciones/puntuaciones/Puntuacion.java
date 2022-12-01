package com.example2.puntuaciones.puntuaciones;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Puntuacion {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Obligatorio en JPA
    private int id;
    @Column(nullable = false)
    private String jugador;
    private int puntuacion;

}
