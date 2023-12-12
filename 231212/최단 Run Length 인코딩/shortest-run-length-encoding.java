import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();
        int len = str.length();
        boolean[] vis = new boolean[len];
        int res = 0;

        for(int i = 0; i < len; i++) {
            if(vis[i]) continue;

            int idx = i;
            char c = str.charAt(idx);
            vis[idx] = true;
            int cnt = 1;

            for(int j = 1; j < len; j++) {
                int tmp = (idx + j) % len;
                if(str.charAt(tmp) != c || vis[tmp])
                    break;
                vis[tmp] = true;
                cnt++;
            }   


            for(int j = 1; j < len; j++) {
                int tmp = (len + idx - j) % len;
                if(str.charAt(tmp) != c || vis[tmp])
                    break;
                vis[tmp] = true;
                cnt++;
            }   

            res += 1 + String.valueOf(cnt).length();
        }

        System.out.println(res);        
        
    }
}