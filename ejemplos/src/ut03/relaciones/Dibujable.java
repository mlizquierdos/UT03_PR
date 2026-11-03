package ut03.relaciones;

/**
 * Contrato de los objetos que se pueden dibujar en pantalla.
 */
public interface Dibujable {

    /**
     * Devuelve una representación del objeto para dibujarlo.
     *
     * @return el dibujo en modo texto
     */
    String dibujar();
}
