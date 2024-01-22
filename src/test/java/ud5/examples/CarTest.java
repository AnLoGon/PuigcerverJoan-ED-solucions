package ud5.examples;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Nested
    @DisplayName("Constructor tests")
    class ConstructorTests {
        @Test
        void constructorWithPlate(){
            String plate = "0000 BBB";
            Car c = new Car(plate);
            assertAll(
                () -> assertEquals(plate, c.getPlate()),
                () -> assertEquals(0, c.getKilometers()),
                () -> assertEquals(0, c.getVelocity())
            );
        }

        @Test
        void constructorWithPlateAndKilometers(){
            String plate = "0000 BBB";
            int km = 1234;
            Car c = new Car(plate, km);
            assertAll(
                    () -> assertEquals(plate, c.getPlate()),
                    () -> assertEquals(km, c.getKilometers()),
                    () -> assertEquals(0, c.getVelocity())
            );
        }
    }

    @Nested
    @DisplayName("Accelerate tests")
    class Accelerate {
        private Car car;

        @BeforeEach
        void setup() {
            car = new Car("0000 BBB");
        }

        @Test
        @DisplayName("Comprova la velocitat inicial")
        void testInitialVelocity() {
            assertEquals(0, car.getVelocity());
        }

        @Test
        @DisplayName("Accelera una única vegada")
        void singleAccelerate() {
            car.accelerate();
            assertEquals(5, car.getVelocity());
        }

        @Test
        @DisplayName("Accelera multiple vegades")
        void multipleAccelerate() {
            car.accelerate();
            car.accelerate();
            car.accelerate();
            assertEquals(15, car.getVelocity());
        }

        @Test
        @DisplayName("Accelera una velocitat determinada")
        void specificAccelerate() {
            car.accelerate(13);
            car.accelerate(14);
            assertEquals(27, car.getVelocity());
        }
    }

    @Nested
    @DisplayName("Drive tests")
    class DriveTests {
        private Car car;

        @BeforeEach
        void setup(){
            car = new Car("0000 BBB");
        }

        @Test
        @DisplayName("Drive: 1 segon a 0 km/h")
        void drive1second_velocity0(){
            car.drive(1);
            assertAll(
                () -> assertEquals(0, car.getVelocity()),
                () -> assertEquals(0, car.getKilometers())
            );
        }

        @Test
        @DisplayName("Drive: 1000 segons a 0 km/h")
        void drive1000second_velocity0(){
            car.drive(1000);
            assertAll(
                    () -> assertEquals(0, car.getVelocity()),
                    () -> assertEquals(0, car.getKilometers())
            );
        }

        @Test
        @DisplayName("Drive: 1 minut a 0 km/h")
        void drive1minut_velocity0(){
            car.drive();
            assertAll(
                    () -> assertEquals(0, car.getVelocity()),
                    () -> assertEquals(0, car.getKilometers())
            );
        }

        @Test
        @DisplayName("Drive: 1 minut a 30 km/h")
        void drive1minut_velocity30(){
            car.accelerate(30);
            car.drive();
            assertAll(
                    () -> assertEquals(30, car.getVelocity()),
                    () -> assertEquals(0.5, car.getKilometers())
            );
        }

        @Test
        @DisplayName("Drive: 2 minuts a 30 km/h")
        void drive2minut_velocity30(){
            car.accelerate(30);
            car.drive(120);
            assertAll(
                    () -> assertEquals(30, car.getVelocity()),
                    () -> assertEquals(1, car.getKilometers())
            );
        }

        @Test
        @DisplayName("Drive: 1 minuts a 120 km/h")
        void drive1minut_velocity120(){
            car.accelerate(120);
            car.drive();
            assertAll(
                    () -> assertEquals(120, car.getVelocity()),
                    () -> assertEquals(2, car.getKilometers())
            );
        }
    }

    @Nested
    @DisplayName("Decelerate tests")
    class DecelerateTests {
        private Car car;

        @BeforeEach
        void setup(){
            car = new Car("0000 BBB");
        }

        @Test
        void decelerate10at0(){
            car.decelerate(10);
            assertEquals(0, car.getVelocity());
        }
        @Test
        void decelerate10at20(){
            car.accelerate(20);
            car.decelerate(10);
            assertEquals(10, car.getVelocity());
        }
    }
}