import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < i; j++)
                sb.append(" ");
            for(int j = 0; j <= i * 2; j++)
                sb.append("*");
            sb.append("\n");
        }
        for(int i = n / 2; i >= 0; i--) {
            for(int j = 0; j < i; j++)
                sb.append(" ");
            for(int j = 0; j <= i * 2; j++)
                sb.append("*");
            sb.append("\n");
        }
        System.out.print(sb);

    }
}