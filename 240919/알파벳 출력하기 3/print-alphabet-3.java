import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int alpha = 'A';

        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i; j++) {
                sb.append((char)alpha++);
                if(alpha == 'Z') {
                    alpha = 'A';
                }
            }sb.append("\n");
        }

        System.out.println(sb);
    }
}