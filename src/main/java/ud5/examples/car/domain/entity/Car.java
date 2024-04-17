package ud5.examples.car.domain.entity;

/**
 *  A simple car class with a constructor and a method to accelerate.
 */
public class Car {
    private final String plate;
    private final String brand;
    private final String model;
    private double speed;

    public Car(String plate, String brand, String model) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.speed = 0.0;
    }

    public Car(String plate, String brand, String model, double speed) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }

    public String getPlate() {
        return plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getSpeed() {
        return speed;
    }

    public void accelerate(double speed) {
        this.speed += speed;
    }
}
