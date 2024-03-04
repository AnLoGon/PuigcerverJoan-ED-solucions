package exam2;

/**
 * Representa una làmpara
 * @author Joan Puigcerver
 * @version 1.0
 */
public class Lamp {
    /**
     * Consum de la làmpara en kWh
     */
    private final double consumption;
    /**
     * Estat de la làmpara. true si esta encesa; false si esta apagada
     */
    private boolean on;

    /**
     * Crea una làmpara apagada amb el consum en kWh indicat
     * @param consumption Consum de la làmpara en kWh
     * @since 1.0
     */
    public Lamp(double consumption) {
        this.consumption = consumption;
        this.on = false;
    }

    /**
     * Crea una làmpara amb el consum en kWh indicat i en l'estat indicat
     * @param consumption Consum de la làmpara en kWh
     * @param on Estat de la làmpara. true si esta encesa; false si esta apagada
     * @since 1.0
     */
    public Lamp(double consumption, boolean on) {
        this.consumption = consumption;
        this.on = on;
    }

    /**
     * Recupera el consum de la làmpara
     * @return Consum de la làmpara en kWh
     */
    public double getConsumption() {
        return consumption;
    }

    /**
     * Indica si la làmpara està encesa o apagada
     * @return true si la làmpara està encesa; false si està apagada
     */
    public boolean isOn() {
        return on;
    }

    /**
     * Encén la làmpara
     */
    public void turnOn() {
        on = true;
    }

    /**
     * Apaga la làmpara
     */
    public void turnOff() {
        on = false;
    }

    /**
     * Alterna l'estat de la làmpara
     */
    public void toggle() {
        on = !on;
    }

    /**
     * Calcula el consum en kW de la làmpara després
     * dels segons indicats.
     * <p>
     * Si la làmpara està apagada, sempre retornarà 0.
     * @param seconds Segons transcurrits
     * @return Si la làmpara està encesa retornarà el consum de la làmpara transcurrits els segons especificats; 0 si està apagada
     */
    public double consume(double seconds) {
        if (!on) {
            return 0;
        }
        return consumption * (seconds / 3600.0);
    }
}
