package ut03.relaciones;

/**
 * Dirección postal. Forma parte de un {@link Empleado} (composición).
 */
public class Direccion {

    private String calle;
    private String ciudad;

    /**
     * Crea una dirección.
     *
     * @param calle  calle y número
     * @param ciudad ciudad
     */
    public Direccion(String calle, String ciudad) {
        this.calle = calle;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return calle + " (" + ciudad + ")";
    }
}
