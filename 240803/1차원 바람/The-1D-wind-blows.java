import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static ArrayDeque<int[]> que;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
        boolean[] vis = new boolean[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        que = new ArrayDeque<>();

        int[] c;
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int dflag = "L".equals(st.nextToken()) ? 0 : 1;
            Arrays.fill(vis, false);
            
            vis[r] = true;
            que.offer(new int[] {r, dflag});

            while(!que.isEmpty()) {
                c = que.poll();

                lot(c[0], c[1], arr, vis);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }sb.append("\n");
        }
        System.out.println(sb);

    }

    static int[] chk = {1, -1};
    static void lot(int r, int dflag, int[][] arr, boolean[] vis) {
        int init = 0;
        int end = m - 1;
        int step = -1;

        if(dflag == 1) {
            init = m-1;
            end = 0;
            step = 1;
        }

        int tmp = arr[r][end];
        int nr;
        for(int i = end; i != init; i += step) {
            arr[r][i] = arr[r][i + step];
            
            for(int j = 0; j < 2; j++) {
                nr = r + chk[j];

                if(nr < 0 || nr >= n || vis[nr])
                    continue;
                
                if(arr[r][i] == arr[nr][i]) {
                    que.offer(new int[] {nr, dflag ^ 1});
                    vis[nr] = true;
                }
            }
        }
        arr[r][init] = tmp;
        for(int j = 0; j < 2; j++) {
            nr = r + chk[j];

            if(nr < 0 || nr >= n || vis[nr])
                continue;
            
            if(arr[r][init] == arr[nr][init]) {
                que.offer(new int[] {nr, dflag ^ 1});
                vis[nr] = true;
            }
        }
    }


}