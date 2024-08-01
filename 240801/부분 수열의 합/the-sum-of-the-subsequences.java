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

        int[] num = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        boolean ans = false;
        for(int i = 1; i <= n && !ans; i++) {
            for(int j = 0; j <= m && !ans; j++) {
                dp[i][j] = dp[i-1][j];

                if(j-num[i] >= 0 && dp[i-1][j - num[i]]) {
                    dp[i][j] = true;
                    if(j==m) {
                        ans = true;
                    }
                }
            }
        }

        if(ans) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }


    }
}