import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+2];
        dp[1] = 2;
        dp[2] = 7;
        for(int i = 4; i <= n; i++) {
            dp[i] = (dp[i-1] * 2 + dp[i-2]) % 1_000_000_007;
        }

        System.out.println(dp[n]);
        

    }
}