package ut03.objetos;

/**
 * Crea varios objetos Bombilla para mostrar que cada uno tiene su propio
 * estado y su propia identidad.
 */
public class PruebaBombilla {

    /**
     * Punto de entrada del programa.
     *
     * @param args no se utilizan
     */
    public static void main(String[] args) {
        Bombilla salon = new Bombilla(60);
        Bombilla cocina = new Bombilla(60);

        salon.encender();   // mensaje al objeto salon

        System.out.println("Salón encendida: " + salon.isEncendida());    // true
        System.out.println("Cocina encendida: " + cocina.isEncendida());  // false

        // Mismos valores, pero son dos objetos distintos (identidad)
        System.out.println("¿Mismo objeto? " + (salon == cocina));        // false

        // Dos variables que referencian el MISMO objeto
        Bombilla otraVez = salon;
        otraVez.apagar();
        System.out.println("Salón encendida: " + salon.isEncendida());    // false
    }
}
