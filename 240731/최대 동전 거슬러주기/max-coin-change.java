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

        int[] coin = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[m+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            for(int j = coin[i]; j <= m; j++) {
                if(dp[j - coin[i]] == -1) continue;
                dp[j] = dp[j] > dp[j - coin[i]] + 1 ? dp[j] : dp[j - coin[i]] + 1;
            }
        }

        System.out.println(dp[m]);

    }
}