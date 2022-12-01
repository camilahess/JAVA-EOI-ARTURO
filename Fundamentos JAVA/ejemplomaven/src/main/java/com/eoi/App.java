package com.eoi;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Persona vacia = new Persona (); // Llama al constructor vacío, sin parámetros
		
		//public Persona(String nombre, String apellido, String dni, String telefono, LocalDate fechaNacimiento) 
		Persona camila = new Persona("Camila", "Hess", "Y7764530C", "652221747", LocalDate.parse("1993-05-18"));
		Persona thiago = new Persona("Thiago", "Baruffaldi", "Y7764547Y", "652221748", LocalDate.of(2005,10,25));
		
 		System.out.println(camila); //Llama al método toString definido en persona.java
 		
		//Darle información a persona vacia con SET 
 		vacia.setNombre("Carolina");
 		vacia.setApellido("Unrein");
 		
 		//System.out.println(vacia);
 		System.out.println("Nombre de vacia: " + vacia.getNombre()); //get obtiene valores de los campos
 		System.out.println("Apellido de vacia: " + vacia.getApellido());
 		
		
	}
}
       
    

