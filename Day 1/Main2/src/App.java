import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new FileReader("U1.txt"));
        int pc[] = new int[1000];
        int sc[] = new int[1000];
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            int temp = in.nextInt();
            pc[i] = temp;
            temp = in.nextInt();
            sc[i] = temp;
        }
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (pc[i] == sc[j]) {
                    sum += sc[j];
                } else {
                    continue;
                }
            }
        }
        System.out.println(sum);
    }
}