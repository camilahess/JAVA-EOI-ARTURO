package com.example.ejemplospringeventos.usuarios;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ejemplospringeventos.usuarios.proyecciones.UsuarioConEventos;
import com.example.ejemplospringeventos.usuarios.proyecciones.UsuarioSinEventos;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class UsuariosService {
    private final UsuariosRepository usuariosRepository;
    

    public List<UsuarioSinEventos> getAll() {
        return usuariosRepository.findBy();
    }

    public UsuarioConEventos getById(int id) {
        UsuarioConEventos e = usuariosRepository.findUsuarioById(id);
        if(e == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
        return e;

    }

    public Usuario insert(Usuario e) {
        e.setId(0);
        return usuariosRepository.save(e);
    }

    public void delete(int idEvento) {
        usuariosRepository.deleteById(idEvento);
    }


}
