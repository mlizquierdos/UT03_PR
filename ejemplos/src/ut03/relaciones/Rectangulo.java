package ut03.relaciones;

/**
 * Rectángulo: una figura con base y altura.
 */
public class Rectangulo extends Figura {

    private double base;
    private double altura;

    /**
     * Crea un rectángulo.
     *
     * @param base   base del rectángulo
     * @param altura altura del rectángulo
     */
    public Rectangulo(double base, double altura) {
        super("Rectángulo");
        this.base = base;
        this.altura = altura;
    }

    /**
     * Devuelve la base del rectángulo.
     *
     * @return la base
     */
    public double getBase() {
        return base;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public String dibujar() {
        return "[ ]";
    }
}
