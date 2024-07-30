import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int[] dp = new int[n];

        for(int i = 1; i < n; i++) {
            
            for(int j = 0; j < i; j++) {
                if(i <= arr[j] + j) {
                    dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
                }
            }

            ans = ans > dp[i] ? ans : dp[i];
        }

        System.out.println(ans);
    }
}