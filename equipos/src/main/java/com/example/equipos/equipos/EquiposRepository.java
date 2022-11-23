package com.example.equipos.equipos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EquiposRepository extends CrudRepository <Equipo, Integer> {
     // Equipos en cuyo nombre esté incluido el string de búsqueda
     List<Equipo> findByNombreContaining(String nombre);

     // Filtra por ciudad
     List<Equipo> findByCiudad(String ciudad);
 
     // Filtra por nombre Y ciudad
     List<Equipo> findByNombreContainingAndCiudad(String nombre, String ciudad);
    
}
