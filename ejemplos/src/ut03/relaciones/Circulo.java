package ut03.relaciones;

/**
 * Círculo: una figura con radio.
 */
public class Circulo extends Figura {

    private double radio;

    /**
     * Crea un círculo.
     *
     * @param radio radio del círculo
     */
    public Circulo(double radio) {
        super("Círculo");   // primera sentencia: constructor de Figura
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public String dibujar() {
        return "( )";
    }
}
