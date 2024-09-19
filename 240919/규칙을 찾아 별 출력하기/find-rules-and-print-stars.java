import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int size = 4 * (n - 1) + 1;
        boolean[][] ch = new boolean[size][size];

        recv(ch, 0, n, size);

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                sb.append(ch[i][j] ? '*' : ' ');
            }sb.append("\n");
        }

        System.out.print(sb);
    }

    static void recv(boolean[][] ch, int cnt, int n, int size) {

        if(cnt == n) 
            return;

        int s = 2 * cnt;
        for(int i = s; i < size - s; i++) {
            ch[s][i] = ch[size - s - 1][i] = ch[i][s] = ch[i][size - s - 1] = true;
        }

        recv(ch, cnt + 1, n, size);
    }
}