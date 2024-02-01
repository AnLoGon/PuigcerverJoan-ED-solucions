package ud5.exercises;

public class StringCalculator {
    public int suma(String str){
        if (str.isBlank())
            return 0;

        String[] args = str.split(",");
        int suma = 0;
        for (int i = 0; i < args.length; i++) {
            suma += Integer.parseInt(args[i]);
        }
        return suma;
    }
}
