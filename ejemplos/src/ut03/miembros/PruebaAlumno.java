package ut03.miembros;

import java.util.HashSet;
import java.util.Set;

/**
 * Prueba la clase {@link Alumno}: constructores, getters y setters,
 * miembros estáticos, toString, equals y hashCode.
 */
public class PruebaAlumno {

    /**
     * Punto de entrada del programa.
     *
     * @param args no se utilizan
     */
    public static void main(String[] args) {
        Alumno ana = new Alumno("1001", "Ana", 7.5);
        Alumno luis = new Alumno("1002", "Luis");          // nota 0
        Alumno anaOtraVez = new Alumno("1001", "Ana García", 7.5);

        System.out.println(ana);                            // llama a toString()
        System.out.println(luis.getNombre() + " aprobado: " + luis.estaAprobado());

        luis.setNotaMedia(6.25);                            // modificación de una propiedad
        System.out.println(luis.getNombre() + " aprobado: " + luis.estaAprobado());

        // Miembros estáticos: se usan con el nombre de la clase
        System.out.println("Alumnos creados: " + Alumno.getTotalAlumnos());
        System.out.println("Nota para aprobar: " + Alumno.NOTA_APROBADO);

        // == compara referencias; equals compara según el NIA
        System.out.println("ana == anaOtraVez: " + (ana == anaOtraVez));
        System.out.println("ana.equals(anaOtraVez): " + ana.equals(anaOtraVez));

        // HashSet usa hashCode y equals: no admite dos alumnos iguales
        Set<Alumno> grupo = new HashSet<>();
        grupo.add(ana);
        grupo.add(luis);
        grupo.add(anaOtraVez);
        System.out.println("Alumnos distintos en el grupo: " + grupo.size());

        // El setter impide que el objeto quede en un estado incorrecto
        try {
            luis.setNotaMedia(12);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
