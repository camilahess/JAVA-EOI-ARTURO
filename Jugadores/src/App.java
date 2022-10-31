import java.util.ArrayList;
import java.util.List;

public class App {
  
    public static void ejercicio4() {
        //Crea un equipo y añade 4 jugadores
        Equipo e = new Equipo();

        e.addJugador(new Jugador("Jose", 23, 25000));
        e.addJugador(new Jugador("Antonio", 35, 44500));
        e.addJugador(new Jugador("Fran", 19, 21000));
        e.addJugador(new Jugador("Paco", 29, 39000));

        e.deleteJugador(0);

        for(int i = 0; i < e.getNumJugadores(); i++) {
            System.out.println(e.getJugador(i));
        }

        System.out.println("Total sueldos: " + e.totalSueldos());
    }
        
    public static void ejercicio2() {
        List<Jugador> listaJugadores = new ArrayList<Jugador>();
        Jugador uno = new Jugador("Camila", 29, 1000);
        Jugador dos = new Jugador("Thiago", -19, -3000);
        Jugador tres = new Jugador("Tomas", 27, 2000);
        Jugador cuatro = new Jugador("Jaqui", 39, 3500);

        listaJugadores.add(uno);
        listaJugadores.add(dos);
        listaJugadores.add(tres);
        listaJugadores.add(cuatro);

        listaJugadores.add(2, null);
        listaJugadores.add(3, null);

        for (Jugador j : listaJugadores) {
            if ( j != null) {
            System.out.println(j.toString());
        }

    }
}

    public static void ejercicio1 (){
        Jugador uno = new Jugador("Camila", 29, 1000);
        Jugador dos = new Jugador("Thiago", -19, -3000);

        System.out.println(uno);
        System.out.println(dos);
    }
    
    public static void main(String[] args) throws Exception {
       //ejercicio1();
        //ejercicio2();
        ejercicio4 ();

        
    }
}
