# 9. Autoevaluación

[← 8. Práctica](08-practica.md) · [Índice](README.md)

---

Responde a cada pregunta **antes** de abrir la solución. Al final tienes una tabla para valorar tu resultado.

## Parte A. Preguntas de test

**1.** ¿Qué es una clase?

- a) Un objeto concreto que existe mientras se ejecuta el programa.
- b) Una plantilla que define los atributos y los métodos que tendrán sus objetos.
- c) Una variable que guarda varios valores.
- d) Un método especial que crea objetos.

<details><summary>Solución</summary>

**b)** La clase es el molde; los objetos son los ejemplares creados a partir de ella.
</details>

**2.** El estado de un objeto es…

- a) El conjunto de sus métodos.
- b) El nombre de su clase.
- c) Los valores que tienen sus atributos en un momento dado.
- d) La dirección de memoria en la que está guardado.

<details><summary>Solución</summary>

**c)** El estado cambia cuando cambian los valores de sus atributos.
</details>

**3.** ¿Qué contiene una variable de tipo objeto, como `Bombilla b = new Bombilla(60);`?

- a) El objeto completo, con todos sus atributos.
- b) Una referencia al objeto, que está en el *heap*.
- c) Una copia de la clase `Bombilla`.
- d) El valor 60.

<details><summary>Solución</summary>

**b)** Por eso, al hacer `Bombilla otra = b;`, no se copia el objeto: las dos variables apuntan al mismo.
</details>

**4.** Dentro de un `main` escribimos `Bombilla b;` y en la línea siguiente `b.encender();`. ¿Qué ocurre?

- a) Se lanza una `NullPointerException` al ejecutar.
- b) Se crea una bombilla apagada y se enciende.
- c) No compila: la variable local `b` no se ha inicializado.
- d) No ocurre nada.

<details><summary>Solución</summary>

**c)** Las variables locales no tienen valor por defecto. Si hubiéramos escrito `Bombilla b = null;`, sí compilaría, pero lanzaría una `NullPointerException` al ejecutarse.
</details>

**5.** ¿Cuál es la signatura del método `public static double media(int a, int b)`?

- a) `public static double media(int a, int b)`
- b) `double media(int, int)`
- c) `media(int, int)`
- d) `media(a, b)`

<details><summary>Solución</summary>

**c)** La signatura es el nombre y los tipos de los parámetros. Lo demás forma parte de la cabecera.
</details>

**6.** ¿Cuál de estas afirmaciones sobre los constructores es **falsa**?

- a) Se llaman igual que la clase.
- b) Su tipo devuelto es `void`.
- c) Se ejecutan al crear un objeto con `new`.
- d) Puede haber varios en una misma clase.

<details><summary>Solución</summary>

**b)** Los constructores no tienen tipo devuelto, ni siquiera `void`. Si escribes `public void Alumno()`, Java lo interpreta como un método normal, no como un constructor.
</details>

**7.** La clase `Punto` solo tiene el constructor `Punto(int x, int y)`. ¿Qué ocurre con `new Punto()`?

- a) Se crea un punto en (0, 0).
- b) No compila: al haber un constructor, Java ya no añade el constructor por defecto.
- c) Se crea un punto con valores aleatorios.
- d) Se lanza una excepción al ejecutar.

<details><summary>Solución</summary>

**b)** Si quieres crear puntos sin parámetros, tienes que escribir tú el constructor `Punto()`.
</details>

**8.** ¿Qué es `this`?

- a) Una referencia a la clase.
- b) Una referencia al objeto actual, sobre el que se ejecuta el método o constructor.
- c) Una palabra que solo se usa en los *setters*.
- d) Una referencia a la superclase.

<details><summary>Solución</summary>

**b)** Por eso no se puede usar en un método `static`: no hay objeto actual. La referencia a la superclase es `super`.
</details>

**9.** Un atributo `static`…

- a) No puede cambiar de valor.
- b) Tiene una copia distinta en cada objeto.
- c) Tiene una sola copia, compartida por todos los objetos de la clase.
- d) Solo se puede usar dentro de un método `static`.

