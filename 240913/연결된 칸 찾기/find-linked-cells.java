import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt, nr, nc;
        int[] cur, dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] != 1) continue;

                cnt = 0;
                map[i][j] = 0;
                q.offer(new int[] {i,j});

                while(!q.isEmpty()) {
                    cur = q.poll();
                    cnt++;
                    for(int d = 0; d < 4; d++) {
                        nr = cur[0] + dr[d];
                        nc = cur[1] + dc[d];

                        if(nr < 0 || nr >= n || nc < 0 || nc >= n)
                            continue;
                        if(map[nr][nc] != 1)
                            continue;
                        
                        map[nr][nc] = 0;
                        q.offer(new int[] {nr, nc});
                    }
                }

                pq.offer(cnt);
            }
        }
    
        sb.append(pq.size() + "\n");
        while(!pq.isEmpty())
            sb.append(pq.poll() + "\n");
        System.out.print(sb);    
    }
}