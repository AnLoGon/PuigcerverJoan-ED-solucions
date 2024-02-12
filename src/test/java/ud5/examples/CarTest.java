package ud5.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    @DisplayName("Car constructor with plate, brand and model")
    void testConstructorPlateBrandModel() {
        Car car = new Car("1234ABC", "Seat", "Ibiza");
        assertAll(
            () -> assertEquals("1234ABC", car.getPlate()),
            () -> assertEquals("Seat", car.getBrand()),
            () -> assertEquals("Ibiza", car.getModel())
        );
    }

    @Test
    @DisplayName("Car::accelerate(double) should exist")
    void testAccelerate() {
        Car car = new Car("1234ABC", "Seat", "Ibiza");
        car.accelerate(10.0);
    }

    @Test
    @DisplayName("Car::accelerate(double) should increase speed when positive")
    void testAcceleratePositive() {
        Car car = new Car("1234ABC", "Seat", "Ibiza");
        car.accelerate(10.0);
        assertEquals(10.0, car.getSpeed());
    }
}
