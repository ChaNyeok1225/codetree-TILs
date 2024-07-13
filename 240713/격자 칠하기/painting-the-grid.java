import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        boolean[][] vis = new boolean[n][n];

        int half = (int)Math.ceil(n * n / 2.0);
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = min < map[i][j] ? min : map[i][j];
                max = max > map[i][j] ? max : map[i][j];
            }
        }

        int l = 0, r = max - min, mid = 0;
        int cnt;
        boolean seq = true;
        while(l <= r) {
            mid = l + (r - l) / 2;

            cnt = bfs(map, vis, seq, mid, n);
 
            if(cnt >= half) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

            seq = !seq;
        }

        System.out.println(mid);
        
    }

    static int bfs(int[][] map, boolean[][] vis, boolean seq, int mid, int n) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int cnt, ret = 0, val;
        int[] cur, dr = {1,0,-1,0}, dc = {0,1,0,-1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(vis[i][j] == seq) continue;

                vis[i][j] = !vis[i][j];
                q.offer(new int[] {i, j});
                cnt = 1;

                while(!q.isEmpty()) {
                    cur = q.poll();
                    val = map[cur[0]][cur[1]];

                    for(int dir = 0; dir < 4; dir++) {
                        int nr = cur[0] + dr[dir];
                        int nc = cur[1] + dc[dir];

                        if(nr < 0 || nr >= n || nc < 0 || nc >= n)
                            continue;
                        if(vis[nr][nc] == seq || Math.abs(val - map[nr][nc]) > mid)
                            continue;

                        vis[nr][nc] = seq;
                        q.offer(new int[] {nr, nc});
                        cnt++;
                    }
                }

                ret = ret > cnt ? ret : cnt;

            }
        }

        return ret;
    }

}