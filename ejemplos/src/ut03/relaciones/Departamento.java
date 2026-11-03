package ut03.relaciones;

/**
 * Departamento de una empresa.
 * <p>
 * Agregación: el jefe es un {@link Empleado} que ya existe y que se recibe
 * desde fuera; si el departamento desaparece, el empleado sigue existiendo.
 */
public class Departamento {

    private String nombre;
    private Empleado jefe;   // "tiene un" jefe, pero no lo crea

    /**
     * Crea un departamento con su jefe.
     *
     * @param nombre nombre del departamento
     * @param jefe   empleado que dirige el departamento
     */
    public Departamento(String nombre, Empleado jefe) {
        this.nombre = nombre;
        this.jefe = jefe;   // se recibe un objeto ya creado
    }

    @Override
    public String toString() {
        return "Departamento " + nombre + " (jefe: " + jefe.getNombre() + ")";
    }
}
