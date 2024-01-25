package ud5.examples;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
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
        void accelerate_GivenAccelerate15_VelocityShouldBe15() {
            car.accelerate(15);
            assertEquals(15, car.getVelocity());
        }

        @Test
        void accelerate_GivenAccelerate10_VelocityShouldBe10() {
            car.accelerate(10);
            assertEquals(10, car.getVelocity());
        }

        @Test
        void accelerate_GivenAccelerateNegativeValue_VelocityShouldNotBeUpdated() {
            car.accelerate(-10);
            assertEquals(0, car.getVelocity());
        }

        @Test
        void accelerate_GivenMultipleAccelerate_VelocityShouldBeAddition() {
            car.accelerate(10);
            car.accelerate(15);
            assertEquals(25, car.getVelocity());
        }
    }
}