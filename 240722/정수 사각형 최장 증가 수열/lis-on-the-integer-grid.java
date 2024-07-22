import java.util.*;
import java.io.*;

public class Main {

    static int[][] dp, map;
    static int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());    
            }
        }

        dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int max = 0, cnt;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                cnt = dfs(i, j);
                max = max > cnt ? max : cnt; 
            }
        }

        System.out.println(max);
    }

    static int dfs(int r, int c) {
        if(dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = 1;

        int max = 0, cnt;
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= n || nc < 0 || nc >= n) {
                continue;
            }
            if(map[r][c] >= map[nr][nc]) {
                continue;
            }
            cnt = dfs(nr, nc);
            max = max > cnt ? max : cnt;
        }

        return dp[r][c] = dp[r][c] + max;
    }

}