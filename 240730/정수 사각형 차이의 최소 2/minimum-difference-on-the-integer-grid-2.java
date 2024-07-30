import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
    
        int[][] arr = new int[n][n];
        int min = Integer.MAX_VALUE, max = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = min < arr[i][j] ? min : arr[i][j];
                max = max > arr[i][j] ? max : arr[i][j];
            }
        }

        int l, r, mid, ans = Integer.MAX_VALUE, nr, nc;
        int[] e, dr = {1,0}, dc = {0,1};
        boolean pass;
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for(int i = min; i <= max; i++) {
            l = i;
            r = max;
            while(l <= r) {
                mid = l + (r - l) / 2;
                pass = false;

                if(arr[0][0] >= i && arr[0][0] <= (i+mid)) {
                    q.offer(new int[] {0, 0});
                }

                while(!q.isEmpty()) {
                    e = q.poll();
                    if(e[0] == n - 1 && e[1] == n - 1) {
                        pass = true;
                    }
                    
                    for(int dir = 0; dir < 2; dir++) {
                        nr = e[0] + dr[dir];
                        nc = e[1] + dc[dir];

                        if(nr >= n || nc >= n || arr[nr][nc] > (i+mid) || arr[nr][nc] < i) {
                            continue;
                        }

                        q.offer(new int[] {nr, nc});
                    }
                }

                if(pass) {
                    r = mid - 1;
                    ans = ans < mid ? ans : mid;
                } else {
                    l = mid + 1;
                }
            }
        }
    
        System.out.println(ans);
    }
}