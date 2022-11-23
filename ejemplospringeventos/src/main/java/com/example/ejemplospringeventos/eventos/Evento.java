package com.example.ejemplospringeventos.eventos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.example.ejemplospringeventos.usuarios.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//TABLAS BIDIRECCIONALES

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Evento {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descripcion;
    private double precio;
    private LocalDate fecha;

    @ManyToMany(mappedBy = "eventos") //esto está definido, mappeado en USUARIO
    private List<Usuario> usuarios;
}
