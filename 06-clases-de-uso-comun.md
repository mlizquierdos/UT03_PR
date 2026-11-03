# 6. Clases de uso común

[← 5. Modificadores y la clase `Object`](05-modificadores-y-object.md) · [Índice](README.md) · Siguiente: [7. Memoria y entorno de desarrollo →](07-memoria-y-entorno.md)

---

Java incluye miles de clases ya programadas. No hay que escribirlas: basta con importarlas (si no están en `java.lang`) y consultar su documentación en la [API de Java](https://docs.oracle.com/en/java/javase/25/docs/api/index.html).

Muchas ofrecen **métodos estáticos**, que se usan con el nombre de la clase sin crear objetos:

```java
NombreClase.metodo(argumentos)
```

Todos los ejemplos de este apartado están en [`ClasesDeUsoComun.java`](ejemplos/src/ut03/usocomun/ClasesDeUsoComun.java) y [`EntradaTeclado.java`](ejemplos/src/ut03/usocomun/EntradaTeclado.java).

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

## 6.3. La clase `Math`

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

## 6.4. Otras clases con métodos estáticos útiles

```java
java.util.Arrays.toString(v)          // muestra un array: [1, 2, 3]
java.util.Arrays.sort(v)              // ordena un array
java.time.LocalDate.now()             // fecha de hoy
java.time.LocalDate.of(2026, 11, 3)   // una fecha concreta
System.currentTimeMillis()            // milisegundos desde 1970
```

## 6.5. Entrada y salida estándar

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

---

[← 5. Modificadores y la clase `Object`](05-modificadores-y-object.md) · [Índice](README.md) · Siguiente: [7. Memoria y entorno de desarrollo →](07-memoria-y-entorno.md)
