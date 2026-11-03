package ut03.miembros;

import java.util.Objects;

/**
 * Representa a un alumno de un ciclo formativo con su nota media.
 * <p>
 * Reúne en una sola clase los elementos de la unidad: constantes, atributos
 * de clase y de instancia, constructores sobrecargados, {@code this(...)},
 * getters y setters con validación, y los métodos {@code toString},
 * {@code equals} y {@code hashCode}.
 *
 * @author Departamento de Informática
 * @version 1.0
 */
public class Alumno {

    /** Nota mínima para aprobar. */
    public static final double NOTA_APROBADO = 5.0;

    // Atributo de clase: uno compartido por todos los alumnos
    private static int totalAlumnos = 0;

    // Atributos de instancia: cada alumno tiene los suyos
    private final String nia;   // identificador: no cambia
    private String nombre;
    private double notaMedia;

    /**
     * Crea un alumno con nota media 0.
     *
     * @param nia    número de identificación del alumno; no puede estar vacío
     * @param nombre nombre del alumno; no puede estar vacío
     * @throws IllegalArgumentException si algún dato no es válido
     */
    public Alumno(String nia, String nombre) {
        this(nia, nombre, 0.0);   // llama al otro constructor
    }

    /**
     * Crea un alumno con la nota media indicada.
     *
     * @param nia       número de identificación del alumno; no puede estar vacío
     * @param nombre    nombre del alumno; no puede estar vacío
     * @param notaMedia nota media, entre 0 y 10
     * @throws IllegalArgumentException si algún dato no es válido
     */
    public Alumno(String nia, String nombre, double notaMedia) {
        this.nia = validarTexto(nia, "NIA");
        this.nombre = validarTexto(nombre, "nombre");
        this.notaMedia = validarNota(notaMedia);
        totalAlumnos++;
    }

    // ---------------------------------------------------------------- consultas

    /**
     * Indica si el alumno ha aprobado.
     *
     * @return {@code true} si su nota media es al menos {@value #NOTA_APROBADO}
     */
    public boolean estaAprobado() {
        return notaMedia >= NOTA_APROBADO;
    }

    /**
     * Devuelve el número de alumnos creados.
     *
     * @return total de objetos Alumno creados hasta el momento
     */
    public static int getTotalAlumnos() {
        return totalAlumnos;
    }

    // ---------------------------------------------------------------- getters y setters

    /**
     * Devuelve el NIA del alumno.
     *
     * @return el NIA; no cambia nunca (no tiene setter)
     */
    public String getNia() {
        return nia;
    }

    /**
     * Devuelve el nombre del alumno.
     *
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del alumno.
     *
     * @param nombre nuevo nombre; no puede estar vacío
     * @throws IllegalArgumentException si el nombre está vacío
     */
    public void setNombre(String nombre) {
        this.nombre = validarTexto(nombre, "nombre");
    }

    /**
     * Devuelve la nota media del alumno.
     *
     * @return la nota media, entre 0 y 10
     */
    public double getNotaMedia() {
        return notaMedia;
    }

    /**
     * Cambia la nota media del alumno.
     *
     * @param notaMedia nueva nota, entre 0 y 10
     * @throws IllegalArgumentException si la nota está fuera de ese rango
     */
    public void setNotaMedia(double notaMedia) {
        this.notaMedia = validarNota(notaMedia);
    }

    // ---------------------------------------------------------------- métodos de Object

    /**
     * Devuelve una representación en texto del alumno.
     *
     * @return cadena con el NIA, el nombre y la nota media
     */
    @Override
    public String toString() {
        return "Alumno[nia=" + nia + ", nombre=" + nombre + ", notaMedia=" + notaMedia + "]";
    }

    /**
     * Dos alumnos son iguales si tienen el mismo NIA.
     *
     * @param obj objeto con el que se compara
     * @return {@code true} si {@code obj} es un Alumno con el mismo NIA
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Alumno otro = (Alumno) obj;
        return Objects.equals(nia, otro.nia);
    }

    /**
     * Devuelve el código hash, coherente con {@link #equals(Object)}.
     *
     * @return el código hash calculado a partir del NIA
     */
    @Override
    public int hashCode() {
        return Objects.hash(nia);
    }

    // ---------------------------------------------------------------- privados

    // Comprueba que un texto no es null ni está vacío.
    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("El " + campo + " no puede estar vacío");
        }
        return valor;
    }

    // Comprueba que la nota está entre 0 y 10.
    private static double validarNota(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 10");
        }
        return nota;
    }
}
