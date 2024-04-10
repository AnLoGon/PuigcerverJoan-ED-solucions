package ud5.examples.car.domain.entity;

/**
 *  A simple car class with a constructor and a method to accelerate.
 */
public class Car {
    private String plate;
    private String brand;
    private String model;
    private double speed;

    private double km;

    public Car(String plate, String brand, String model) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.speed = 0.0;
        this.km = 0.0;
    }

    public Car(String plate, String brand, String model, double km) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.speed = 0.0;
        this.km = km;
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

    public double getKilometers() {
        return km;
    }

    public void accelerate(double speed) {
        this.speed += speed;
    }

    public void setKm(double km) {
        this.km = km;
    }
}
