package com.example.equipos.equipos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/equipos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200") //agregamos crossorigin para acceder desde el front

public class EquiposController {

    private final EquiposService eService;

    // Devuelvo todos los equipos -> http://localhost:8080/equipos
    @GetMapping
    public List<Equipo> getAll(@RequestParam(required = false) String nombre,
    @RequestParam(required = false) String ciudad) {
        if (nombre != null) {
    return eService.getByNombre(nombre);
     } else if (ciudad != null) {
    return eService.getByCiudad(ciudad);
     } else {
    return eService.getAll();
    }
}

    // Devuelvo los equipos por id -> http://localhost:8080/equipos/3
    @GetMapping("/{id}")
    public Equipo getById(@PathVariable int id) {
        return eService.getById(id);
    }

    // Inserto un equipo nuevo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // para cambiar el codigo por defecto, nos devolverá 201 Created
    public Equipo insert(@RequestBody Equipo e) {
        return eService.insert(e);

    }

    // Modifico un equipo
    @PutMapping("/{id}")
    public Equipo update(@RequestBody Equipo e, @PathVariable int id) {
        return eService.update(e, id);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        eService.delete(id);
    }
}
