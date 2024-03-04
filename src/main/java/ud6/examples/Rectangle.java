package ud6.examples;

/**
 * Aquesta classe representa un Rectangle.
 *
 * @author Joan Puigcerver
 * @version 1.2 2022-12-12
 */
public class Rectangle {
    /**
     * Amplada del rectangle.
     */
    private int width;
    /**
     * Altura del rectangle.
     */
    private int height;
    /**
     * Posició del vèrtex de baix a l'esquerra en l'eix X
     */
    private int x;
    /**
     * Posició del vèrtex de baix a l'esquerra en l'eix Y
     */
    private int y;

    /**
     * Crea un Rectangle especificant tots els atributs.
     *
     * @param width Amplada del Rectaqngle
     * @param height Altura del Rectaqngle
     * @param x Posició del rectangle en l'eix X
     * @param y Posició del rectangle en l'eix Y
     */
    public Rectangle(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    /**
     * Crea un Rectangle a partir de l'amplada i l'altura.
     * Aquest rectangle està posicionat en l'origen de coordenades (0, 0).
     *
     * @param width Amplada del Rectangle.
     * @param height Alçada del Rectangle.
     */
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Calcula l'àrea del rectangle.
     *
     * @return Àrea del rectangle
     * @since 1.1
     */
    public int area(){
        // AREA = BASE * ALTURA
        return this.width * this.height;
    }

    /**
     * Comprova si el punt especificat (x, y) està dins del rectangle.
     *
     * @param x Coordenada del punt en l'eix X
     * @param y Coordenada del punt en l'eix Y
     * @return true si el punt (x, y) està dins del rectangle; false en altre cas.
     * @since 1.2
     */
    public boolean contains(int x, int y){
        boolean insideX = (x >= this.x) && (x <= (this.x + width));
        boolean insideY = (y >= this.y) && (y <= (this.y + height));
        return insideX && insideY;
    }
}