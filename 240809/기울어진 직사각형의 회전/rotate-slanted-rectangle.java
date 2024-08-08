import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int[] move = new int[5];
        for(int i = 0; i < 4; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }
        int dir = Integer.parseInt(st.nextToken());
        int tmp = map[r][c];
        int[] dr = {-1, -1, 1, 1}, dc = {1, -1, -1, 1};

        // ^ 2
        int start = dir == 0 ? 3 : 0;
        int end = dir == 0 ? -1 : 4;
        int step = dir == 0 ? -1 : 1;
        int bit = dir == 0 ? 2 : 0;

        for(int i = start; i != end; i += step) {
            while(move[i]-- > 0) {
                map[r][c] = map[r + dr[i ^ bit]][c + dc[i ^ bit]];
                r = r + dr[i ^ bit];
                c = c + dc[i ^ bit];
            }
        }
        map[r - dr[(end - step) ^ bit]][c - dc[(end - step) ^ bit]] = tmp;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(map[i][j] + " ");
            }sb.append("\n");
        }
        System.out.print(sb);
    }
}