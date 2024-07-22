import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+2];

        dp[0] = dp[1] = 1;
        for(int i = 2; i < n + 1; i++) {
            
            int sum = 0;
            for(int j = 0; j < i; j++) {
                sum += dp[j] * dp[i - j - 1];
            }

            dp[i] = sum;
        }   

        System.out.println(dp[n]);
 

    }
}