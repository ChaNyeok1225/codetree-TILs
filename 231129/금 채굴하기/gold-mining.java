import java.io.*;
import java.util.*;

public class Main {

    static int n,m,ans;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[n][n];
        int total = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1)
                    total++;
            }
        }

        int k = 0;
        boolean endFlag = false;
        while(true) {
            int cost = k * k + (k+1)*(k+1);

            for(int x = 0; x < n; x++) {
                for(int y = 0; y < n; y++) {
                    int gold = 0;
                    for(int i = -k; i <= k; i++) {
                        for(int j = -(k-Math.abs(i)); j <= (k-Math.abs(i)); j++){
                            if(valid(x+i,y+j)) continue;
                            if(board[x+i][y+j]==1)
                                gold++;
                        }
                    }

                    if(gold == total)
                        endFlag = true;

                    if(cost <= m * gold) {
                        ans = ans > gold ? ans : gold;
                    }

                }
            }
            if(endFlag)
                break;
            
            k++;
        }

        System.out.println(ans);

    }

    static boolean valid(int x, int y) {
        return x < 0 || y < 0 || n <= x || n <= y;
    }

}