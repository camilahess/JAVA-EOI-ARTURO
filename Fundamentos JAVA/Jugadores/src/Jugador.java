

public class Jugador {

    private String nombre;
    private int edad;
    private double sueldo;

    
    public Jugador(String nombre, int edad, double sueldo) {
        this.nombre = nombre;
        setEdad(edad);
        setSueldo(sueldo);
    }
    
    public Jugador (Jugador j) {
        this.nombre = j.nombre;
        this.edad = j.edad;
        this.sueldo = j.sueldo;

    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getEdad() {
        return edad;
    }


    public void setEdad(int edad) {
        this.edad = Math.abs(edad);
} 


    public double getSueldo() {
        return sueldo;
    }


    public void setSueldo(double sueldo) {
        this.sueldo = Math.abs(sueldo);
    }

    @Override
    public String toString() {
        return "Jugadores [nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + edad;
        long temp;
        temp = Double.doubleToLongBits(sueldo);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Jugador other = (Jugador) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (edad != other.edad)
            return false;
        if (Double.doubleToLongBits(sueldo) != Double.doubleToLongBits(other.sueldo))
            return false;
        return true;
    }

    


    
}
