package com.example.ejemplospringeventos.usuarios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ejemplospringeventos.usuarios.proyecciones.UsuarioConEventos;
import com.example.ejemplospringeventos.usuarios.proyecciones.UsuarioSinEventos;

public interface UsuariosRepository extends JpaRepository <Usuario, Integer> {
     //query para la proyeccion //
     List<UsuarioSinEventos> findBy();
     UsuarioConEventos findUsuarioById(int id);
}
