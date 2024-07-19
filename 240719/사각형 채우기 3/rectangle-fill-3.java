import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+2];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;

        long sum = 0;
        long acc = 0;
        for(int i = 3; i <= n; i++) {
            
            sum = (dp[i-1] * 2 + dp[i-2] * 3) % 1_000_000_007;
            acc = (acc + dp[i-3] * 2) % 1_000_000_007;
            dp[i] = (sum + acc) % 1_000_000_007;
        }

        System.out.println(dp[n]);
        

    }
}