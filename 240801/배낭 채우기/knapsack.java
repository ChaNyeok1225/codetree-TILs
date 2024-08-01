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
        
        int[][] jewel = new int[n+1][2];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                dp[i][j] = dp[i-1][j];

                if(j >= jewel[i][0] &&  dp[i-1][j - jewel[i][0]] >= 0) {
                    dp[i][j] = dp[i-1][j-jewel[i][0]] + jewel[i][1];
                }
                ans = ans > dp[i][j] ? ans : dp[i][j];
            }
        }

        System.out.println(ans);


    }
}