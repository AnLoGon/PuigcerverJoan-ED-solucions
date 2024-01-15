package ud5.examples;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Nested
    class ConstructorTests {
        @Test
        @DisplayName("Constructor amb matrícula i quilòmetres")
        void createCar_givenPlateAndKilometers(){
            Car car = new Car("0000 BBB", 100);

            assertAll(
                () -> assertNotNull(car),
                () -> assertEquals("0000 BBB", car.getPlate()),
                () -> assertEquals(100, car.getKilometers()),
                () -> assertEquals(0, car.getVelocity())
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
            car.accelerate(14);
            assertEquals(14, car.getVelocity());
        }

        @Test
        @DisplayName("Accelera una velocitat determinada múltiples vegades")
        void multipleSpecificAccelerate() {
            car.accelerate(14);
            car.accelerate(13);
            assertEquals(27, car.getVelocity());
        }
    }
}