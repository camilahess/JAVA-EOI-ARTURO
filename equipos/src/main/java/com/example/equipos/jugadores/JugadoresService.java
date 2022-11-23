package com.example.equipos.jugadores;

import java.util.List;

import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JugadoresService {

    private final JugadoresRepository jRepository;
    private final JdbcAggregateTemplate jdbcTemplate;


    public List<Jugador> getByEquipo(int id) {
        return jRepository.findByIdEquipo(id);
    }

    public Jugador getById(int id) {
        return jRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jugador no encontrado"));
    }

    public Jugador insert (Jugador j) {
        return jdbcTemplate.insert(j);
    }
    
    public void delete(int id) {
        jRepository.deleteById(id);
    }

}
