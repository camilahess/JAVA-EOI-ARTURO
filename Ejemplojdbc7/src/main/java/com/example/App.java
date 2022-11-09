

package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import javax.sql.PooledConnection;

import org.mariadb.jdbc.MariaDbPoolDataSource;

import com.example.dao.CategoryDAO;
import com.example.dao.CategoryDAOMariaDB;
import com.example.dao.ProductDAO;
import com.example.dao.ProductDAOMariaDB;
import com.example.entidades.Category;
import com.example.entidades.Product;

/**
 * Ejemplo 3 de JDBC pero con Pool de conexiones
 */
public class App {
    private static PooledConnection pcon;
    private static Scanner sc;
    private static CategoryDAO catDao;
    private static ProductDAO prodDao;

    public static void mostrarCategorias(){
        List<Category> cats = catDao.findAll();
         cats.forEach(c -> System.out.println(c));

    }

    public static void insertarCategoria(){
        System.out.println("Nombre de la categoría: ");
        String nombre = System.console().readLine();
        Category c = new Category(0, nombre);
        Category insertedCat = catDao.insert(c);
        System.out.println("Categoría insertada: " + insertedCat);
    }

    public static void actualizaCategoria(){
        //Mostrar todas las categorías
        // El usuario elige una id de categoría a modificar (opcional: comprobar que la cat existe)
        //Se le pide un nuevo nombre
        //Se modifica
        mostrarCategorias();
        System.out.println("Elige la categoría(id) a modificar");
        int idActualizar = Integer.parseInt(System.console().readLine());

        //utilizamos el método creado en CategoryDAOMariaDB (findById)
        Category c = catDao.findById(idActualizar);
        if (c == null) {
            System.out.println("Error");
        } else {
        
        System.out.println("Ingresa el nuevo nombre ");
        String nombre = System.console().readLine();
        c.setName(nombre);
        catDao.update(c);
        }

    }

    public static void borraCategoria(){
        mostrarCategorias();
        System.out.println("Elige la categoría a borrar");

        int idBorrar = Integer.parseInt(System.console().readLine());
        catDao.delete(idBorrar);
        System.out.println("Categoría borrada correctamente");




    }

    public static void mostrarProductos(){
        mostrarCategorias();
        System.out.print("Elige una categoría: ");
        int idCat = Integer.parseInt(System.console().readLine());

        List<Product> prods = prodDao.findByCategory(idCat);
        prods.forEach(p -> System.out.println(p));
    }


    public static void insertarProducto() {
        // Mostrar y seleccionar categoría
        // Pedir resto de datos (reference, name, price)
        // Mostrar producto añadido
    }


    public static void showMenu() {
        int opcion;
        do{
        System.out.println("----------MENU----------");
        System.out.println("1.Mostrar categorías");
        System.out.println("2.Añadir categoría");
        System.out.println("3.Modificar categoría");
        System.out.println("4.Borrar categoría");
        System.out.println("5.Mostrar productos de una categoría");
        System.out.println("0.Salir");

        System.out.println("Elige una opción: ");
        try{
        opcion = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException e ) {
            System.err.println("La opción debe ser numérica");
            opcion = -1;
        }

        switch (opcion) {
            case 1  -> mostrarCategorias();
            case 2  -> insertarCategoria();
            case 3  -> actualizaCategoria();
            case 4  -> borraCategoria();
            case 5  -> mostrarProductos();


        }
        } while (opcion != 0);
    }

    public static void main( String[] args ) throws SQLException {
       // Creamos Pool de conexiones MariaDB
       MariaDbPoolDataSource pool = new MariaDbPoolDataSource("jdbc:mariadb://localhost:3306/product-manager?user=root&maxPoolSize=10");
       pcon = pool.getPooledConnection();

       sc = new Scanner(System.in);
       catDao = new CategoryDAOMariaDB(pcon);
       
       prodDao = new ProductDAOMariaDB(pcon);   
        showMenu();
   
    }
}