package ud5.exercises;

public class StringCalculator {
    public int suma(String str){
        if (str.isBlank())
            return 0;

        String[] args = str.split(",");
        if (args.length > 1)
            return Integer.parseInt(args[0])
                + Integer.parseInt(args[1]);
        return Integer.parseInt(str);
    }
}
