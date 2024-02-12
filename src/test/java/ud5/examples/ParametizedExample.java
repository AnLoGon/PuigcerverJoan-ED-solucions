package ud5.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParametizedExample {
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    @DisplayName("Parameterized Test with ValueSource")
    public void parameterizedValueSourceTest(int number) {
        assertEquals(0, number % 2);
    }

    @ParameterizedTest(name="\"{0}\"")
    @NullSource
    @EmptySource
    @ValueSource(strings = { " ", "      ", "  \n   " })
    void nullEmptyAndBlankStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }

    @ParameterizedTest(name="{0} + {1} = {2}")
    @CsvSource({ "1,1,2", "2,2,4", "3,3,6", "4,4,8", "5,5,15", "6,6,12", "7,7,14", "10,90,100" })
    @DisplayName("Parameterized Test with CsvSource")
    public void parameterizedCsvSourceTest(int left, int right, int expected) {
        assertEquals(expected, Math.addExact(left, right));
    }

    @ParameterizedTest(name="[{index}] {0} + {1} = {2}")
    @MethodSource("numberToSum")
    @DisplayName("Parameterized Test with MehodSource")
    public void parameterizedMehodSourceTest(int left, int right, int expected) {
        assertEquals(expected, Math.addExact(left, right));
    }

    private static List<Arguments> numberToSum() {
        ArrayList<Arguments> args = new ArrayList<>();
        args.add(arguments(1, 1, 2));
        args.add(arguments(2, 2, 4));
        args.add(arguments(3, 3, 6));
        return args;
    }
}
