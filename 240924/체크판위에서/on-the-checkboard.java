import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        for(int i = 0; i < R; i++)
            map[i] = br.readLine().toCharArray();

        int[][] dp = new int[R][C];
        dp[0][0] = 1;

        for(int i = 1; i < R; i++) {
            for(int j = 1; j < C; j++) {
                for(int k = 0; k < i; k++) {
                    for(int l = 0; l < j; l++) {
                        if(map[i][j] == map[k][l])
                            continue;
                        dp[i][j] += dp[k][l];
                    }
                }
            }
        }

        System.out.println(dp[R-1][C-1]);
        
    }
}