import java.io.*;
import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        boolean[][] vis = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] tmp = new int[n][n];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                
                for(int k = 0; k < n; k++)
                    copy(tmp[k], board[k]);

                boom(tmp, i, j);

                drop(tmp);

                int cnt = search(tmp, vis);
                ans = ans > cnt ? ans : cnt;
            }
        }        

        System.out.println(ans);
    }

    static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};

    static void copy(int[] tmp, int[] board){
        for(int i = 0; i < n; i++)
            tmp[i] = board[i];
    }

    static void boom(int[][] tmp, int x, int y) {
        
        int val = tmp[x][y];
        tmp[x][y] = 0;

        int nx = 0, ny = 0;
        for(int dir = 0; dir < 4; dir++) {
            for(int i = 1; i < val; i++) {
                nx = x + dx[dir] * i;
                ny = y + dy[dir] * i;

                if(valid(nx,ny))
                    break;

                tmp[nx][ny] = 0;
            }
        }

    }

    static Queue<Integer> q = new ArrayDeque<>();
    static void drop(int[][] tmp) {
        for(int i = 0; i < n; i++) {
            for(int j = n-1; j >= 0; j--) {
                if(tmp[j][i] == 0)
                    continue;
                q.offer(tmp[j][i]);
                tmp[j][i] = 0;
            }

            for(int j = n-1; j >= 0; j--) {
                if(q.isEmpty()) break;
                tmp[j][i] = q.poll();
            }
        }
    }



    static int search(int[][] tmp, boolean[][] vis) {

        int cnt = 0;

        int val = 0, nx = 0, ny = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                val = tmp[i][j];
                if(val == 0) continue;

                for(int dir = 0; dir < 4; dir++) {
                    nx = i + dx[dir];
                    ny = j + dy[dir];

                    if(valid(nx,ny) || vis[nx][ny])
                        continue;
                    
                    if(tmp[nx][ny] == val)
                        cnt++;
                }
            
                vis[i][j] = true;
            }
        }

        for(int i = 0; i < n; i++)
            Arrays.fill(vis[i], false);

        return cnt;

    }

    static boolean valid(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }

}