import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken()) + 1;

        int[][] arr = new int[n][m];
        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] acc = new int[n][m];
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                acc[i][j] = arr[i][j] + acc[i][j-1] + acc[i-1][j] - acc[i-1][j-1];
            }
        }

        int k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
        
            sb.append(acc[x2][y2] - acc[x1-1][y2] - acc[x2][y1-1] + acc[x1-1][y1-1]).append('\n');
        }
        System.out.println(sb);

    }
}