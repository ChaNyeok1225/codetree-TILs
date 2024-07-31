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

        int[] coins = new int[n];
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
            if(coins[i] > m)
                continue;
            dp[coins[i]] = 1;
        }
        

        for(int i = 1; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                if(i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = dp[i] < dp[i-coins[j]] + 1 ? dp[i] : dp[i-coins[j]] + 1 ;
                }
            }
        }
        if(dp[m] == Integer.MAX_VALUE)
            dp[m] = -1;
        System.out.println(dp[m]);

    }
}