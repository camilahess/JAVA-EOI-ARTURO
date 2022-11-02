public class App {
    public static void main(String[] args) throws Exception {
         Usuario u = new Usuario("Pepito", 23, "1234@hotmail.com", "1234");
         System.out.println(u.getNombre());
         System.out.println(u.getEdad());
         System.out.println(u.getCorreo());
         System.out.println(u.getPassword());
         System.out.println(u.toString());

    }
}
