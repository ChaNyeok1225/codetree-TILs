import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] dice;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        dice = new int[n];
        printDice(0, 1, n);
        System.out.println(sb);

    }

    static void printDice(int idx, int prev, int num) {
        if(idx == num) {
            for(int i = 0; i < num; i++) 
                sb.append(dice[i]).append('-');
            sb.setLength(sb.length() - 1);
            sb.append('\n');
            return;
        }

        for(int i = prev; i < 7; i++) {
            dice[idx] = i;
            printDice(idx + 1, i, num);
        }
    }
}