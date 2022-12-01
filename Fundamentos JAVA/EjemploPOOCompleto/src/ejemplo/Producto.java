package ejemplo;

public class Producto {

    private String nombre;
    private double precio;


    public Producto(String nombre, double precio) { // Generate constructor para inicializar propiedades
        setNombre (nombre) ;
        setPrecio ( precio ) ;
    }

    public Producto() {
        this.nombre = "Nada";
        this.precio = 0;
    }

    public Producto (Producto p) { //Constructor de copia
        super();
        this.nombre = p.nombre;
        this.precio = p.precio;
    }


    //Métodos para obtener esos valores ( propiedades ) Aquí podemos controlar
    //que valores debemos aignar 
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setNombre(String nombre) {
       if (nombre != null ) { // si nombre es diferente a null, se asigna el nombre
        this.nombre = nombre;
        }
    }

    public void setPrecio(double precio) {
        if (precio >= 0 )   {
             this.precio = precio;
        } else  {
            precio = 0;
        }
    }
    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", precio=" + precio + "]";
    }

    /**
     * Devuelve el precio sumándole un impuesto 
     * @param impuesto porcentaje entre 0 y 100
     * @return
     */

    public double getPrecioImpuesto( double impuesto) {

        return precio * ( impuesto / 100 + 1);

    }
    
    public double getPrecioImpuesto() { //precio con iva

        return getPrecioImpuesto(21);

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        long temp;
        temp = Double.doubleToLongBits(precio);
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
        Producto other = (Producto) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
            return false;
        return true;
    }






    
}
