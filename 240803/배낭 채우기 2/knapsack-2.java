import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] jewel = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[m + 1];

        for(int i = 0; i < n; i++) {
            for(int j = jewel[i][0]; j <= m; j++) {
                dp[j] = Math.max(dp[j], dp[j - jewel[i][0]] + jewel[i][1]);
            }
        }
        System.out.println(dp[m]);

    }
}