package com.example2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {

    public final static String CADENA_CONEXION = "jdbc:mariadb://localhost:3306/eoi2";
    public final static String USER = "root";
    public final static String PASS = ""; 



    public static void ejercicio1(){
              
        try(Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {
            //System.out.println("Conexión establecida");

            Statement st = conn.createStatement(); 
            ResultSet rs = st.executeQuery("SELECT * FROM categorias");
          
            while(rs.next()) {
                int categoria = rs.getInt("categoria"); 
                String titulo = rs.getString("titulo");
                int salario = rs.getInt("salario");
                int trienio = rs.getInt("trienio");
                System.out.println(categoria + " - " + titulo + " - " + salario + " - " + trienio);

            }

           
            } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            }
    }

    public static void ejercicio2 (){
        String sql = "SELECT * FROM empleados WHERE edad >= ? AND contrato <= ?"; //index 1 edad index 2 contrato
        int  edadBuscar = 40;
        String fechaBuscar = "1998-01-01";
        

        try(Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {

            PreparedStatement st = conn.prepareStatement(sql); 
            st.setInt(1, edadBuscar);
            st.setString(2, fechaBuscar);
            ResultSet rs = st.executeQuery();
          
            while(rs.next()) {
                int num = rs.getInt("num"); 
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                int departamento = rs.getInt("departamento");
                int categoria = rs.getInt("categoria");
                Date contrato = rs.getDate("contrato");
                System.out.println(num + " - " + nombre + " - " + edad + " - " + departamento + " - " + categoria + " - " + contrato);

            }

           
            } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            }
    }

    public static void ejercicio3() {
        try (Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM departamentos");
            while (rs.next()) {
                int num = rs.getInt("deptno");
                String nombre = rs.getString("nombre");
                System.out.println(num + " - " + nombre);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static boolean insertDepartamento(int num, String nombre) {
        return false;
    }


    
    public static void main( String[] args )  {
        //ejercicio1();
        //ejercicio2();

        //ejercicio  3
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de departamento: ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.print("Nombre departamento: ");
        String nombre = sc.nextLine();
        // apartado1();
        insertDepartamento(num, nombre);
        ejercicio3();
        


    }
}
