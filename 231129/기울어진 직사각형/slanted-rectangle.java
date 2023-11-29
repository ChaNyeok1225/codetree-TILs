import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1,-1,1,1,0}, dy = {1,-1,-1,1,0};
    static int[][] board;
    static boolean[][] vis;
    static int ans, sx, sy, n;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        vis = new boolean[n][n];


        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 2; i < n; i++) {
            for(int j = 1; j < n-1; j++) {
                sx = i;
                sy = j;
                dfs(i - 1, j + 1, 0, 0);

            }
        }

        System.out.println(ans);
        
    }

    static void dfs(int x, int y, int dir, int sum) {
        if(valid(x,y)) return;

        if(dir > 3) 
            return;

        if(x == sx && y == sy) {
            sum += board[x][y];
            ans = ans > sum ? ans : sum;
            return;
        }

        dfs(x + dx[dir], y + dy[dir], dir, sum + board[x][y]);
        dfs(x + dx[dir+1], y + dy[dir+1] , dir + 1, sum + board[x][y]);
    }

    static boolean valid(int x, int y) {
        return x < 0 || y < 0 || n <= x || n <= y;
    }

}