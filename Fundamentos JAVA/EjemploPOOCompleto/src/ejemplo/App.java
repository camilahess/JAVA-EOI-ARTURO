package ejemplo;

public class App {
    
    public static void main(String[] args) throws Exception {
       Producto p = new Producto("silla", 100);
       Producto p2 = new Producto(p); // copio un producto

       //imprimo los dos productos
       System.out.println(p); 
       System.out.println(p2);

       p2.setNombre("Ordenador"); // Cambio el nombre del producto que copie
       System.out.println(p); 
       System.out.println(p2); // Imprimo 


       
       

    //    System.out.println(p.getNombre().toUpperCase() + " - " + p.getPrecio()); //devuelvo nombre en mayus
    //    System.out.println("Total con impuestos:" + p.getPrecioImpuesto(20));
    //    System.out.println("Total con impuestos :" + p.getPrecioImpuesto(50));
    //    System.out.println("Total con IVA :" + p.getPrecioImpuesto());
    }  
}
