import java.util.*;
import java.io.*;

public class Main {

    static final int INT_INF = 0x7F7F7F7F;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[m+1];
        Arrays.fill(dp, INT_INF);
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            for(int j = m; j >= num[i]; j--) {
                dp[j] = dp[j] < dp[j - num[i]] + 1 ? dp[j] : dp[j - num[i]] + 1;
            }
        }

        if(dp[m] == INT_INF)
            dp[m] = -1;
        System.out.println(dp[m]);
    }
}