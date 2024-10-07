import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }


        if(m < n) {
            int tmp = n;
            n = m;
            m = tmp;
            int[] tmpArr = a;
            a = b;
            b = tmpArr;
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int[][] dp = new int[n+1][m+1];

        int INF = 1_000_000_000;
        for(int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], INF);
        }
        for(int i = 0; i < m + 1; i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = i; j < m + 1; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i-1][j-1] + Math.abs(a[i-1] - b[j-1]));
            }
        }

        int answer = INF;
        for(int i = n; i < m + 1; i++) {
            answer = answer < dp[n][i] ? answer : dp[n][i];
        }
        System.out.println(answer);

    }
}