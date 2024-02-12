package ud5.exercises;

import java.util.InputMismatchException;

public class StringCalculator {
    public int add(String numbers){
        if (numbers.isEmpty())
            return 0;

        char delimeter = ',';
        if (numbers.startsWith("//")) {
            delimeter = numbers.charAt(2);
            numbers = numbers.substring(4);
        }

        if (numbers.charAt(numbers.length() - 1) == delimeter)
            throw new InputMismatchException("Separator at the end is not allowed");

        String[] args = numbers.split(delimeter + "|\n");
        int suma = 0;
        for(String arg : args){
            suma += Integer.parseInt(arg);
        }
        return suma;
    }
}
