package com.example.equipos.jugadores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/jugadores") //jugadores?equipo=1
@RequiredArgsConstructor
public class JugadoresController {

    private final JugadoresService jService;

    @GetMapping
    public List<Jugador> getEquipos(@RequestParam int equipo){
        return jService.getByEquipo(equipo);
    }
    
    @GetMapping ("/{id}")
    public Jugador getById(@PathVariable int id) {
        return jService.getById(id);
    }

    @PostMapping
    public Jugador insert (@RequestBody Jugador j) {
        return jService.insert(j);

    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        jService.delete(id);
    }
}
