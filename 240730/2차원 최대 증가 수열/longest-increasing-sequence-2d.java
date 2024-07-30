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

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 1;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                
                for(int k = 0; k < i; k++) {
                    for(int l = 0; l < j; l++) {
                        
                        if(dp[k][l] != 0 && arr[k][l] < arr[i][j]) {
                            dp[i][j] = dp[i][j] > dp[k][l] + 1 ? dp[i][j] : dp[k][l] + 1;
                        }

                    }
                }
                ans = ans > dp[i][j] ? ans : dp[i][j];
            }
        }


        System.out.println(ans);
    }   
}