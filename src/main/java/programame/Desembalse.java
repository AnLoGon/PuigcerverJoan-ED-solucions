package programame;

import java.util.Scanner;

public class Desembalse {

    public static int resoldreProblema(int[] altures){
        int suma = 0;
        int alturaPoble = altures[altures.length - 1];
        for (int i = 0; i < altures.length - 1; i++) {
            suma += alturaPoble - altures[i];
        }
        return suma;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int d = in.nextInt();
        while (d != 0){
            int[] altures = new int[d];
            for (int i = 0; i < d; i++) {
                altures[i] =  in.nextInt();
            }

            int resultat = resoldreProblema(altures);
            System.out.println(resultat);

            d = in.nextInt();
        }
    }
}
