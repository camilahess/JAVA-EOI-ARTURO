package com.example.equipos.jugadores;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JugadoresRepository extends CrudRepository<Jugador, Integer> {
    List<Jugador> findByIdEquipo(int idEquipo);
    
}
