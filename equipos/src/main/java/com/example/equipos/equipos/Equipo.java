package com.example.equipos.equipos;


import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Equipo {

    @Id private int id; //clave primaria

    private String nombre;

    private String ciudad;

    private String fechaCreacion;

    
}
