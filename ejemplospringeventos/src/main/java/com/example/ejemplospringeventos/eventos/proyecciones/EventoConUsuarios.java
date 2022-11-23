package com.example.ejemplospringeventos.eventos.proyecciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.example.ejemplospringeventos.usuarios.proyecciones.UsuarioSinEventos;

public interface EventoConUsuarios extends EventoSinUsuarios {

    @Value("#{target.usuarios}")
    List<UsuarioSinEventos> getAsistentes();
    
}
