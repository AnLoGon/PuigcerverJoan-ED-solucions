package ud6.exercises.vehicles;

/**
 * Representa un vehicle amb matrícula, marca, model i any de fabricació.
 * @author Joan Puigcerver
 * @version 1.0
 */
public abstract class Vehicle {
    /**
     * Matrícula del vehicle.
     */
    private String matricula;
    /**
     * Marca del vehicle.
     */
    private String marca;
    /**
     * Model del vehicle.
     */
    private String model;
    /**
     * Any de fabricació del vehicle.
     */
    private int any;
    /**
     * Velocitat actual del vehicle.
     */
    protected double velocitat;

    /**
     * Crea un vehicle amb la matrícula, marca, model i any especificats.
     * La velocitat inicial és 0.
     *
     * @param matricula Matrícula del vehicle.
     * @param marca Marca del vehicle.
     * @param model Model del vehicle.
     * @param any Any de fabricació del vehicle.
     */
    public Vehicle(String matricula, String marca, String model, int any) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.any = any;
        this.velocitat = 0;
    }

    /**
     * Obté la matrícula del vehicle.
     * @return La matrícula del vehicle.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Obté la marca del vehicle.
     * @return La marca del vehicle.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Obté el model del vehicle.
     * @return El model del vehicle.
     */
    public String getModel() {
        return model;
    }

    /**
     * Obté l'any de fabricació del vehicle.
     * @return L'any de fabricació del vehicle.
     */
    public int getAny() {
        return any;
    }

    /**
     * Obté la velocitat actual del vehicle.
     * @return La velocitat actual del vehicle.
     */
    public double getVelocitat() {
        return velocitat;
    }

    /**
     * Acelera el vehicle.
     */
    public abstract void accelerar();
    /**
     * Frena el vehicle.
     */
    public abstract void frenar();
}
