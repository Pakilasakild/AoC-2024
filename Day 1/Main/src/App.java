import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(new File("U1.txt"));
                BufferedWriter out = new BufferedWriter(new FileWriter("U1rez.txt"))) {
            int pir[] = new int[1000];
            int ant[] = new int[1000];
            int sum = 0;
            for (int i = 0; i < 1000; i++) {
                pir[i] = in.nextInt();
                ant[i] = in.nextInt();
            }
            Arrays.sort(pir);
            Arrays.sort(ant);
            for (int i = 0; i < 1000; i++) {
                sum += Math.abs(pir[i] - ant[i]);
            }
            System.out.println(sum);
            in.close();
            out.close();
        }
    }
}