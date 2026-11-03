package ut03.usocomun;

/**
 * Ejemplos de la clase StringBuilder: una cadena que sí se puede modificar.
 */
public class EjemplosStringBuilder {

    /**
     * Punto de entrada del programa.
     *
     * @param args no se utilizan
     */
    public static void main(String[] args) {
        // ---- Métodos básicos: modifican el mismo objeto ----
        StringBuilder sb = new StringBuilder("Hola");
        sb.append(", mundo");                 // añade al final
        sb.append('!');
        System.out.println(sb);               // Hola, mundo!
        sb.insert(0, "¡");                    // inserta en una posición
        System.out.println(sb);               // ¡Hola, mundo!
        sb.replace(1, 5, "Adiós");            // sustituye de 1 a 4
        System.out.println(sb);               // ¡Adiós, mundo!
        sb.deleteCharAt(sb.length() - 1);     // borra el último carácter
        sb.delete(0, 1);                      // borra de 0 a 0
        System.out.println(sb);               // Adiós, mundo
        System.out.println(sb.length());      // 12

        // ---- Encadenar llamadas: cada método devuelve el mismo StringBuilder ----
        String saludo = new StringBuilder()
                .append("Hola, ")
                .append("Ana")
                .append(". Tienes ")
                .append(18)
                .append(" años.")
                .toString();
        System.out.println(saludo);           // Hola, Ana. Tienes 18 años.

        // ---- Construir un texto dentro de un bucle ----
        StringBuilder linea = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            linea.append(i);
            if (i < 5) {
                linea.append(" - ");
            }
        }
        System.out.println(linea);            // 1 - 2 - 3 - 4 - 5

        // ---- reverse: ¿es un palíndromo? ----
        String palabra = "reconocer";
        String alReves = new StringBuilder(palabra).reverse().toString();
        System.out.println(palabra.equals(alReves));   // true

        // ---- Comparar: StringBuilder NO sobrescribe equals ----
        StringBuilder a = new StringBuilder("hola");
        StringBuilder b = new StringBuilder("hola");
        System.out.println(a.equals(b));                         // false
        System.out.println(a.toString().equals(b.toString()));   // true
        System.out.println(a.compareTo(b) == 0);                 // true
    }
}
