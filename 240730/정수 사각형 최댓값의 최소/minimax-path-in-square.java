import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];
        for(int i = 1; i < n; i++) {
            dp[0][i] = arr[0][i] > dp[0][i-1] ? arr[0][i] : dp[0][i-1];
            dp[i][0] = arr[i][0] > dp[i-1][0] ? arr[i][0] : dp[i-1][0]; 
        }

        int m;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                m = dp[i-1][j] < dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
                dp[i][j] = arr[i][j] > m ? arr[i][j] : m;
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}