import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] info = new int[n + 1][2];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 2];

        for(int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], dp[i-1]);

            if(i + info[i][0] <= n + 1) {
                dp[i+info[i][0]] = Math.max(dp[i+info[i][0]], dp[i] + info[i][1]);
            }
        }
        dp[n+1] = Math.max(dp[n+1], dp[n]);

        System.out.println(dp[n+1]);
    }
}