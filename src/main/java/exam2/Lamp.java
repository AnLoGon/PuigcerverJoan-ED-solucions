package exam2;

public class Lamp {
    private final double consumption;
    private boolean on;

    public Lamp(double consumption) {
        this.consumption = consumption;
        this.on = false;
    }

    public Lamp(double consumption, boolean on) {
        this.consumption = consumption;
        this.on = on;
    }

    public double getConsumption() {
        return consumption;
    }

    public boolean isOn() {
        return on;
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public void toggle() {
        on = !on;
    }

    public double consume(double seconds) {
        if (!on) {
            return 0;
        }
        return consumption * (seconds / 3600.0);
    }
}
