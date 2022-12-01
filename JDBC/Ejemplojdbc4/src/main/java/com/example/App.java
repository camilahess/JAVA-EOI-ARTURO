package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class App {
    public final static String PRODUCT_MANAGER = "jdbc:mariadb://localhost:3306/product-manager";
    public final static String INSTITUTO = "jdbc:mariadb://localhost:3306/instituto";
    public final static String USER = "root";
    public final static String PASS = "";

    //MOSTRAMOS: CATEGORY
    public static void mostrarCategorias() {
        try (Connection conn = DriverManager.getConnection(PRODUCT_MANAGER, USER, PASS)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM category");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("name");
                System.out.println(id + " - " + nombre);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    //MOSTRAMOS LOS PRODUCT QUE HAY DENTRO DE LA CATEGORÍA: CATEGORY
    public static void mostrarProductosCategorias(int idCat) {
        try (Connection conn = DriverManager.getConnection(PRODUCT_MANAGER, USER, PASS)) {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM category WHERE category = ? ");
            st.setInt(1, idCat);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String referencia = rs.getString("reference");
                String nombre = rs.getString("name");
                Double precio = rs.getDouble("price");
                int categoria = rs.getInt("category");
                System.out.printf("%5d %6s %20.20s %10.2f€\n", id ,referencia, nombre, precio ,categoria);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    //INSERTAR UNA CATEGORIA NUEVA, Y UN PRODUCTO DE ESA CATEGORÍA
    //Cuando hago una insert de una categoría autogenerada, tenemos que devolver el número de id autogenerado y almacenarlo
    public static void insertCategoriaProducto(String nombreCat, String ref, String nombreProd, double precio) {
    try (Connection conn = DriverManager.getConnection(PRODUCT_MANAGER, USER, PASS)) {
        //Delimitamos el commit por si hay errores en las consultas
        conn.setAutoCommit(false);
        // primero - INSERT CATEGORÍA
        PreparedStatement stCat = conn.prepareStatement("INSERT INTO category (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        stCat.setString(1, nombreCat);
        stCat.executeUpdate();
        ResultSet rs = stCat.getGeneratedKeys(); //Devolvemos y almacenamos la id autogenerada
        rs.first();
        int idCat = rs.getInt(1); //ID AUTOGENERADA

        //segundo - INSERT PRODUCTO 
        PreparedStatement stProd = conn.prepareStatement("INSERT INTO product ( reference, name, price, category) VALUES (?, ?, ? , ?)");
        stProd.setString(1,ref);
        stProd.setString(2,nombreProd);
        stProd.setDouble(3,precio);
        stProd.setInt(4,idCat);

        stProd.executeUpdate();
        //conn.commit(); //si esto lo dejo activo, se genera

    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
 }





    public static void main( String[] args ) {
        insertCategoriaProducto("Ejemplo", "6457", "Producto ejemplo", 10);
        mostrarCategorias();
        

    }
}