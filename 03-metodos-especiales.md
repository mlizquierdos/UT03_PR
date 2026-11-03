# 3. Métodos especiales

[← 2. Miembros de una clase](02-miembros-de-una-clase.md) · [Índice](README.md) · Siguiente: [4. Relaciones entre clases →](04-relaciones-entre-clases.md)

---

Casi todas las clases que escribas tendrán estos métodos. Eclipse los genera automáticamente desde el menú **Source**, pero debes entender qué hacen.

## 3.1. *Getters* y *setters*

Los atributos son `private`, así que desde fuera de la clase no se pueden leer ni cambiar directamente. Para ello existen:

- **Getters** (consultores): devuelven el valor de una propiedad. `getNombre()`.
- **Setters** (modificadores): cambian el valor de una propiedad. `setNombre(String nombre)`.

```java
public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}
```

```java
ana.setNombre("Ana García");          // modificamos una propiedad
System.out.println(ana.getNombre());  // la consultamos
```

**Convenios:**

- El nombre de la propiedad va detrás de `get`/`set`, con la primera letra en mayúscula.
- Para un atributo `boolean`, el *getter* empieza por `is`: `isEncendida()`.
- Una propiedad de **solo lectura** tiene *getter* pero no *setter* (por ejemplo, el NIA de un alumno, que no cambia).

### ¿Por qué no hacer públicos los atributos?

Porque el *setter* puede **comprobar el valor** antes de aceptarlo. Así el objeto nunca queda en un estado incorrecto:

```java
public void setNotaMedia(double notaMedia) {
    if (notaMedia < 0 || notaMedia > 10) {
        throw new IllegalArgumentException("La nota debe estar entre 0 y 10");
    }
    this.notaMedia = notaMedia;
}
```

Si el atributo fuera público, cualquiera podría escribir `ana.notaMedia = 15;` y nadie lo impediría. Esta idea de ocultar los atributos y dar acceso solo a través de métodos se llama **encapsulación**.

> [!NOTE]
> `throw new IllegalArgumentException(...)` detiene el método e informa del error. Las excepciones se estudian a fondo en otra unidad; de momento basta con saber que así se rechaza un valor incorrecto.

> [!TIP]
> No hace falta crear un *setter* para cada atributo. En [`Bombilla`](ejemplos/src/ut03/objetos/Bombilla.java) no hay `setEncendida`: el estado solo cambia con `encender()` y `apagar()`, que es más claro.

## 3.2. `toString`

Devuelve una representación en texto del objeto. Se llama automáticamente cuando imprimimos el objeto o lo concatenamos con `+`.

Si no lo escribimos, se usa la versión heredada de `Object`, que muestra el nombre de la clase y un código *hash*:

```
ut03.miembros.Alumno@15db9742
```

Si lo sobrescribimos:

```java
@Override
public String toString() {
    return "Alumno[nia=" + nia + ", nombre=" + nombre + ", notaMedia=" + notaMedia + "]";
}
```

```java
System.out.println(ana);   // Alumno[nia=1001, nombre=Ana, notaMedia=7.5]
```

> [!IMPORTANT]
> **`@Override`** indica que el método sobrescribe uno heredado, y el compilador lo comprueba. Si escribes `toStrng()` por error, con `@Override` obtienes un error de compilación; sin él, se crea un método nuevo que nadie llama y el fallo pasa desapercibido.

## 3.3. `equals`

Ya vimos que `==`, con objetos, compara **referencias**: si las dos variables apuntan al mismo objeto. Para comparar el **contenido** se usa `equals`.

```java
Alumno ana = new Alumno("1001", "Ana", 7.5);
Alumno anaOtraVez = new Alumno("1001", "Ana García", 7.5);

System.out.println(ana == anaOtraVez);        // false: dos objetos distintos
System.out.println(ana.equals(anaOtraVez));   // true: mismo NIA
```

> [!WARNING]
> Esto también se aplica a `String`: para comparar el texto de dos cadenas usa **siempre** `equals`, nunca `==`.
> ```java
> if (respuesta.equals("sí")) { ... }   // correcto
> if (respuesta == "sí") { ... }        // incorrecto: compara referencias
> ```

La versión de `equals` heredada de `Object` se comporta igual que `==`. Para que compare el contenido hay que sobrescribirla. Somos nosotros quienes decidimos qué significa que dos objetos sean iguales: dos alumnos son el mismo si tienen el mismo NIA, aunque el nombre esté escrito de otra forma.

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) {                                    // 1. ¿es el mismo objeto?
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {    // 2. ¿null o de otra clase?
        return false;
    }
    Alumno otro = (Alumno) obj;                           // 3. conversión
    return Objects.equals(nia, otro.nia);                 // 4. comparamos atributos
}
```

Para comparar los atributos:

- Los **primitivos** (`int`, `double`, `boolean`…) se comparan con `==`.
- Los **objetos** (`String`, `Alumno`…) se comparan con `Objects.equals(a, b)`, de `java.util`, que funciona aunque alguno sea `null`.

```java
return edad == otro.edad
        && Objects.equals(nombre, otro.nombre)
        && Objects.equals(email, otro.email);
```

## 3.4. `hashCode`

`hashCode()` devuelve un número entero que resume el objeto. Lo usan las estructuras *hash* (`HashSet`, `HashMap`) para buscar objetos rápidamente: primero comparan el `hashCode` y, solo si coincide, llaman a `equals`.

Por eso `equals` y `hashCode` deben ser **coherentes**:

- Si dos objetos son iguales según `equals`, deben tener el **mismo** `hashCode`.
- Dos objetos distintos pueden tener el mismo `hashCode` (se llama **colisión**), aunque conviene que ocurra poco.

La forma más sencilla es usar `Objects.hash` con **los mismos atributos** que se comparan en `equals`:

```java
@Override
public int hashCode() {
    return Objects.hash(nia);
}
```

> [!IMPORTANT]
> **Si sobrescribes `equals`, sobrescribe también `hashCode`.** Si no, dos objetos iguales tendrán normalmente códigos distintos y un `HashSet` los guardará como si fueran diferentes:
>
> ```java
> Set<Alumno> grupo = new HashSet<>();
> grupo.add(ana);
> grupo.add(anaOtraVez);
> System.out.println(grupo.size());   // 1 con hashCode; probablemente 2 sin él
> ```

Puedes ver todos estos métodos funcionando en [`PruebaAlumno.java`](ejemplos/src/ut03/miembros/PruebaAlumno.java).

> [!TIP]
> En Eclipse: *Source → Generate Getters and Setters…*, *Generate toString()…* y *Generate hashCode() and equals()…*. Úsalos cuando ya sepas escribirlos a mano, y revisa siempre lo que generan.

---

## Para practicar

1. Escribe una clase `Libro` con `isbn`, `titulo`, `autor` y `numPaginas`. El ISBN no puede cambiar (sin *setter*) y el número de páginas debe ser mayor que 0.
2. Añade `toString()`. Dos libros son iguales si tienen el mismo ISBN: escribe `equals()` y `hashCode()` en coherencia.
3. Crea dos objetos `Libro` con el mismo ISBN y distinto título. Comprueba qué devuelven `==` y `equals`, y añádelos a un `HashSet`. ¿Cuántos elementos tiene?

---

[← 2. Miembros de una clase](02-miembros-de-una-clase.md) · [Índice](README.md) · Siguiente: [4. Relaciones entre clases →](04-relaciones-entre-clases.md)
