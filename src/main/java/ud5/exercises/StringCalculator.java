package ud5.exercises;

import java.util.InputMismatchException;

public class StringCalculator {
    public int suma(String str){
        if (str.isBlank())
            return 0;

        char lastChar = str.charAt(str.length() - 1);
        if (lastChar == ',' || lastChar == '\n')
            throw new InputMismatchException("Addition string not correctly formatted.");


        String[] args = str.split(",|\n");
        int suma = 0;
        for (int i = 0; i < args.length; i++) {
            suma += Integer.parseInt(args[i]);
        }
        return suma;
    }
}
