

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class App {


    public static void ejemplo1(){
        //Es mejor utilizar listas, para trabajar con ellas
        //Podemos utilizar un array cuando no vamos a modificar nada.
        Integer [] numeros = {3,4,5,6,7};
        Arrays.sort(numeros);
        Arrays.toString(numeros);
        List<Integer> list = new ArrayList<>(List.of(numeros));
        list.add(8);
        System.out.println(list);

    }

    public static void ejemplo2 (){
       //Tipos de listas  
       List <Integer> numeros = new ArrayList<>(20);
       System.out.println(numeros.size());
       // List <Integer> numeros = new LinkedList<>();
        numeros.add(4);
        numeros.add(5);
        System.out.println(numeros);

        numeros.add(1,23);
        System.out.println(numeros);

        numeros.addAll(List.of(10,11,12,14));
        System.out.println(numeros);


    }
    
    public static void ejemplo3(){
        //Pasar de lista a array
        List<String> palabras = new ArrayList<>();
        palabras.add("Coche");
        palabras.add("Casa");
        palabras.add("Perro");
        palabras.add("Gato");


        String [] palabrasArray =  new String [palabras.size()];
        palabras.toArray(palabrasArray);
        System.out.println(Arrays.toString(palabrasArray));

        palabras.removeAll(List.of("Casa","Perro"));
        System.out.println(palabras);
       


    }

    public static void ejemplo4 (){
        List <Integer> numeros = new ArrayList<>(List.of(1,2,3,4));
        System.out.println(numeros.contains(3));
        //Contains devuelve true o false, es boolean
        System.out.println(numeros.contains(13));

        //CONTAINS ALL
        System.out.println(numeros.containsAll(List.of(5,6,3)));
        System.out.println(numeros.containsAll(List.of(1,2,3))); // si contiene todos estos elementos, true
        
        //INDEX OF
         System.out.println(numeros.indexOf(1)); //Devuelve la posición de ese número si es que lo encuentra
         System.out.println(numeros.indexOf(0)); //Devuelve -1 si no encuentra el número

         //REMOVE //Cuidado cuando sea una lista de enteros
         numeros.remove(Integer.valueOf(3)); //Esto borra el número 3
         numeros.remove(4); //Esto borra el índice 4



    }

    public static void ejemplo5(){
        //ORDENAR LISTAS
        List <Integer> numeros = new ArrayList<>(List.of(1,5,7,3,10,15));
        //Método 1
        //Ordenar por defecto con Collections.sort
        //Collections.sort(numeros);
        //System.out.println(numeros);

        //Método 2 List.sort (Hay que pasarle un comparador o null por defecto)
        numeros.sort(null);
        System.out.println(numeros);
        
        //Ordenar al revés, de mayor a menor
        //Collections.sort(numeros, Comparator.reverseOrder()); esto es lo mismo que abajo
        numeros.sort(Comparator.reverseOrder());
        System.out.println(numeros);
        Collections.shuffle(numeros); // Desordena lista (random)
        System.out.println(numeros);

    }

    // Métodos que reciben funciones (lambdas)
    public static void ejemplo6() {
        List<Integer> numeros = new ArrayList<>(List.of(3, 2, 1, 7, 6, 8));
        System.out.println(numeros);

        // Borrar números pares
        numeros.removeIf(n -> n % 2 == 0);
        System.out.println(numeros);

        numeros.replaceAll(n -> n * 2);
        System.out.println(numeros);
    }

    /**
     * Ordenar una lista en base a una función de comparación (lambda)
     */
    public static void ejemplo7() {
        List<String> palabras = new ArrayList<>(
            List.of("gato", "perro", "aro", "murciélago", "patata")
        );
        palabras.sort(null);
        System.out.println(palabras);

        // Ordenar las palabras por su longitud
        palabras.sort((p1, p2) -> p1.length() - p2.length());
        System.out.println(palabras); // [aro, gato, perro, patata, murciélago]
        // Al revés
        palabras.sort((p1, p2) -> p2.length() - p1.length());
        System.out.println(palabras); // [murciélago, patata, perro, gato, aro]
        // Otra forma de comparar números
        palabras.sort((p1, p2) -> Integer.compare(p1.length(), p2.length()));
        System.out.println(palabras); // [aro, gato, perro, patata, murciélago]
    }

    // Ordenar objetos
    public static void ejemplo8() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(24, "Juan"));
        personas.add(new Persona(19, "Ana"));
        personas.add(new Persona(43, "Marta"));
        personas.add(new Persona(33, "Zacarías"));
        personas.add(new Persona(17, "Paula"));

        System.out.println(personas);

        // Ordenar por edad
        personas.sort((p1, p2) -> p1.getEdad() - p2.getEdad());
        System.out.println(personas);

        // Ordenar por nombre
        personas.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
        System.out.println(personas);

        // Ordenar por edad 2 (Comparing)
        personas.sort(Comparator.comparing(p -> p.getEdad()));
        System.out.println(personas);

        // Ordenar por edad 3 (Comparing)
        personas.sort(Comparator.comparing(Persona::getEdad));

        personas.forEach(p -> System.out.println(p));
        // personas.forEach(System.out::println); // Igual que lo anterior

    
    }

    public static void ejercicio1 (){
        List<Integer> numeros = new ArrayList<>(List.of(10, 20, 30, 40));
		System.out.println(numeros);
		// numeros.forEach(n -> System.out.println(n));
		numeros.add(50);
		numeros.add(60);
		System.out.println(numeros);
		// numeros.remove(1); // elimina la posición 1, en este caso el 20
        // numeros.removeIf(n ->n==20); // este borra todos los 20 que encuentre
		numeros.remove(numeros.indexOf(20)); // borra el primer 20 que que encuentra
		System.out.println(numeros);
		numeros.add(1, 25);
		numeros.add(2, 26);
		System.out.println(numeros);
		numeros.sort(Collections.reverseOrder());
		System.out.println(numeros);

	}

    public static void ejercicio2 (){
        List<String> nombres = new ArrayList<>(Arrays.asList("caMIla", "Thiago", "tomas", "javier", "PEdro", "Pato",
        "Jaqui", "anastasia", "Alicia"));
        
    nombres.replaceAll(cadena -> cadena.toUpperCase());
    System.out.println(nombres);

    nombres.removeIf(nombre -> nombre.startsWith("A"));
    System.out.println(nombres);

    nombres.forEach( nombre -> System.out.println(nombre));

    }
    
    public static void main(String[] args) throws Exception {
       //ejemplo1();
       //ejemplo2();
       //ejemplo3();
       //ejemplo4();
       //ejemplo5();
       ejercicio2();
    }

}