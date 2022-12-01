package com.example.ejemplospring1.categories;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriesService {
    private final CategoriesRepository catRepository;

    public List<Category> getCategories() {
        return (List<Category>) catRepository.findAll();
    }

    public List<Category> getCategoriesByName(String name) {
        // return catRepository.getByName("%" + name + "%");
        return catRepository.findByNameContaining(name);
    }

    public Category getCategory(int id) {
        return catRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada") 
        );
    }

    public Category insert(Category c) {
        c.setId(0); // Por si acaso nos envían una id (haría un update en lugar de insert)
        return catRepository.save(c);
    }

    public Category update(Category c, int id) {
        if(!catRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada", null);
        }
        c.setId(id); // Al tener una id hace un update en lugar de un insert
        return catRepository.save(c);
    }

    public void delete(int id) {
        catRepository.deleteById(id);
    }
}
