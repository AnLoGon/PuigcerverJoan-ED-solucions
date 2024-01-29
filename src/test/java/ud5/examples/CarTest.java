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
        @DisplayName("Accelera 15 km/h quan no està en moviment")
        void accelerate_GivenAccelerate15_VelocityShouldBe15() {
            car.accelerate(15);
            assertEquals(15, car.getVelocity());
        }

        @Test
        @DisplayName("Accelera 10 km/h quan no està en moviment")
        void accelerate_GivenAccelerate10_VelocityShouldBe10() {
            car.accelerate(10);
            assertEquals(10, car.getVelocity());
        }

        @Test
        @DisplayName("Accelera una velocitat negativa i la velocitat no hauria de canviar")
        void accelerate_GivenAccelerateNegativeValue_VelocityShouldNotBeUpdated() {
            car.accelerate(20);
            car.accelerate(-10);
            assertEquals(20, car.getVelocity());
        }

        @Test
        @DisplayName("Accelera el cotxe quan està en moviment i hauria d'haver un increment de velocitat")
        void accelerate_GivenMultipleAccelerate_VelocityShouldBeAddition() {
            car.accelerate(10);
            car.accelerate(15);
            assertEquals(25, car.getVelocity());
        }

        @Test
        @DisplayName("Accelera una única vegada sense paràmetre")
        void accelerate_GivenNoParameter_VelocityShouldIncreaseIn5() {
            car.accelerate();
            assertEquals(5, car.getVelocity());
        }

        @Test
        @DisplayName("Accelera multiple vegades sense paràmetre")
        void accelerate_GivenNoParameterMultipleTimes_VelocityShouldIncreaseIn5EachTime() {
            car.accelerate();
            car.accelerate();
            car.accelerate();
            assertEquals(15, car.getVelocity());
        }

    }
}