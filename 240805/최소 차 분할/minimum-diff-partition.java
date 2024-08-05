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
        int total = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        boolean[] dp = new boolean[total+1];
        dp[0] = true;
        int ans = total;

        for(int i = 0; i < n; i++) {
            for(int j = total; j >= arr[i]; j--) {
                if(dp[j - arr[i]]) {
                    dp[j] = true;
                    if(ans > Math.abs((total - j) - j)) {
                        ans = Math.abs((total - j) - j);
                    }
                }
            }
        }

        System.out.println(ans);

    }
}