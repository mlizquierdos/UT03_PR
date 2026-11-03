# UT03 · Utilización de objetos

**Módulo:** Programación · **Curso:** 1.º DAM · **Lenguaje:** Java

En esta unidad empezamos a trabajar con **objetos**: aprenderás a crearlos a partir de clases, a usar sus métodos y propiedades, a utilizar las clases que ya trae Java (`String`, `Math`, `Scanner`, las clases *wrapper*…) y a escribir tus primeras clases propias.

> [!NOTE]
> La herencia, el polimorfismo, las clases abstractas y las interfaces (apartado 4) se presentan aquí solo de forma **básica**. Los estudiaremos a fondo en unidades posteriores.

## Qué vas a aprender

- Qué es un objeto: estado, comportamiento e identidad.
- Qué es una clase y cómo se crean objetos a partir de ella (instanciación).
- Cómo se declaran atributos, métodos y constructores.
- Cómo se usan los métodos: parámetros, argumentos y valores devueltos.
- Cómo se consultan y modifican las propiedades de un objeto (*getters* y *setters*).
- Cómo se usan los métodos estáticos de las clases predefinidas.
- Cómo se utilizan las clases *wrapper*, `String`, `StringBuilder`, `Math`, `LocalDate` y las clases de entrada/salida estándar.
- Cómo se destruyen los objetos y se libera la memoria.
- Cómo se crea, compila y ejecuta una aplicación con un IDE.

## Contenidos

| N.º | Documento | Contenido |
|---|---|---|
| 1 | [Clases y objetos](01-clases-y-objetos.md) | Objetos, clases, instanciación y referencias |
| 2 | [Miembros de una clase](02-miembros-de-una-clase.md) | Atributos, métodos, parámetros, constructores, `static` y paquetes |
| 3 | [Métodos especiales](03-metodos-especiales.md) | *Getters* y *setters*, `toString`, `equals` y `hashCode` |
| 4 | [Relaciones entre clases (introducción)](04-relaciones-entre-clases.md) | Composición, herencia, polimorfismo, clases abstractas e interfaces |
| 5 | [Modificadores y la clase `Object`](05-modificadores-y-object.md) | Visibilidad, `final`, `static`, `abstract` y métodos de `Object` |
| 6 | [Clases de uso común](06-clases-de-uso-comun.md) | *Wrappers*, `String`, `StringBuilder`, `Math`, `LocalDate`, `Scanner` y `System.out` |
| 7 | [Memoria y entorno de desarrollo](07-memoria-y-entorno.md) | *Garbage collector*, compilación y ejecución, Eclipse |
| 8 | [Práctica: tienda online](08-practica.md) | Práctica final de la unidad |
| 9 | [Autoevaluación](09-autoevaluacion.md) | Test con soluciones |

Te recomendamos seguirlos en orden. Al final de cada documento hay ejercicios **Para practicar**.

## Ejemplos de código

Todos los ejemplos que aparecen en los documentos están completos en la carpeta [`ejemplos/src`](ejemplos/src), organizados por paquetes:

| Paquete | Ejemplos |
|---|---|
| [`ut03.objetos`](ejemplos/src/ut03/objetos) | `Bombilla`, `PruebaBombilla` |
| [`ut03.miembros`](ejemplos/src/ut03/miembros) | `Alumno`, `PruebaAlumno`, `PasoDeParametros` |
| [`ut03.relaciones`](ejemplos/src/ut03/relaciones) | `Empleado`, `Departamento`, `Figura`, `Circulo`, `Rectangulo`, `Dibujable`… |
| [`ut03.usocomun`](ejemplos/src/ut03/usocomun) | `ClasesDeUsoComun`, `EjemplosStringBuilder`, `EjemplosFechas`, `EntradaTeclado` |

### Cómo abrirlos en Eclipse

1. Clona este repositorio (o descárgalo como ZIP).
2. En Eclipse: *File → New → Java Project*, desmarca *Use default location* y elige la carpeta `ejemplos`. Si el asistente ofrece crear `module-info.java`, no lo crees.
3. Abre cualquier clase que tenga `main` y ejecútala con *Run → Run As → Java Application*.

Necesitas un JDK 21 o posterior (se recomienda una versión LTS: 21 o 25).

## Recursos para ampliar

**Documentación oficial**

- [Dev.java: Classes and Objects](https://dev.java/learn/language/oop/classes-objects/): tutorial oficial de Oracle sobre clases, objetos y constructores (inglés).
- [Dev.java: Inheritance](https://dev.java/learn/language/oop/inheritance/) e [Interfaces](https://dev.java/learn/language/oop/interfaces/): para ampliar el apartado 4 (inglés).
- [Dev.java: Packages](https://dev.java/learn/language/oop/packages/): paquetes e `import` (inglés).
- [Dev.java: Using IDEs](https://dev.java/learn/first-steps/using-ides/): tu primer programa con un IDE (inglés).
- [API de Java SE 25](https://docs.oracle.com/en/java/javase/25/docs/api/index.html): documentación de `String`, `Math`, `Integer`, `Scanner`… (inglés).
- [Eclipse: Creating your first Java project](https://help.eclipse.org/latest/topic/org.eclipse.jdt.doc.user/gettingStarted/qs-3.htm): guía oficial del IDE (inglés).

**Artículos y cursos**

- [Baeldung: equals() and hashCode() contracts](https://www.baeldung.com/java-equals-hashcode-contracts) (inglés).
- [Baeldung: Wrapper classes in Java](https://www.baeldung.com/java-wrapper-classes) (inglés).
- [Java Programming (MOOC, Universidad de Helsinki)](https://java-programming.mooc.fi/): curso gratuito con ejercicios autocorregidos (inglés).
- [Wikilibros: Programación en Java](https://es.wikibooks.org/wiki/Programaci%C3%B3n_en_Java) (español).
