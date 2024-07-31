import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] num = {1,2,5};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {

            for(int j = 0; j < 3; j++) {
                if(i - num[j] < 0)
                    continue;
                dp[i] += dp[i - num[j]];
            }
            dp[i] = dp[i] % 10007;
        }

        System.out.println(dp[n]);
    }
}