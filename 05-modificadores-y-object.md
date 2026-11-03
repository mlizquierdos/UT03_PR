# 5. Modificadores y la clase `Object`

[← 4. Relaciones entre clases](04-relaciones-entre-clases.md) · [Índice](README.md) · Siguiente: [6. Clases de uso común →](06-clases-de-uso-comun.md)

---

## 5.1. Modificadores

### Modificadores de acceso

Controlan **desde dónde** se puede usar una clase o uno de sus miembros. Son la herramienta de la **encapsulación**.

| Modificador | Misma clase | Mismo paquete | Subclase de otro paquete | Cualquier clase |
|---|:---:|:---:|:---:|:---:|
| `private` | ✅ | ❌ | ❌ | ❌ |
| *(sin modificador)* o "de paquete" | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

De más a menos restrictivo: `private` → de paquete → `protected` → `public`.

**Regla práctica para esta unidad:**

- Atributos: `private`.
- Métodos que forman parte del uso de la clase: `public`.
- Métodos auxiliares que solo usa la propia clase: `private`.
- Constantes: `public static final`.

> [!IMPORTANT]
> El modificador de acceso no tiene nada que ver con tener que crear un objeto. Lo que obliga a tener un objeto es que el miembro sea **de instancia** (no `static`), sea cual sea su visibilidad.

### Modificadores de las clases

Una clase de primer nivel solo puede ser `public` o de paquete (sin modificador).

- Un fichero `.java` puede contener **como máximo una** clase `public`, y el fichero debe llamarse igual que ella.

Otros modificadores de clase:

| Modificador | Significado |
|---|---|
| `final` | La clase no se puede extender (no puede tener subclases). Ejemplo: `String`. |
| `abstract` | La clase no se puede instanciar ([apartado 4.4](04-relaciones-entre-clases.md#44-clases-abstractas)). |

Una clase **no puede** ser `final` y `abstract` a la vez: una clase abstracta necesita subclases y una `final` no las permite.

### Otros modificadores de atributos y métodos

| Modificador | En un atributo | En un método |
|---|---|---|
| `static` | Hay una sola copia, compartida por toda la clase | Se llama con el nombre de la clase, sin objeto |
| `final` | Solo se le puede asignar un valor una vez | No se puede sobrescribir en una subclase |
| `abstract` | — | No tiene cuerpo; las subclases lo implementan |

Algunas reglas:

- Un atributo `final` debe recibir su valor en la declaración o en **todos** los constructores.
- Las **constantes** se declaran `public static final` y se escriben en `MAYÚSCULAS_CON_GUIONES`: `public static final double IVA = 0.21;`.
- Un método `abstract` no puede ser `private`, `static` ni `final`.

> [!NOTE]
> Existen otros modificadores, como `synchronized` (programación concurrente) o `transient` (serialización), que verás en otros módulos y unidades.

### Reglas de los constructores

- Se llaman exactamente igual que la clase.
- No tienen tipo devuelto, ni siquiera `void`.
- No pueden ser `static`, `final` ni `abstract`.
- Pueden tener cualquier modificador de acceso.
- No se heredan.
- Su primera sentencia puede ser `this(...)` o `super(...)`.

## 5.2. La clase `Object`

Todas las clases de Java heredan, directa o indirectamente, de la clase **`Object`** (paquete `java.lang`). Por eso cualquier objeto tiene estos métodos:

| Método | Qué hace | ¿Se suele sobrescribir? |
|---|---|---|
| `toString()` | Devuelve el objeto como texto | Sí ([3.2](03-metodos-especiales.md#32-tostring)) |
| `equals(Object obj)` | Indica si dos objetos son iguales; por defecto, igual que `==` | Sí ([3.3](03-metodos-especiales.md#33-equals)) |
| `hashCode()` | Devuelve un código *hash* del objeto | Sí, siempre junto con `equals` ([3.4](03-metodos-especiales.md#34-hashcode)) |
| `getClass()` | Devuelve la clase real del objeto en ejecución | No se puede (es `final`) |
| `clone()` | Crea una copia del objeto; es `protected` y exige implementar `Cloneable` | Poco habitual |
| `finalize()` | **Obsoleto**: no debe usarse | No |

```java
Object o = new Alumno("1001", "Ana", 7.5);   // cualquier objeto "es un" Object
System.out.println(o.getClass().getSimpleName());   // Alumno
```

---

## Para practicar

1. En la clase `Libro` del apartado anterior, ¿qué modificador pondrías a cada atributo, a los *getters*, a un método auxiliar `validarIsbn` y a una constante `PAGINAS_MINIMAS`?
2. ¿Compila esta clase? Si no, explica por qué.

   ```java
   public final abstract class Animal {
       public abstract void comer();
   }
   ```

   <details>
   <summary>Solución del ejercicio 2</summary>

   No compila: una clase no puede ser `final` y `abstract` a la vez. `abstract` obliga a tener subclases para poder usarla, y `final` las prohíbe.
   </details>

---

[← 4. Relaciones entre clases](04-relaciones-entre-clases.md) · [Índice](README.md) · Siguiente: [6. Clases de uso común →](06-clases-de-uso-comun.md)
