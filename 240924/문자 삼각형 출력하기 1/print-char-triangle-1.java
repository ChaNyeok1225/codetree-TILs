import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        char[][] ch = new char[n][n];

        int alpha = 0;

        int r = 0, c = n - 1, step = 0;
        while(true) {
            ch[r][c] = (char)(alpha + 'A');
            alpha = ++alpha % 26;
            r++;
            c--;
            if(r == n) {
                r = ++step;
                c = n - 1;
                if(step == n) {
                    break;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(ch[i][j] == 0 ? ' ' : ch[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}