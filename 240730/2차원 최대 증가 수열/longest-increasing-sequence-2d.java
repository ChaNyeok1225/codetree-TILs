import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int[][] dp = new int[n][m];
        dp[0][0] = dp[0][1] = 1;

        for(int j = 1; j < n; j++) {
            for(int i = 1; i < n; i++) {
                dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
                if(arr[i][j] > arr[i-1][j]) {
                    dp[i][j] = dp[i][j] > dp[i-1][j] + 1 ? dp[i][j] : dp[i-1][j] + 1;                       
                }  
                ans = ans > dp[i][j] ? ans : dp[i][j];
            }
        }

        System.out.println(ans);
    }   
}