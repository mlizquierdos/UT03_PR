package ut03.relaciones;

/**
 * Empleado de una empresa.
 * <p>
 * Composición: el propio empleado crea su {@link Direccion}; la dirección
 * no existe fuera del empleado.
 */
public class Empleado {

    private String nombre;
    private Direccion direccion;   // "tiene una" dirección

    /**
     * Crea un empleado y su dirección.
     *
     * @param nombre nombre del empleado
     * @param calle  calle y número de su domicilio
     * @param ciudad ciudad de su domicilio
     */
    public Empleado(String nombre, String calle, String ciudad) {
        this.nombre = nombre;
        this.direccion = new Direccion(calle, ciudad);   // la crea el empleado
    }

    /**
     * Devuelve el nombre del empleado.
     *
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + ", vive en " + direccion;
    }
}