<details><summary>Solución</summary>

**c)** Si además fuera `final`, sería una constante. Lo que impide cambiar el valor es `final`, no `static`.
</details>

**10.** En Java, el paso de parámetros es…

- a) Siempre por referencia.
- b) Por valor para los primitivos y por referencia para los objetos.
- c) Siempre por valor; con los objetos se copia la referencia.
- d) Depende de si el parámetro es `final`.

<details><summary>Solución</summary>

**c)** Con un objeto, el método recibe una copia de la referencia: puede modificar el estado del objeto, pero si asigna otro objeto al parámetro, la variable original no cambia.
</details>

**11.** ¿Por qué los atributos suelen ser `private` y se modifican con *setters*?

- a) Porque así el programa es más rápido.
- b) Porque Java obliga a ello.
- c) Para que la clase controle los valores y el objeto nunca quede en un estado incorrecto.
- d) Para poder usarlos desde métodos `static`.

<details><summary>Solución</summary>

**c)** Es la idea de la **encapsulación**: el *setter* puede validar el valor antes de aceptarlo.
</details>

**12.** Para comprobar si el texto de dos `String` es igual se usa…

- a) `==`
- b) `equals`
- c) `compareTo` siempre
- d) `hashCode`

<details><summary>Solución</summary>

**b)** `==` compara referencias: si las dos variables apuntan al mismo objeto.
</details>

**13.** Si sobrescribes `equals` en una clase…

- a) No hace falta nada más.
- b) Debes sobrescribir también `hashCode`, usando los mismos atributos.
- c) Debes borrar `toString`.
- d) Debes declarar la clase `final`.

<details><summary>Solución</summary>

**b)** Dos objetos iguales según `equals` deben tener el mismo `hashCode`; si no, `HashSet` y `HashMap` funcionarán mal.
</details>

**14.** ¿Para qué sirve `@Override`?

- a) Para que el método sea más rápido.
- b) Para que el compilador compruebe que el método sobrescribe uno heredado.
- c) Para que el método no se pueda heredar.
- d) Es obligatorio en todos los métodos públicos.

<details><summary>Solución</summary>

**b)** Si te equivocas al escribir el nombre (`toStrng`), el compilador da un error en lugar de crear un método nuevo sin avisar.
</details>

**15.** ¿Cuál es la forma recomendada de crear un `Integer` con valor 56?

- a) `Integer n = new Integer(56);`
- b) `Integer n = Integer.valueOf(56);` o `Integer n = 56;`
- c) `Integer n = Integer.parseInt(56);`
- d) `Integer n = (Integer) "56";`

<details><summary>Solución</summary>

**b)** Los constructores de las clases *wrapper* están obsoletos. `Integer n = 56;` usa *autoboxing*.
</details>

**16.** ¿Qué ocurre con `Integer.parseInt("12a")`?

- a) Devuelve 12.
- b) Devuelve 0.
- c) Lanza una `NumberFormatException`.
- d) No compila.

<details><summary>Solución</summary>

**c)** Compila, porque el argumento es un `String`, pero falla al ejecutar porque el texto no es un número válido.
</details>

**17.** Tras leer un número con `sc.nextInt()`, llamamos a `sc.nextLine()`. ¿Qué devuelve normalmente?

- a) La siguiente línea que escriba el usuario.
- b) Una cadena vacía, porque consume el salto de línea que quedó pendiente.
- c) El mismo número, como texto.
- d) `null`.

<details><summary>Solución</summary>

**b)** Por eso, después de `nextInt()` o `nextDouble()`, se añade un `sc.nextLine()` extra antes de leer texto.
</details>

**18.** ¿Cuándo puede el *garbage collector* eliminar un objeto?

- a) Cuando el programador llama a `System.gc()`.
- b) Cuando se termina el `main`, nunca antes.
- c) Cuando ya no queda ninguna referencia a él.
- d) Cuando se llama a su método `finalize()`.

<details><summary>Solución</summary>

