import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] work = new int[n][3];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            work[i][0] = Integer.parseInt(st.nextToken());
            work[i][1] = Integer.parseInt(st.nextToken());
            work[i][2] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        int ans = 0;    
        for(int i = 0; i < n; i++) {
            dp[i] = work[i][2];
            for(int j = 0; j < i; j++) {
                if(work[i][0] > work[j][1]) {
                    dp[i] = dp[i] > dp[j] + work[i][2] ? dp[i] : dp[j] + work[i][2];
                }
            }
            ans = ans > dp[i] ? ans : dp[i];
        }

        System.out.println(ans);
        

    }
}