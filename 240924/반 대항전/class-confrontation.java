import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] score = new int[4];
        int max = 0;
        int winner = 0;

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < 4; i ++) { 
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for(int j = 0; j < N; j++) {
                score[i] += Integer.parseInt(st.nextToken());
            }

            if(max < score[i]) {
                max = score[i];
                winner = i;
            }
        }

        for(int i = 0; i < 4; i++) {
            sb.append((char)(i + 'A') + " - ").append(score[i]).append("\n");
        }
        sb.append("Class " + (char)(winner + 'A') + " is winner!");

        System.out.println(sb);
    }
}