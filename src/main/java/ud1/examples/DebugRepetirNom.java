package ud1.examples;

public class DebugRepetirNom {
    public static void main(String[] args) {
        String name = "Joan";
        String surname = "Puigcerver";
        int repeticions = 20;

        for (int i = 0; i < repeticions; i++) {
            System.out.printf("%d. %s %s\n", i, name, surname);
        }
    }
}