**c)** `System.gc()` solo sugiere a la JVM que se ejecute, y `finalize()` está obsoleto.
</details>

**19.** Un `Empleado` crea su propia `Direccion` en el constructor, y la dirección no tiene sentido sin el empleado. ¿Qué relación es?

- a) Herencia.
- b) Agregación.
- c) Composición.
- d) Polimorfismo.

<details><summary>Solución</summary>

**c)** En la agregación, el objeto contenido se recibe desde fuera y puede existir por sí mismo.
</details>

**20.** `Figura` es una clase abstracta. ¿Qué línea **no** compila?

- a) `Figura f = new Circulo(2);`
- b) `Figura f = new Figura("X");`
- c) `Figura f = null;`
- d) `Circulo c = new Circulo(2);`

<details><summary>Solución</summary>

**b)** No se pueden crear objetos de una clase abstracta, pero sí declarar variables de su tipo y asignarles objetos de sus subclases.
</details>

## Parte B. ¿Qué imprime?

Razona la respuesta y después compruébala en Eclipse.

**21.**

```java
String s = "java";
s.toUpperCase();
System.out.println(s);
```

<details><summary>Solución</summary>

```
java
```

`String` es inmutable: `toUpperCase()` devuelve una cadena nueva, pero no la hemos guardado. Habría que escribir `s = s.toUpperCase();`.
</details>

**22.**

```java
Integer a = 100, b = 100;
Integer c = 200, d = 200;
System.out.println((a == b) + " " + (c == d) + " " + c.equals(d));
```

<details><summary>Solución</summary>

```
true false true
```

Java reutiliza los objetos `Integer` entre −128 y 127, así que `a` y `b` son el mismo objeto; `c` y `d`, no. Por eso los *wrappers* se comparan siempre con `equals`.
</details>

**23.**

```java
class Contador {
    static int total = 0;
    int propio = 0;

    Contador() {
        total++;
        propio++;
    }
}

// En el main:
Contador x = new Contador();
Contador y = new Contador();
System.out.println(Contador.total + " " + y.propio);
```

<details><summary>Solución</summary>

```
2 1
```

`total` es estático: hay una sola copia, que se incrementa con cada objeto. `propio` es de instancia: cada contador tiene el suyo.
</details>

**24.** Usando la clase [`Alumno`](ejemplos/src/ut03/miembros/Alumno.java):

```java
static void renombrar(Alumno a) {
    a.setNombre("Zoe");
    a = new Alumno("2", "Leo");
    a.setNombre("Max");
}

// En el main:
Alumno al = new Alumno("1", "Ana");
renombrar(al);
System.out.println(al.getNombre());
```

<details><summary>Solución</summary>

```
Zoe
```

El método recibe una copia de la referencia. La primera línea cambia el objeto original. Después, `a` pasa a apuntar a un objeto nuevo, y los cambios siguientes ya no afectan a `al`.
</details>

**25.** Usando las clases de [`ut03.relaciones`](ejemplos/src/ut03/relaciones):

```java
Figura f = new Rectangulo(2, 5);
System.out.println(f.calcularArea() + " " + f.getNombre());
```

<details><summary>Solución</summary>

```
10.0 Rectángulo
```

La variable es de tipo `Figura`, pero el objeto es un `Rectangulo`: se ejecuta su versión de `calcularArea()` (polimorfismo). `getNombre()` se hereda de `Figura`.
</details>

## ¿Cómo lo has hecho?

Cuenta un punto por cada respuesta correcta (25 en total).

| Aciertos | Valoración |
|---|---|
| 23–25 | ¡Muy bien! Dominas los contenidos de la unidad. |
| 18–22 | Bien. Repasa los apartados de las preguntas que has fallado. |
| 13–17 | Necesitas repasar. Vuelve a los ejemplos y haz los ejercicios **Para practicar**. |
| Menos de 13 | Repasa la unidad desde el principio y consulta tus dudas en clase. |

---

[← 8. Práctica](08-practica.md) · [Índice](README.md)
