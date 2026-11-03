package ut03.usocomun;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * Ejemplos de la clase LocalDate (paquete java.time).
 */
public class EjemplosFechas {

    /**
     * Punto de entrada del programa.
     *
     * @param args no se utilizan
     */
    public static void main(String[] args) {
        Locale es = Locale.of("es", "ES");

        // ---- Crear fechas ----
        LocalDate hoy = LocalDate.of(2026, 11, 3);   // en un programa real: LocalDate.now()
        LocalDate examen = LocalDate.parse("2026-12-15");
        System.out.println(hoy);                     // 2026-11-03

        // ---- Consultar sus partes ----
        System.out.println(hoy.getYear());           // 2026
        System.out.println(hoy.getMonthValue());     // 11
        System.out.println(hoy.getDayOfMonth());     // 3
        System.out.println(hoy.getDayOfWeek());      // TUESDAY
        System.out.println(hoy.getDayOfWeek().getDisplayName(TextStyle.FULL, es)); // martes
        System.out.println(hoy.getMonth().getDisplayName(TextStyle.FULL, es));     // noviembre
        System.out.println(hoy.lengthOfMonth());     // 30
        System.out.println(hoy.isLeapYear());        // false

        // ---- Sumar y restar: devuelven una fecha NUEVA (inmutable) ----
        System.out.println(hoy.plusDays(30));        // 2026-12-03
        System.out.println(hoy.plusWeeks(1));        // 2026-11-10
        System.out.println(hoy.minusMonths(2));      // 2026-09-03
        System.out.println(LocalDate.of(2026, 1, 31).plusMonths(1));   // 2026-02-28
        hoy.plusDays(1);                             // ¡no cambia hoy!
        System.out.println(hoy);                     // 2026-11-03

        // ---- Comparar ----
        System.out.println(hoy.isBefore(examen));    // true
        System.out.println(hoy.isAfter(examen));     // false
        System.out.println(hoy.equals(LocalDate.of(2026, 11, 3)));     // true
        System.out.println(hoy.getDayOfWeek() == DayOfWeek.TUESDAY);   // true

        // ---- Diferencias ----
        System.out.println(ChronoUnit.DAYS.between(hoy, examen));      // 42
        Period hastaExamen = Period.between(hoy, examen);
        System.out.println(hastaExamen.getMonths() + " mes y "
                + hastaExamen.getDays() + " días");                     // 1 mes y 12 días
        LocalDate nacimiento = LocalDate.of(2008, 5, 20);
        System.out.println(Period.between(nacimiento, hoy).getYears()); // 18

        // ---- Formato: de fecha a texto y de texto a fecha ----
        DateTimeFormatter corto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(hoy.format(corto));       // 03/11/2026
        DateTimeFormatter largo = DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM 'de' yyyy", es);
        System.out.println(hoy.format(largo));       // martes, 3 de noviembre de 2026
        LocalDate navidad = LocalDate.parse("25/12/2026", corto);
        System.out.println(navidad);                 // 2026-12-25

        // Cuidado: por defecto, un día que no existe se AJUSTA sin avisar
        System.out.println(LocalDate.parse("31/02/2026", corto));      // 2026-02-28

        // Formato estricto: rechaza las fechas imposibles (año con uuuu)
        DateTimeFormatter estricto = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate.parse("31/02/2026", estricto);
        } catch (DateTimeParseException e) {
            System.out.println("Fecha no válida");   // Fecha no válida
        }
        System.out.println(LocalDate.parse("29/02/2028", estricto));   // 2028-02-29
    }
}
