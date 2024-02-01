package ud5.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator calculator;

    @BeforeEach
    void setup(){
        this.calculator = new StringCalculator();
    }
    @Test
    @DisplayName("StringCalculator::suma(String) should exist and return a int parameter")
    void stringCalculatorSumaMethodShouldExist(){
        int result = calculator.suma("");
    }

    @Test
    @DisplayName("StringCalculator::suma(\"\") should return 0")
    void suma_givenEmptyString_shouldReturn0(){
        int expected = 0;
        int result = calculator.suma("");
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("StringCalculator::suma(\" \") should return 0")
    void suma_givenSpaceString_shouldReturn0(){
        int expected = 0;
        int result = calculator.suma(" ");
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("StringCalculator::suma(1) should return 1")
    void suma_given1_shouldReturn1(){
        int expected = 1;
        int result = calculator.suma("1");
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("StringCalculator::suma(2) should return 2")
    void suma_given2_shouldReturn2(){
        int expected = 2;
        int result = calculator.suma("2");
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("StringCalculator::suma(1,2) should return 3")
    void suma_given1and2_shouldReturn3(){
        int expected = 3;
        int result = calculator.suma("1,2");
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("StringCalculator::suma(1,2,3) should return 6")
    void suma_givenThreeParameters_shouldReturnAdditionAllOfThem(){
        int expected = 6;
        int result = calculator.suma("1,2,3");
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("StringCalculator::suma(1,2\\n3) should return 6")
    void suma_givenStringWithNewLineAsSeparator_shouldReturnAdditionAllOfThem(){
        int expected = 6;
        int result = calculator.suma("1,2\n3");
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("StringCalculator::suma(1,2,) should return error")
    void suma_givenStringWithNewSeparatorAtEnd_shouldReturnError(){
        assertThrows(InputMismatchException.class, () -> calculator.suma("1,2,"));
    }
}