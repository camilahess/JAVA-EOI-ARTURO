package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Consultas SELECT CON STATEMENT
public class App {

    // Crear cadena de conexión fuera del MAIN. Constantes estáticas (solo lectura)
    // Cuando son constantes globales ( public final static) ponerlo en MAYUS por
    // costumbre
    public final static String CADENA_CONEXION = "jdbc:mariadb://localhost:3306/product-manager";
    public final static String USER = "root";
    public final static String PASS = "";

    /**
     * Listar todas las categorias
     */
    public static void ejemplo1() {
        // conectar a base de datos
        // Dentro del try( ) ponemos la conexión con archivos o bases de datos
        try (Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {
            // System.out.println("Conexión establecida");
            Statement st = conn.createStatement(); // Crear objeto Statement para consultas a la base de datos
            ResultSet rs = st.executeQuery("SELECT * FROM category");
            // Lo recorremos con el método next. Mientras haya una siguiente línea, nos
            // devolverá lo que hay.
            while (rs.next()) {
                int id = rs.getInt("id"); // Puedo acceder por el nombre o por el número de columna
                String nombre = rs.getString("name");
                System.out.println(id + " - " + nombre);

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Listar categorías desde el final hacia atrás
     */
    public static void ejemplo2() {
        try (Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {

            // Utilizamos el type scroll insensitive para navagear hacia adelante y atrás
            // y concur read only, solo lectura
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM category");
            rs.afterLast();
            while (rs.previous()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("name");
                System.out.println(id + " - " + nombre);

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    /**
     * Cambiar el nombre a la categoría 5
     */
    public static void ejemplo3() {
        try (Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {

            // Utilizamos el type scroll sensitive para poder hacer cambios
            // y concur UPDATABLE, para poder actualizar cambios
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM category");
            rs.last();
            rs.updateString("name", "Laptops");
            rs.updateRow(); // Con el update row, actualizamos en la base de datos
            System.out.println("Categoría actualizada");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    /**
     * Insertar una nueva categoría a partir de un resultSet
     */
    public static void ejemplo4() {

        try (Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {

            // Utilizamos el type scroll sensitive para poder hacer cambios
            // y concur UPDATABLE, para poder actualizar cambios
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM category");
            rs.moveToInsertRow();
            rs.updateString("name", "New Category");
            rs.insertRow();
            rs.last();
            System.out.println("Categoría insertada");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    /**
     * Borrar la última categoría
     */
    public static void ejemplo5() {
        try (Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {

            // Utilizamos el type scroll sensitive para poder hacer cambios
            // y concur UPDATABLE, para poder actualizar cambios
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM category");
            rs.last();
            rs.deleteRow();
            System.out.println("La última categoría ha sido borrada");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public static void main(String[] args) {
        // ejemplo1();
        // System.out.println("-----------------------------");
        // ejemplo2();
        // ejemplo3();
        // ejemplo4();
        //ejemplo5();
    }
}
