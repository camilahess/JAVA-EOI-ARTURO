import java.util.ArrayList;
import java.util.List;

public class Equipo {

private List<Jugador> listaJugadores;

public Equipo() {
   listaJugadores = new ArrayList<>(); //inicializo la lista
}

public void addJugador (Jugador j) {
    if(j !=null) { 
    listaJugadores.add(j); //Agrego un jugador a la lista
    }
}

public int getNumJugadores (){
    return listaJugadores.size(); //Tamaño de la lista, numero de jugadores

}

public Jugador getJugador(int posicion){
    if (posicion >=0 && posicion < listaJugadores.size()){
        return listaJugadores.get(posicion);
    } else {
        return null;
    }

}
public void deleteJugador(int posicion) {
    if (posicion >=0 && posicion < listaJugadores.size()){
     listaJugadores.remove(posicion);
    }

}

public double totalSueldos() {
    double total = 0;

    for(Jugador jugador : listaJugadores)
    total = total + jugador.getSueldo();
    return total;
}

}



    
