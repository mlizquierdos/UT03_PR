package ut03.relaciones;

/**
 * Figura geométrica. Es abstracta: no se pueden crear objetos Figura,
 * solo de sus subclases.
 */
public abstract class Figura implements Dibujable {

    private String nombre;

    /**
     * Inicializa la parte común de todas las figuras.
     *
     * @param nombre nombre de la figura
     */
    protected Figura(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Calcula el área. Cada subclase lo hace a su manera.
     *
     * @return el área de la figura
     */
    public abstract double calcularArea();

    /**
     * Devuelve el nombre de la figura.
     *
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return String.format("%s de área %.2f", nombre, calcularArea());
    }
}
