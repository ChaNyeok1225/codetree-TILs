import java.io.*;
import java.util.*;

public class Main {

    static List<Rect> list = new ArrayList<>();
    static int[] sel = new int[2];
    static boolean[][] vis;
    static int[][] board;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        vis = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0 ; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int sx = 0; sx < n; sx++) {
            for(int sy = 0; sy < m; sy++) {
                for(int ex = sx; ex < n; ex++) {
                    for(int ey = sy; ey < m; ey++) {
                        list.add(new Rect(sx, sy, ex, ey));
                    }
                }
            }
        }
        
        selectRect(0, 0);

        System.out.println(ans);
        
    }

    static void selectRect(int cnt, int idx) {
        if(cnt == 2) {

            chkRange(sel[0], sel[1]);

            return ;
        }   

        for(int i = idx; i < list.size(); i++) {
            sel[cnt] = i;
            selectRect(cnt+1, i+1);
        }

    }

    static void chkRange(int idx1, int idx2) {
        Rect r1 = list.get(idx1);
        Rect r2 = list.get(idx2);
        int sum = 0;
        for(int i = 0; i < vis.length; i++)
            Arrays.fill(vis[i], false);

        for(int i = r1.sx; i <= r1.ex; i++) {
            for(int j = r1.sy; j <= r1.ey; j++) {
                sum += board[i][j];
                vis[i][j] = true;
            }
        }

        for(int i = r2.sx; i <= r2.ex; i++) {
            for(int j = r2.sy; j <= r2.ey; j++) {
                sum += board[i][j];
                if(vis[i][j])
                    return;
            }
        }

        ans = ans > sum ? ans : sum;
    }

}



class Rect {
    int sx;
    int sy;
    int ex;
    int ey;

    Rect(int a, int b, int c, int d) {
        sx = a;
        sy = b;
        ex = c;
        ey = d;
    }

}