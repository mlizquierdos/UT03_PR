package ut03.objetos;

/**
 * Representa una bombilla que se puede encender y apagar.
 * <p>
 * Ejemplo sencillo para ver el estado, el comportamiento y la identidad
 * de un objeto.
 *
 * @author Departamento de Informática
 * @version 1.0
 */
public class Bombilla {

    private int potencia;       // en vatios
    private boolean encendida;  // false por defecto

    /**
     * Crea una bombilla apagada con la potencia indicada.
     *
     * @param potencia potencia en vatios
     */
    public Bombilla(int potencia) {
        this.potencia = potencia;
    }

    /** Enciende la bombilla. */
    public void encender() {
        encendida = true;
    }

    /** Apaga la bombilla. */
    public void apagar() {
        encendida = false;
    }

    /**
     * Indica si la bombilla está encendida.
     *
     * @return {@code true} si está encendida
     */
    public boolean isEncendida() {
        return encendida;
    }

    /**
     * Devuelve la potencia de la bombilla.
     *
     * @return la potencia en vatios
     */
    public int getPotencia() {
        return potencia;
    }
}
