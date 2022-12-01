package com.example.equipos.jugadores;

import java.util.List;

import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.equipos.equipos.Equipo;
import com.example.equipos.equipos.EquiposRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JugadoresService {

    private final JugadoresRepository jRepository;
    private final JdbcAggregateTemplate jdbcTemplate;
    private final EquiposRepository equiposRepository; 


    public List<Jugador> getByEquipo(int id) {
        return jRepository.findByIdEquipo(id);
    }

    public List<Jugador> getByCiudad(String ciudad) {
        return jRepository.findByCiudad(ciudad);
    }

    public JugadorConEquipo getById(int id) {
        Jugador j = jRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jugador no encontrado"));
        Equipo e = equiposRepository.findById(j.getIdEquipo()).get();
        return new JugadorConEquipo(j, e);
    }
    

    public Jugador insert (Jugador j) {
        return jdbcTemplate.insert(j);
    }
    
    public void delete(int id) {
        jRepository.deleteById(id);
    }
}
