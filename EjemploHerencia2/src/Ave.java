import java.util.Random;

public class Ave extends Animal {
    private boolean puedeVolar;

    public Ave(String nombre, double peso, boolean puedeVolar) {
        super(nombre, peso);
        this.puedeVolar = puedeVolar;
    }

    // Los getters de los booleanos, a veces se ponen con isPuedeVolar por ejemplo
    public boolean getPuedeVolar() {
        return puedeVolar;
    }

    public void setPuedeVolar(boolean puedeVolar) {
        this.puedeVolar = puedeVolar;
    }

    public void ponerHuevos() {
        int numHuevos = new Random().nextInt(6) + 1;
        System.out.printf("He puesto %d huevos\n", numHuevos);
    }

    @Override
    public String tipoAnimal() {
        // TODO Auto-generated method stub
        return "Ave";
    }

    @Override // Redefino el comportamiento por defecto de comer del Animal
    public void comer() {
        // Definimos que un ave aumenta su peso un 5% siempre al comer
        setPeso(getPeso() * 1.05);
        System.out.printf("Pio pio. He comido y ahora peso %.2f kilos\n",
                getPeso());

    }

}
