package ut03.usocomun;

import java.util.Arrays;

/**
 * Ejemplos de las clases String, Math y de las clases wrapper.
 */
public class ClasesDeUsoComun {

    /**
     * Punto de entrada del programa.
     *
     * @param args no se utilizan
     */
    public static void main(String[] args) {
        // ---- String ----
        String frase = "  Hola, mundo  ";
        String limpia = frase.strip();
        System.out.println(limpia.length());                    // 11
        System.out.println(limpia.toUpperCase());               // HOLA, MUNDO
        System.out.println(limpia.substring(6));                // mundo
        System.out.println(limpia.contains("mundo"));           // true
        System.out.println(Arrays.toString(limpia.split(", ")));// [Hola, mundo]

        // ---- Math: todo es estático ----
        System.out.println(Math.max(4, 9));                     // 9
        System.out.println(Math.sqrt(81));                      // 9.0
        System.out.println(Math.round(4.5));                    // 5

        // ---- Wrappers ----
        int edad = Integer.parseInt("18");                      // String -> int
        Integer edadObjeto = edad;                              // autoboxing
        int otraVez = edadObjeto;                               // unboxing
        System.out.println(edad + otraVez);                     // 36
        System.out.println(Integer.MAX_VALUE);                  // 2147483647
        System.out.println(Character.isDigit('7'));             // true

        Integer a = 1000, b = 1000;
        System.out.println(a == b);                             // false: dos objetos
        System.out.println(a.equals(b));                        // true: mismo valor
    }
}
