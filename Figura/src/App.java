public class App {
    public static void main(String[] args) throws Exception {
     
        Circulo cir = new Circulo(6);
        Cuadrado cua = new Cuadrado(4);

        System.out.println("------- Círculo (radio: " + cir.getRadio() + ") -------");
        System.out.printf("Área: %.2f\n", cir.getArea());
        System.out.printf("Perímetro: %.2f\n", cir.getPerimetro());

        System.out.println("------- Cuadrado (lado: " + cua.getLado() + ") -------");
        System.out.printf("Área: %.2f\n", cua.getArea());
        System.out.printf("Perímetro: %.2f\n", cua.getPerimetro());

    }
}

