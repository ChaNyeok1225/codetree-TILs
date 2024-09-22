import java.io.*;
import java.util.*;

public class Main {

    static int answer, total;
    static int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
    static boolean[][] map, vis;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        map = new boolean[5][5];
        vis = new boolean[5][5];

        int k = Integer.parseInt(br.readLine());
        total = 25 - k;
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = true;
        }

        dfs(0, 0, 4, 4, 0);

        System.out.println(answer);
    }

    static void dfs(int ar, int ac, int br, int bc, int cnt) {
        if(vis[ar][ac] || vis[br][bc])
            return;
        
        if(ar == br && ac == bc) {
            if(cnt + 1 == total) {
                answer++;
            }
            return;
        }
        vis[ar][ac] = true;
        vis[br][bc] = true;
        cnt+=2;

        int nar, nac, nbr, nbc;
        for(int ad = 0; ad < 4; ad++) {

            for(int bd = 0; bd < 4; bd++) {
                
                nar = ar + dr[ad];
                nac = ac + dc[ad];
                nbr = br + dr[bd];
                nbc = bc + dc[bd];

                if(invalid(nar,nac) || invalid(nbr, nbc))
                    continue;
                if(map[nar][nac] || map[nbr][nbc])
                    continue;
                
                dfs(nar, nac, nbr, nbc, cnt);
            }

        }

        vis[ar][ac] = false;
        vis[br][bc] = false;
    }

    static boolean invalid(int r, int c) {
        return r < 0 || r > 4 || c < 0 || c > 4;
    }
}