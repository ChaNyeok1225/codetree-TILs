import java.io.*;
import java.util.*;

public class Main {


    static int[] dx = {1,0,-1,0}, dy={0,1,0,-1};
    static int max = 0,n, m;
    static int[][] board;
    static boolean[][] vis;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        vis = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dfs(i, j, 0, 0);
            }
        }

        System.out.println(max);
        
    }

    static void dfs(int x, int y, int cnt, int sum) {
        if(valid(x,y)) 
            return;

        if(cnt == 3) { 
            max = max > sum? max : sum;
            return;
        }

        vis[x][y] = true;
        sum += board[x][y];
        for(int dir = 0; dir < 4; dir++) {
            dfs(x + dx[dir], y + dy[dir], cnt+1, sum);
        }
        vis[x][y] = false;
        
    }

    static boolean valid(int x,int y) {
        return x < 0 || y < 0 || n <= x || m <= y || vis[x][y];
    }

}