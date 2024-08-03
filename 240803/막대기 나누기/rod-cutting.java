import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            dp[i] = dp[i-1];
            
            for(int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + arr[i-j]);
            }
        }

        System.out.println(dp[n]);
        
        
    }
}