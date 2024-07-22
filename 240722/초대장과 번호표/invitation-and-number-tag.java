import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] join = new ArrayList[n+1];
        TreeSet<Integer>[] group = new TreeSet[g];
        for(int i = 1; i < n + 1; i++) {
            join[i] = new ArrayList<>();
        }

        int pn, m;
        for(int i = 0; i < g; i++) {
            group[i] = new TreeSet<>();

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());

            for(int j = 0; j < m; j++) {
                pn = Integer.parseInt(st.nextToken());    
                join[pn].add(i);
                group[i].add(pn);
            }
        }

        boolean[] vis = new boolean[n+1];        

        ArrayDeque<Integer> q = new ArrayDeque<>();
        vis[1] = true;
        q.offer(1);

        int cur;
        int ans = 0;
        while(!q.isEmpty()) {
            cur = q.poll();
            ans++;
            for(int joinGroup : join[cur]) {
                group[joinGroup].remove(cur);

                if(group[joinGroup].size() == 1) {
                    int nxt = group[joinGroup].pollFirst();
                    q.offer(nxt);
                    vis[nxt] = true;
                }
            }
        }

        System.out.println(ans);

    }
}