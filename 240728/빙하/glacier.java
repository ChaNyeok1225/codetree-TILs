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

        int[][] map = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            } 
        }

        ArrayDeque<int[]>[] q = new ArrayDeque[2];
        q[0] = new ArrayDeque<>();
        q[1] = new ArrayDeque<>();

        vis[0][0] = true;
        q[0].offer(new int[] {0, 0});

        int seq = 0, cnt = 0, size = 0, nr, nc;
        int[] cur, dr = {1,0,-1,0}, dc = {0,1,0,-1};

        while(true) {
            size = q[seq].size();

            while(!q[seq].isEmpty()) {
                cur = q[seq].poll();

                for(int dir = 0; dir < 4; dir++) {
                    nr = cur[0] + dr[dir];
                    nc = cur[1] + dc[dir];

                    if(nr < 0 || nr >= n || nc < 0 || nc >= m || vis[nr][nc])
                        continue;
                    
                    if(map[nr][nc] == 1)
                        q[seq ^ 1].offer(new int[] {nr,nc});
                    else 
                        q[seq].offer(new int[] {nr, nc});
                    
                    vis[nr][nc] = true;
                }
            } 
        
            seq = seq ^ 1;
            if(q[seq].isEmpty())
                break;
            cnt++;
        }
        

        System.out.println(cnt + " " + size);
        
    }
}