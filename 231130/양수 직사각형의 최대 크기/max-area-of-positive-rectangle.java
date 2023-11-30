import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int[][] xrect = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int ans = -1;
        int max = -1;
        int val = 0;
        for(int i = 0; i < n; i++) {
            val = 1;
            for(int j = 0; j < m; j++) {
                if(board[i][j] <= 0)
                    val = 1;
                else {
                    xrect[i][j] = val++;
                    max = max > xrect[i][j] ? max : xrect[i][j];
                }
            }
        }

        int cnt = 0;
        int mcnt = 0;
        for(int k = 1; k < max + 1; k++) {
            mcnt = 0;
            for(int j = 0; j < m; j++) {
                cnt = 0;
                for(int i = 0; i < n; i++) {
                    if(xrect[i][j] >= k) {
                        cnt++;
                        mcnt = mcnt > cnt ? mcnt : cnt;
                    }
                    else {
                        cnt = 0;
                    }
                }
            }
            ans = ans > k * mcnt ? ans : k * mcnt;
        }

        System.out.println(ans);

    }
}