package com.example.ejemplospringeventos.usuarios.proyecciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.example.ejemplospringeventos.eventos.proyecciones.EventoSinUsuarios;

public interface UsuarioConEventos extends UsuarioSinEventos{
    @Value("#{target.eventos}")
    List<EventoSinUsuarios> getAsistentes();
}
