package com.example.dao;

import java.util.List;

import com.example.entidades.Category;

public interface CategoryDAO {

    /**
     * Obtiene todas las categorías de la tabla Category (Lista)
     * @return Lista de objetos (Category)
     */

     List<Category> findAll();
    
     
    /**
     * Busca una categoría a partir de su id
     * @return El objeto categoría encontrado o null si no lo encuentra
     */
    Category findById(int id);

    /**
     * Inserta una categoría en la tabla category
     * @param c Categoria a insertar
     * @return La categoría insertada con la id autogenerada
     */
    Category insert(Category c);

    /**Actualiza una categoría en la tabla category
     * @param c Categoría a actualizar
     * @return true si se ha actualizado la categoría correctamente
     */
    boolean update(Category c);

    boolean delete (int id);


}
