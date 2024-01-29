package ud5.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    @DisplayName("FizzBuzz class should exist")
    void classFizzBuzzShouldExist() {
        FizzBuzz fizzBuzz = new FizzBuzz();
    }

    /*
    @Test
    @DisplayName("FizzBuzz::transform() method should exist")
    void fizzBuzzTransformMethodShouldExist() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.transform();
    }
     */

    @Test
    @DisplayName("FizzBuzz::transform() method should have an int parameter")
    void fizzBuzzTransformMethodShouldHaveIntParameter() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.transform(1);
    }
    @Test
    @DisplayName("FizzBuzz::transform(1) should return 1")
    void fizzBuzzTransform_givenValue1_shouldReturn1() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        int result = fizzBuzz.transform(1);
        assertEquals(1, result);
    }
}
