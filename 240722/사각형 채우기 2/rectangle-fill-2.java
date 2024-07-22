import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+2];
        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2] * 2 + dp[i-1]) % 10_007; 
        }

        System.out.println(dp[n]);

    }
}