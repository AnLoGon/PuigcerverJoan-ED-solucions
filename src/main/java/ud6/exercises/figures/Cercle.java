package ud6.exercises.figures;

/**
 * Representa un cercle en l'espai cartesià.
 * @author Joan Puigcerver
 * @version 1.0
 * @see ud6.examples.Rectangle
 */
public class Cercle {
    /**
     * Radi del cercle.
     */
    double radius;
    /**
     * Coordenada x del centre.
     */
    double x;
    /**
     * Coordenada y del centre.
     */
    double y;

    /**
     * Crea un cercle amb el radi i el centre especificats.
     * @param radius Radi del cercle.
     * @param x Coordenada x del centre.
     * @param y Coordenada y del centre.
     */
    public Cercle(double radius, double x, double y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    /**
     * Crea un cercle amb el radi especificats en el punt (0,0)
     * @param radius Radi del cercle
     */
    public Cercle(double radius) {
        this(radius, 0, 0);
    }

    /**
     * Obté el radi del cercle
     * @return El radi del cercle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Obté la coordenada x del centre del cercle
     * @return La coordenada x del centre del cercle
     */
    public double getX() {
        return x;
    }

    /**
     * Obté la coordenada y del centre del cercle
     * @return La coordenada y del centre del cercle
     */
    public double getY() {
        return y;
    }

    /**
     * Modifica el radi del cercle
     * @param radius El nou radi del cercle
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    /**
     * Modifica la coordenada x del centre del cercle
     * @param x La nova coordenada x del centre del cercle
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * Modifica la coordenada y del centre del cercle
     * @param y La nova coordenada y del centre del cercle
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Calcula l'area del cercle
     * @return L'area del cercle
     */
    public double area() {
        return Math.PI * radius * radius;
    }

    /**
     * Indica si un punt està dins del cercle
     * @param x Coordenada x del punt
     * @param y Coordenada y del punt
     * @return true si el punt està dins del cercle, false en cas contrari
     */
    public boolean contains(double x, double y) {
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2)) <= radius;
    }
}
