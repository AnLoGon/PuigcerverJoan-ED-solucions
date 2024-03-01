package exam2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class LampTest {
    @Nested
    class ConstructorTests {
        @Test
        @DisplayName("Lamp(double consumption) should create a Lamp with the given consumption and off")
        void testLampConstructor1() {
            Lamp l = new Lamp(10.0);
            assertAll(
                () -> assertEquals(10.0, l.getConsumption()),
                () -> assertFalse(l.isOn())
            );
        }

        @Test
        @DisplayName("Lamp(double consumption, boolean on) should create a Lamp with the given consumption and state")
        void testLampConstructor2() {
            Lamp l = new Lamp(10.0, true);
            assertAll(
                () -> assertEquals(10.0, l.getConsumption()),
                () -> assertTrue(l.isOn())
            );
        }
    }

    @Nested
    class TurnOnTests {
        @Test
        @DisplayName("turnOn() should turn the lamp on")
        void testTurnOn() {
            Lamp l = new Lamp(10.0);
            l.turnOn();
            assertTrue(l.isOn());
        }

        @Test
        @DisplayName("turnOn() should turn the lamp on if it is already on")
        void testTurnOnAlreadyOn() {
            Lamp l = new Lamp(10.0, true);
            l.turnOn();
            assertTrue(l.isOn());
        }
    }

    @Nested
    class TurnOffTests {
        @Test
        @DisplayName("turnOff() should turn the lamp off")
        void testTurnOff() {
            Lamp l = new Lamp(10.0, true);
            l.turnOff();
            assertFalse(l.isOn());
        }

        @Test
        @DisplayName("turnOff() should turn the lamp off if it is already off")
        void testTurnOffAlreadyOff() {
            Lamp l = new Lamp(10.0);
            l.turnOff();
            assertFalse(l.isOn());
        }
    }

    @Nested
    class ToggleTests {
        @Test
        @DisplayName("toggle() should turn the lamp on if it is off")
        void testToggleOn() {
            Lamp l = new Lamp(10.0);
            l.toggle();
            assertTrue(l.isOn());
        }

        @Test
        @DisplayName("toggle() should turn the lamp off if it is on")
        void testToggleOff() {
            Lamp l = new Lamp(10.0, true);
            l.toggle();
            assertFalse(l.isOn());
        }
    }

    @ParameterizedTest(name = "Lamp({0}, {1}).consume({2}) should return {3}")
    @DisplayName("consume() should return the expected consumption")
    @CsvSource({
        "true, 10.0, 3600, 10.0",
        "true, 0, 3600, 0.0",
        "true, 10.0, 0, 0.0",
        "false, 10.0, 3600, 0.0"
    })
    void testConsume(boolean on, double consumption, double seconds, double expected) {
        Lamp l = new Lamp(consumption, on);
        double result = l.consume(seconds);
        assertEquals(expected, result, 1e-5);
    }
}
