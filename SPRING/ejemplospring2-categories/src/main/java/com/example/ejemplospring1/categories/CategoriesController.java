package com.example.ejemplospring1.categories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemplospring1.products.Product;
import com.example.ejemplospring1.products.ProductsService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//PRIMERO HAGO LOS CONTROLLERS con el URL asociado
//(CADA CONTROLLER para una categoría de una tabla)
//y devuelvo respuesta HTTP.  CON RESPONSE STATTUS
// códigos de respuesta 200, 201, 404 etc 

//Puedo usar en los controladores, servicios de otras categorías.
//Las categorías , tienen productos, por lo cual puedo utilizar productsService


@RestController //devuelve un JSON, array , objeto 
@RequestMapping("/categories") // url base asociado
@RequiredArgsConstructor


public class CategoriesController {
    @Autowired 
    private final CategoriesService catService;
    private final ProductsService productsService;

    @GetMapping
    public List<Category> getCategories(@RequestParam(required = false) String name) {
        if(name != null) {
            return catService.getCategoriesByName(name);
        } else {
        return catService.getCategories();
        }
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable int id) {
        Category c = catService.getCategory(id);
        List<Product> prods = productsService.getProducts(id);
        return new CategoryWithProducts(id, c.getName(), prods);
        }
    

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //para cambiar el codigo por defecto, nos devolverá 201 Created
    public Category insertCategory (@RequestBody Category c){
        return catService.insert(c);

    }

    @PutMapping("/{id}")
    public Category updateCategory(@RequestBody Category c, @PathVariable int id) {
            return catService.update(c, id);
 
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //204, respuesta vacía. Todo ok.
    public void deleteCategory(@PathVariable int id) {
        catService.delete(id);
    }

    // Devuelve todos los productos de una categoría
    @GetMapping("/{idCat}/products")
    public List<Product> getProducts( @PathVariable int idCat) {
        return productsService.getProducts(idCat);
    }

    // Inserta un producto en una categoría
    @PostMapping("/{idCat}/products")
    public Product insertProduct(@RequestBody Product p, @PathVariable int idCat) {
        p.setIdCategory(idCat);
        return productsService.insertProduct(p);

    }

    // Borra un producto de una categoría
    @DeleteMapping("/{idCat}/products/{idProd}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int idProd) {
        productsService.deleteProduct(idProd);
    }

    }
    
