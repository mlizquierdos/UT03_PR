# 6. Clases de uso común

[← 5. Modificadores y la clase `Object`](05-modificadores-y-object.md) · [Índice](README.md) · Siguiente: [7. Memoria y entorno de desarrollo →](07-memoria-y-entorno.md)

---

Java incluye miles de clases ya programadas. No hay que escribirlas: basta con importarlas (si no están en `java.lang`) y consultar su documentación en la [API de Java](https://docs.oracle.com/en/java/javase/25/docs/api/index.html).

Muchas ofrecen **métodos estáticos**, que se usan con el nombre de la clase sin crear objetos:

```java
NombreClase.metodo(argumentos)
```

Todos los ejemplos de este apartado están en el paquete [`ut03.usocomun`](ejemplos/src/ut03/usocomun): [`ClasesDeUsoComun.java`](ejemplos/src/ut03/usocomun/ClasesDeUsoComun.java), [`EjemplosStringBuilder.java`](ejemplos/src/ut03/usocomun/EjemplosStringBuilder.java), [`EjemplosFechas.java`](ejemplos/src/ut03/usocomun/EjemplosFechas.java) y [`EntradaTeclado.java`](ejemplos/src/ut03/usocomun/EntradaTeclado.java).

## 6.1. Clases *wrapper* (envoltorio)

Los tipos primitivos (`int`, `double`…) no son objetos. Algunas estructuras, como las colecciones, solo trabajan con objetos. Por eso cada tipo primitivo tiene su **clase *wrapper*** (envoltorio), que "envuelve" el valor en un objeto:

| Primitivo | *Wrapper* |
|---|---|
| `byte` | `Byte` |
| `short` | `Short` |
| `int` | `Integer` |
| `long` | `Long` |
| `float` | `Float` |
| `double` | `Double` |
| `char` | `Character` |
| `boolean` | `Boolean` |

Las seis numéricas heredan de la clase abstracta `Number`; `Character` y `Boolean`, no.

### *Autoboxing* y *unboxing*

Java convierte automáticamente entre el primitivo y su *wrapper*:

```java
Integer edadObjeto = 18;      // autoboxing: int → Integer
int edad = edadObjeto;        // unboxing:   Integer → int
```

Para crear un *wrapper* de forma explícita se usa `valueOf`:

```java
Integer n = Integer.valueOf(56);
```

> [!WARNING]
> No uses `new Integer(56)`: los constructores de las clases *wrapper* están **obsoletos** desde Java 9 y marcados para su eliminación.

### Conversión entre texto y números

Es lo que más usarás, por ejemplo al leer datos como texto:

```java
int edad = Integer.parseInt("18");            // String → int
double precio = Double.parseDouble("12.5");   // String → double (con punto)
String texto = String.valueOf(edad);          // int → String
String otro = edadObjeto.toString();          // Integer → String
```

Si el texto no es un número válido, `parseInt` lanza una `NumberFormatException`.

### Constantes y métodos útiles

```java
Integer.MAX_VALUE              // 2147483647
Integer.MIN_VALUE              // -2147483648
Character.isDigit('7')         // true
Character.isLetter('a')        // true
Character.toUpperCase('a')     // 'A'
```

> [!WARNING]
> Los *wrappers* son objetos: compáralos con `equals`, no con `==`.
>
> ```java
> Integer a = 1000, b = 1000;
> System.out.println(a == b);        // false: dos objetos distintos
> System.out.println(a.equals(b));   // true
> ```
>
> Con valores entre −128 y 127, `==` puede devolver `true` porque Java reutiliza esos objetos. No te fíes: usa siempre `equals`.

## 6.2. La clase `String`

`String` representa cadenas de texto. Es especial: se puede crear con un literal (`"Hola"`), concatenar con `+`, y es **inmutable** (sus métodos devuelven una cadena nueva).

| Método | Qué hace | Ejemplo con `s = "Hola, mundo"` |
|---|---|---|
| `length()` | Número de caracteres | `11` |
| `charAt(i)` | Carácter de la posición `i` (empieza en 0) | `s.charAt(0)` → `'H'` |
| `equals(t)` / `equalsIgnoreCase(t)` | Compara el contenido | `s.equals("hola, mundo")` → `false` |
| `compareTo(t)` | Orden alfabético: negativo, 0 o positivo | `"a".compareTo("b")` → `-1` |
| `indexOf(t)` / `contains(t)` | Busca un texto | `s.indexOf("mundo")` → `6` |
| `substring(i, f)` | Subcadena de `i` a `f - 1` | `s.substring(0, 4)` → `"Hola"` |
| `toUpperCase()` / `toLowerCase()` | Mayúsculas / minúsculas | `"HOLA, MUNDO"` |
| `strip()` | Quita espacios al principio y al final | `"  a  ".strip()` → `"a"` |
| `split(sep)` | Divide en un array | `s.split(", ")` → `["Hola", "mundo"]` |
| `isEmpty()` / `isBlank()` | ¿Vacía? / ¿Solo espacios? | `"  ".isBlank()` → `true` |

Métodos **estáticos** de `String`:

```java
String.valueOf(3.5)                       // "3.5"
String.format("%.2f €", 12.5)             // "12,50 €" (en un equipo en español)
String.join("-", "a", "b", "c")           // "a-b-c"
```

## 6.3. La clase `StringBuilder`

Como `String` es inmutable, cada vez que "modificamos" una cadena se crea un objeto nuevo:

```java
String s = "Hola";
s = s + ", mundo";   // crea un String nuevo; el anterior queda sin referencias
```

En un bucle con muchas concatenaciones esto crea muchos objetos inútiles. Para construir o modificar texto paso a paso se usa **`StringBuilder`** (paquete `java.lang`), una cadena **mutable**: sus métodos modifican el **mismo objeto**.

```java
StringBuilder sb = new StringBuilder("Hola");
sb.append(", mundo");                 // Hola, mundo
sb.append('!');                       // Hola, mundo!
sb.insert(0, "¡");                    // ¡Hola, mundo!
sb.replace(1, 5, "Adiós");            // ¡Adiós, mundo!
sb.deleteCharAt(sb.length() - 1);     // ¡Adiós, mundo
sb.delete(0, 1);                      // Adiós, mundo
System.out.println(sb.length());      // 12

String resultado = sb.toString();     // cuando terminamos, lo pasamos a String
```

| Método | Qué hace |
|---|---|
| `append(x)` | Añade `x` al final (texto, número, carácter, booleano…) |
| `insert(i, x)` | Inserta `x` en la posición `i` |
| `delete(i, f)` | Borra los caracteres de `i` a `f - 1` |
| `deleteCharAt(i)` | Borra el carácter de la posición `i` |
| `replace(i, f, t)` | Sustituye los caracteres de `i` a `f - 1` por `t` |
| `reverse()` | Invierte el texto |
| `setCharAt(i, c)` | Cambia el carácter de la posición `i` |
| `length()`, `charAt(i)`, `indexOf(t)` | Igual que en `String` |
| `toString()` | Devuelve el contenido como `String` |

### Construir texto en un bucle

```java
StringBuilder linea = new StringBuilder();
for (int i = 1; i <= 5; i++) {
    linea.append(i);
    if (i < 5) {
        linea.append(" - ");
    }
}
System.out.println(linea);   // 1 - 2 - 3 - 4 - 5
```

### Encadenar llamadas

`append`, `insert`, `delete`, `reverse`… devuelven el propio `StringBuilder`, así que se pueden encadenar:

```java
String saludo = new StringBuilder()
        .append("Hola, ")
        .append("Ana")
        .append(". Tienes ")
        .append(18)
        .append(" años.")
        .toString();          // Hola, Ana. Tienes 18 años.

// ¿Es un palíndromo?
String palabra = "reconocer";
boolean palindromo = palabra.equals(new StringBuilder(palabra).reverse().toString());   // true
```

> [!WARNING]
> `StringBuilder` **no sobrescribe `equals`**: compara referencias, como `==`. Para comparar el contenido, conviértelo a `String` o usa `compareTo` (Java 11+):
>
> ```java
> StringBuilder a = new StringBuilder("hola");
> StringBuilder b = new StringBuilder("hola");
> System.out.println(a.equals(b));                         // false
> System.out.println(a.toString().equals(b.toString()));   // true
> System.out.println(a.compareTo(b) == 0);                 // true
> ```

> [!TIP]
> **¿`String` o `StringBuilder`?** Para guardar y comparar textos, usa `String`. Para construir un texto en varios pasos, sobre todo dentro de un bucle, usa `StringBuilder` y conviértelo a `String` al final. Existe también `StringBuffer`, que funciona igual pero está pensado para programas con varios hilos; en esta unidad usaremos `StringBuilder`.

Ejemplos completos: [`EjemplosStringBuilder.java`](ejemplos/src/ut03/usocomun/EjemplosStringBuilder.java).

## 6.4. La clase `Math`

`Math` agrupa constantes y funciones matemáticas. **Todos sus miembros son estáticos** y no se pueden crear objetos `Math`.

| Miembro | Qué hace | Ejemplo |
|---|---|---|
| `Math.PI`, `Math.E` | Constantes | `3.141592653589793` |
| `abs(x)` | Valor absoluto | `Math.abs(-4)` → `4` |
| `max(a, b)`, `min(a, b)` | Máximo y mínimo | `Math.max(4, 9)` → `9` |
| `pow(b, e)` | Potencia (devuelve `double`) | `Math.pow(2, 10)` → `1024.0` |
| `sqrt(x)` | Raíz cuadrada | `Math.sqrt(81)` → `9.0` |
| `round(x)` | Redondeo al entero más cercano | `Math.round(4.5)` → `5` |
| `floor(x)`, `ceil(x)` | Redondeo hacia abajo / hacia arriba | `Math.ceil(4.1)` → `5.0` |
| `random()` | `double` aleatorio en [0, 1) | `(int) (Math.random() * 6) + 1` → dado de 1 a 6 |

Redondear un precio a dos decimales:

```java
double total = Math.round(precio * 100) / 100.0;
```

## 6.5. La clase `LocalDate`

`LocalDate` (paquete `java.time`) representa una **fecha sin hora**: un día concreto, como el 3 de noviembre de 2026.

Sus objetos son **inmutables**, igual que los `String`: los métodos que "cambian" la fecha devuelven una fecha nueva.

> [!NOTE]
> En el mismo paquete están `LocalTime` (hora sin fecha) y `LocalDateTime` (fecha y hora), que funcionan de forma muy parecida. Evita las clases antiguas `Date` y `Calendar`, más difíciles de usar y propensas a errores.

### Crear fechas

`LocalDate` no tiene constructores públicos: las fechas se crean con **métodos estáticos**.

```java
import java.time.LocalDate;

LocalDate hoy = LocalDate.now();                     // la fecha actual del sistema
LocalDate fecha = LocalDate.of(2026, 11, 3);         // año, mes (1-12) y día
LocalDate examen = LocalDate.parse("2026-12-15");    // texto en formato ISO: aaaa-mm-dd
System.out.println(fecha);                           // 2026-11-03
```

Los meses van del **1 al 12**. Una fecha imposible, como `LocalDate.of(2026, 2, 30)`, lanza una `DateTimeException`.

En los ejemplos siguientes, `hoy` es el 3 de noviembre de 2026.

### Consultar sus partes

| Método | Devuelve | Ejemplo |
|---|---|---|
| `getYear()` | El año | `2026` |
| `getMonthValue()` | El mes como número | `11` |
| `getMonth()` | El mes (tipo `Month`) | `NOVEMBER` |
| `getDayOfMonth()` | El día del mes | `3` |
| `getDayOfWeek()` | El día de la semana (tipo `DayOfWeek`) | `TUESDAY` |
| `getDayOfYear()` | El día del año | `307` |
| `lengthOfMonth()` | Los días que tiene ese mes | `30` |
| `isLeapYear()` | Si el año es bisiesto | `false` |

Para obtener el nombre del día o del mes en español:

```java
Locale es = Locale.of("es", "ES");
hoy.getDayOfWeek().getDisplayName(TextStyle.FULL, es)   // "martes"
hoy.getMonth().getDisplayName(TextStyle.FULL, es)       // "noviembre"
```

### Sumar y restar

```java
hoy.plusDays(30)       // 2026-12-03
hoy.plusWeeks(1)       // 2026-11-10
hoy.minusMonths(2)     // 2026-09-03
hoy.plusYears(1)       // 2027-11-03
LocalDate.of(2026, 1, 31).plusMonths(1)   // 2026-02-28: se ajusta al último día del mes
```

> [!WARNING]
> Como `LocalDate` es inmutable, `hoy.plusDays(1);` **no cambia** `hoy`: devuelve una fecha nueva que hay que guardar.
>
> ```java
> hoy.plusDays(1);           // no sirve de nada
> hoy = hoy.plusDays(1);     // correcto
> ```

### Comparar fechas

```java
hoy.isBefore(examen)                      // true
hoy.isAfter(examen)                       // false
hoy.equals(LocalDate.of(2026, 11, 3))     // true
hoy.getDayOfWeek() == DayOfWeek.TUESDAY   // true
```

`LocalDate` sí sobrescribe `equals`, así que dos fechas con el mismo día son iguales aunque sean objetos distintos.

### Diferencia entre dos fechas

```java
import java.time.Period;
import java.time.temporal.ChronoUnit;

long dias = ChronoUnit.DAYS.between(hoy, examen);    // 42 días en total

Period p = Period.between(hoy, examen);              // en años, meses y días
System.out.println(p.getMonths() + " mes y " + p.getDays() + " días");   // 1 mes y 12 días

LocalDate nacimiento = LocalDate.of(2008, 5, 20);
int edad = Period.between(nacimiento, hoy).getYears();                   // 18
```

### De fecha a texto y de texto a fecha

`DateTimeFormatter` (paquete `java.time.format`) permite elegir el formato:

```java
DateTimeFormatter corto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
hoy.format(corto)                                    // "03/11/2026"
LocalDate.parse("25/12/2026", corto)                 // 2026-12-25

DateTimeFormatter largo = DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM 'de' yyyy", Locale.of("es", "ES"));
hoy.format(largo)                                    // "martes, 3 de noviembre de 2026"
```

| Letra | Significado | Ejemplo |
|---|---|---|
| `d` / `dd` | Día del mes | `3` / `03` |
| `M` / `MM` / `MMMM` | Mes | `11` / `11` / `noviembre` |
| `yyyy` / `uuuu` | Año | `2026` |
| `EEEE` | Nombre del día de la semana | `martes` |

Si el texto no tiene el formato indicado, `parse` lanza una `DateTimeParseException`.

> [!WARNING]
> Por defecto, `parse` **ajusta** los días que no existen sin avisar: `LocalDate.parse("31/02/2026", corto)` devuelve el 28 de febrero. Para validar fechas que escribe el usuario, usa un formato estricto (con `uuuu` para el año):
>
> ```java
> DateTimeFormatter estricto = DateTimeFormatter.ofPattern("dd/MM/uuuu")
>         .withResolverStyle(ResolverStyle.STRICT);
> LocalDate.parse("31/02/2026", estricto);   // DateTimeParseException
> LocalDate.parse("29/02/2028", estricto);   // 2028-02-29 (2028 es bisiesto)
> ```

Ejemplos completos: [`EjemplosFechas.java`](ejemplos/src/ut03/usocomun/EjemplosFechas.java).

## 6.6. Otras clases con métodos estáticos útiles

```java
java.util.Arrays.toString(v)          // muestra un array: [1, 2, 3]
java.util.Arrays.sort(v)              // ordena un array
System.currentTimeMillis()            // milisegundos desde 1970
```

## 6.7. Entrada y salida estándar

Todo programa Java tiene tres flujos estándar, que son atributos estáticos de la clase `System`:

| Flujo | Qué es | Clase |
|---|---|---|
| `System.out` | Salida estándar (la consola) | `PrintStream` |
| `System.err` | Salida de errores (en Eclipse, en rojo) | `PrintStream` |
| `System.in` | Entrada estándar (el teclado) | `InputStream` |

### Salida: `print`, `println` y `printf`

```java
System.out.print("Sin salto de línea. ");
System.out.println("Con salto de línea.");
System.out.printf("%s tiene %d años y un %.1f%n", "Ana", 18, 7.45);
// Ana tiene 18 años y un 7,5   (en un equipo en español)
```

Formatos más usados en `printf` y `String.format`:

| Formato | Para |
|---|---|
| `%d` | Enteros |
| `%f`, `%.2f` | Decimales (con 2 decimales) |
| `%s` | Cadenas (y cualquier objeto, usando su `toString`) |
| `%c` | Caracteres |
| `%n` | Salto de línea |

### Entrada: la clase `Scanner`

`java.util.Scanner` lee del teclado y convierte lo leído al tipo que necesitamos.

```java
import java.util.Scanner;

public class EntradaTeclado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Nota: ");
        while (!sc.hasNextDouble()) {          // ¿lo escrito es un número?
            System.out.print("Eso no es un número. Nota: ");
            sc.next();                         // descartamos lo escrito
        }
        double nota = sc.nextDouble();
        sc.nextLine();                         // consumimos el salto de línea

        System.out.printf("%s tiene un %.1f%n", nombre, nota);
    }
}
```

| Método | Lee |
|---|---|
| `nextLine()` | La línea completa, como `String` |
| `next()` | La siguiente palabra |
| `nextInt()`, `nextDouble()`, `nextBoolean()` | Un valor del tipo indicado |
| `hasNextInt()`, `hasNextDouble()`… | Comprueban, sin leer, si el siguiente dato es de ese tipo |

> [!WARNING]
> **Tres errores muy frecuentes con `Scanner`:**
> 1. Después de `nextInt()` o `nextDouble()`, el salto de línea queda pendiente y el siguiente `nextLine()` devuelve una cadena vacía. Solución: añade un `sc.nextLine()` extra.
> 2. `nextDouble()` usa la configuración del sistema: en un equipo en español espera **coma** decimal (`7,5`), no punto.
> 3. Crea **un único** `Scanner` sobre `System.in` para todo el programa y no lo cierres: al cerrarlo se cierra también el teclado.

### Entrada con `BufferedReader`

Es una forma más antigua de leer líneas. Solo lee texto, así que los números se convierten con los *wrappers*. Su método `readLine()` puede lanzar una `IOException`, que hay que tratar o declarar con `throws`:

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(br.readLine());
```

> [!NOTE]
> Desde Java 25 existe también la clase `java.lang.IO`, con métodos como `IO.println(...)` o `IO.readln("Mensaje: ")`, pensada para programas sencillos.

---

## Para practicar

1. Pide al usuario su nombre completo y muéstralo en mayúsculas, junto con su número de letras (sin contar los espacios exteriores).
2. Pide dos números enteros por teclado y muestra el mayor, la potencia del primero elevado al segundo y la raíz cuadrada del primero con dos decimales. Si el usuario escribe algo que no es un número, vuelve a pedírselo.
3. Simula el lanzamiento de dos dados con `Math.random()` y muestra la suma.
4. Pide una palabra y, usando `StringBuilder`, muéstrala al revés y con un guion entre cada letra (`hola` → `a-l-o-h`). Indica también si es un palíndromo.
5. Pide al usuario su fecha de nacimiento con el formato `dd/MM/aaaa` (vuelve a pedirla si no es válida) y muestra:
   - su edad;
   - el día de la semana en que nació, en español;
   - cuántos días faltan para su próximo cumpleaños.

   <details>
   <summary>Pista para el ejercicio 5</summary>

   Para el próximo cumpleaños, cambia el año de la fecha de nacimiento por el actual con `nacimiento.withYear(hoy.getYear())`. Si esa fecha ya ha pasado, súmale un año. Después calcula la diferencia con `ChronoUnit.DAYS.between`.
   </details>

---

[← 5. Modificadores y la clase `Object`](05-modificadores-y-object.md) · [Índice](README.md) · Siguiente: [7. Memoria y entorno de desarrollo →](07-memoria-y-entorno.md)
