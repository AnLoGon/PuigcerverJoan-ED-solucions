package ud5.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    private StringCalculator sc;

    @BeforeEach
    void setup(){
        sc = new StringCalculator();
    }

    /*
    @Test
    void stringCalculatorShouldExist(){
        StringCalculator sc = new StringCalculator();
    }
    */

    @Test
    void addMethod_hasStringParameterAndReturnsInt(){
        int result = sc.add("");
    }

    @Test
    @DisplayName("StringCalculator::add(\"\") should be 0")
    void add_GivenEmptyString_shouldReturn0(){
        int result = sc.add("");
        assertEquals(0, result);
    }

    @Test
    @DisplayName("StringCalculator::add(\"1\") should be 1")
    void add_given1_shouldReturn1(){
        int result = sc.add("1");
        assertEquals(1, result);
    }

    @Test
    @DisplayName("StringCalculator::add(\"2\") should be 2")
    void add_given2_shouldReturn2(){
        int result = sc.add("2");
        assertEquals(2, result);
    }

    @Test
    @DisplayName("StringCalculator::add(\"1,2\") should be 3")
    void add_given1and2_shouldReturn3(){
        int result = sc.add("1,2");
        assertEquals(3, result);
    }

    @Test
    @DisplayName("StringCalculator::add(\"2,1\") should be 3")
    void add_given2and1_shouldReturn3(){
        int result = sc.add("2,1");
        assertEquals(3, result);
    }

    @Test
    @DisplayName("StringCalculator::add(\"1,2,3\") should be 6")
    void add_given1and2and3_shouldReturn6(){
        int result = sc.add("1,2,3");
        assertEquals(6, result);
    }

    @Test
    @DisplayName("StringCalculator::add(\"1,2\\n3\") should be 6")
    void add_given1and2and3WithNewLine_shouldReturn6(){
        int result = sc.add("1,2\n3");
        assertEquals(6, result);
    }

    @Test
    @DisplayName("StringCalculator::add(\"1,2,\") should throw error")
    void add_givenSeparatorAtTheEnd_shouldThrowError(){
        assertThrows(InputMismatchException.class, () -> sc.add("1,2,"));
    }

    @Test
    @DisplayName("StringCalculator::add(\"//c\n1c2\") should be 3")
    void add_given1And2WithDifferentSeparator_shouldBe3(){
        int result = sc.add("//c\n1c2");
        assertEquals(3, result);
    }

    @Test
    @DisplayName("StringCalculator::add(\"//c\n1c2c\") should throw error")
    void add_givenDifferentSeparatorAtTheEnd_shouldThrowError(){
        assertThrows(InputMismatchException.class, () -> sc.add("//c\n1c2c"));
    }
}
