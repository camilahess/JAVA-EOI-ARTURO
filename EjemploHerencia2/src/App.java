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

    public static void main(String[] args) throws Exception {
       //ejemplo4();
       ejemplo5();


     
}
}
