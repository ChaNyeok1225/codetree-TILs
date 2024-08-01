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
        
        int[][] jewel = new int[n+1][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[m+1];
        dp[0] = 0;
        int val;
        for(int i = 0; i < n; i++) {
            for(int j = m; j >= jewel[i][0]; j--) {
                val = dp[j - jewel[i][0]] + jewel[i][1];
                dp[j] = dp[j] > val ? dp[j] : val;
            }
        }

        System.out.println(dp[m]);

    }
}