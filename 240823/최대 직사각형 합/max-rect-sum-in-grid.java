import java.util.*;
import java.io.*;

public class Main {

    static int[][] acc;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()) + 1;
        int[][] arr = new int[n][n];
        acc = new int[n][n];

        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                acc[i][j] = arr[i][j] - acc[i-1][j-1] + acc[i-1][j] + acc[i][j-1];
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                calc(i, j);
            }
        }

        System.out.println(ans);
    }

    static void calc(int r, int c) {

        for(int h = 1; h <= r; h++) {
            for(int w = 1; w <= c; w++) {
                int val = acc[r][c] - acc[r-h][c] - acc[r][c-w] + acc[r-h][c-w];
                ans = ans > val ? ans : val;
            }
        }

    }

}