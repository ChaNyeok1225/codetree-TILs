import java.io.*;
import java.util.*;

public class Main {

    static int n,m,ans;
    static int[][] board;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][n];
        int total = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1)
                    total++;
            }
        }

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                int gold = 0;
                for(int k = 0; k <= 2 * (n-1); k++) {
                    gold += getGold(x, y, k);

                    if( (k*k + (k+1)*(k+1)) <= m * gold )
                        ans = ans > gold ? ans : gold;
                }
            }
        }
        System.out.println(ans);

    }

    static int[] dx = {1,1,-1,-1}, dy = {-1,1,1,-1};

    static int getGold(int x, int y, int k) {

        int nx = x - k;
        int ny = y;
        if(k==0) 
            return board[x][y];
        
        int gold = 0;
        for(int dir = 0; dir < 4; dir++) {
            for(int i = 0; i < k; i++) {
                nx = nx + dx[dir];
                ny = ny + dy[dir];
                if(valid(nx,ny)) continue;
                gold += board[nx][ny];
            }
            
        }

        return gold;
    }


    static boolean valid(int x, int y) {
        return x < 0 || y < 0 || n <= x || n <= y;
    }

}