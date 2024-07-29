import java.util.*;
import java.io.*;

public class Main {

    static int n, m, ans;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ans = 0;
        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                down(i, j, 0, Integer.MAX_VALUE);
            }
        }

        System.out.println(ans);

    }

    static void down(int r, int c, int h, int minW) {
        if(valid(r, c))
            return;
        h++;

        int w = 0;
        for(int i = c; i < m; i++) {
            if(arr[r][i] > 0)
                w++;
            else   
                break;
        }

        minW = minW < w ? minW : w;
        int area = h * minW; 
        ans = ans > area ? ans : area;

        down(r+1, c, h, minW);
    }

    static boolean valid(int r, int c) {
        if(r >= n || c >= m || arr[r][c] <= 0)
            return true;
        return false;
    }
}