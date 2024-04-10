package programame;

import java.util.Scanner;

public class ReduciendoEnvases {

    public static int resoldreProblema(int pesNet, int pesTotal) {
        return pesTotal - pesNet;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int numCasos = in.nextInt();
        for (int i = 0; i < numCasos; i++) {
            int pesNet = in.nextInt();
            int pesTotal = in.nextInt();
            int resultat = resoldreProblema(pesNet, pesTotal);
            System.out.println(resultat);
        }
    }
}
