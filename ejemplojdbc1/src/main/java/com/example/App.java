package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    //Crear cadena de conexión fuera del MAIN. Constantes estáticas (solo lectura)
    //Cuando son constantes globales ( public final static) ponerlo en MAYUS por costumbre 
    public final static String CADENA_CONEXION = "jdbc:mariadb://localhost:3306/product-manager";
    public final static String USER = "root";
    public final static String PASS = ""; 


    public static void main( String[] args )  {
        //conectar a base de datos 
        //Dentro del try( ) ponemos la conexión con archivos o bases de datos
            try(Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {
            System.out.println("Conexión establecida");
            } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            }


    }
}
