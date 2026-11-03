package ut03.usocomun;

import java.util.Scanner;

/**
 * Lee datos del teclado con Scanner y los muestra con printf.
 */
public class EntradaTeclado {

    /**
     * Punto de entrada del programa.
     *
     * @param args no se utilizan
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   // un único Scanner para todo el programa

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Nota (por ejemplo, 7,5): ");
        while (!sc.hasNextDouble()) {          // comprobamos antes de leer
            System.out.print("Eso no es un número. Nota: ");
            sc.next();                         // descartamos lo escrito
        }
        double nota = sc.nextDouble();
        sc.nextLine();                         // consumimos el salto de línea

        System.out.printf("%s tiene un %.1f%n", nombre, nota);
    }
}
