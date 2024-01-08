package ud5.examples;

public class StringObject {
    public static void main(String[] args) {
        String a = "Joan";
        String b = "Joan";
        String c = "Pere";
        String d = a;

        System.out.println("És a equals b? " + a.equals(b));
        System.out.println("És a equals c? " + a.equals(c));
        System.out.println("És a == b? " + (a == b));
        System.out.println("És a == c? " + (a == c));
        System.out.println("És a == d? " + (a == d));
    }
}
