package ut03.miembros;

/**
 * Muestra que en Java el paso de parámetros es siempre por valor,
 * también cuando el parámetro es una referencia a un objeto.
 */
public class PasoDeParametros {

    // Recibe una copia del valor: el cambio no se ve fuera
    static void duplicar(int numero) {
        numero = numero * 2;
    }

    // Recibe una copia de la referencia: puede cambiar el estado del objeto…
    static void aprobar(Alumno alumno) {
        alumno.setNotaMedia(5);
    }

    // …pero si la copia apunta a otro objeto, la variable original no cambia
    static void cambiarAlumno(Alumno alumno) {
        alumno = new Alumno("9999", "Otro");
    }

    /**
     * Punto de entrada del programa.
     *
     * @param args no se utilizan
     */
    public static void main(String[] args) {
        int n = 10;
        duplicar(n);
        System.out.println("n = " + n);                       // 10

        Alumno marta = new Alumno("2001", "Marta", 3);
        aprobar(marta);
        System.out.println("Nota de Marta: " + marta.getNotaMedia());  // 5.0

        cambiarAlumno(marta);
        System.out.println("Nombre: " + marta.getNombre());           // Marta
    }
}
