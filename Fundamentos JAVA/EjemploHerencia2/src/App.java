
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void ejemplo1 () {
         // Este ejemplo ya no funciona al ser la clase Animal abstracta (abstract)
        // Lo que impide crear objetos de dicha clase
        // Animal a = new Animal("Cosa", 5);
        //a.comer();

    }

    public static void ejemplo2 () {
        Ave pajaro = new Ave("Aguila", 3, true);
        pajaro.comer();
        pajaro.ponerHuevos();

        Mamifero m = new Mamifero("Leon", 300, true);
        m.comer();
    }
    
    public static void ejemplo3 () {
        //toString
        Mamifero m = new Mamifero("Leon", 300, true);
        System.out.println(m);
    }

    public static void ejemplo4 () {
        //equals
        Mamifero m = new Mamifero("Leon", 300, true);
        Mamifero m2 = new Mamifero(m);

        System.out.println(m);
        System.out.println(m2);

        if(m == m2) { // Mismo objeto
            System.out.println("Son el mismo objeto");
        } else {
            System.out.println("Son objetos diferentes");
        }

        if(m.equals(m2)) {
            System.out.println("Son equivalentes");
        } else {
            System.out.println("Tienen diferentes propiedades");
        }
    }

    public static void ejemplo5() {
        Mamifero m = new Mamifero("Leon", 300, true);
        m.hablar();

        Persona p = new Persona ("Camila");
        p.hablar();
    }

    // Polimorfismo
    public static void ejemplo6() {
        // Solo puedo acceder a aquellos metodos que estén definidos en la clase OBJECT
        Object o = "Hola";
        Object o2 = LocalDate.now();
        Object o3 = new Ave("Pájaro", 1, true);
        Object o4 = new Persona("Juan");

        System.out.println(o2.toString()); 
        System.out.println(o3.toString());

        // o3.comer(); // Error. No puedo acceder al método comer

        //Todo lo almacenado en la lista, aunque cada objeto es de un tipo, está tipado como OBJECT
        List<Object> lista = new ArrayList<>();
        lista.add(34);
        lista.add("Hola");
        lista.add(LocalDate.now());
        lista.add(new Mamifero("Leon", 300, true));

        //Solo puedo acceder a los métodos de Object, no puedo obtener un método específico
        // de cada clase en particular
        for(Object item: lista) {
            System.out.println(item.toString());
        }
    }

    public static void ejemplo7(){
        //Puedo agregar diferentes tipos de animales, ya que heredan de animal a la lista de ANIMALES 
        List<Animal> animales = new ArrayList<>();
        animales.add(new Mamifero("Gacela", 80, false));
        animales.add(new Ave("Loro", 3, true));
        animales.add(new Mamifero("Leon", 150, true));
        animales.add(new Ave("Avestruz", 50, false));

        for (Animal animal : animales) {
            System.out.println("-------------- " + animal.tipoAnimal() + " --------------");
            System.out.println(animal.toString());
            animal.comer();
            //Tengo que comprobar que animal tiene una instancia ave
            if(animal instanceof Ave) { // Objeto de la clase Ave o derivada
                Ave ave = (Ave)animal;
                ave.ponerHuevos();
                // ((Ave)animal).ponerHuevos(); // También se puede hacer en una línea
            }
        }
    }


    public static void ejemplo8() {
        List<IHablador> habladores = new ArrayList<>();
        habladores.add(new Ave("Loro", 1, true));
        habladores.add(new Persona("Pepe"));

        for (IHablador hablador : habladores) {
            hablador.hablar(); // Solo puedo acceder a hablar, ya que son los únicos que tienen el método hablar.
            //Ave y Persona tienen el método en común esa interfaz
        }
    }
    public static void main(String[] args) throws Exception {
       //ejemplo4();
       //ejemplo5();
       //ejemplo6();
      // ejemplo7();
      ejemplo8();

  
}
}
