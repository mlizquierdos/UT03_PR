package ut03.relaciones;

/**
 * Prueba la composición, la agregación, la herencia, el polimorfismo,
 * las clases abstractas y las interfaces.
 */
public class PruebaRelaciones {

    /**
     * Punto de entrada del programa.
     *
     * @param args no se utilizan
     */
    public static void main(String[] args) {
        // Composición y agregación
        Empleado eva = new Empleado("Eva", "C/ Mayor 3", "Valencia");
        Departamento informatica = new Departamento("Informática", eva);
        System.out.println(eva);
        System.out.println(informatica);

        // Herencia y polimorfismo: variables de tipo Figura con objetos distintos
        Figura f1 = new Circulo(1);
        Figura f2 = new Rectangulo(2, 3);
        System.out.println(f1);     // Círculo de área 3,14
        System.out.println(f2);     // Rectángulo de área 6,00

        // Interfaz: un Dibujable puede ser cualquier figura
        Dibujable d = f2;
        System.out.println("Dibujo: " + d.dibujar());

        // Figura f = new Figura("X");   // no compila: Figura es abstracta

        // Para usar un método propio de Rectangulo hay que hacer casting
        if (f2 instanceof Rectangulo r) {
            System.out.println("Base: " + r.getBase());
        }
    }
}
