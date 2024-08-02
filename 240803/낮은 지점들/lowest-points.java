import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<Integer,Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            if(map.getOrDefault(x, Integer.MAX_VALUE) > y) {
                map.put(x, y);
            }
        }

        long ans = 0;
        for(int val : map.values())
            ans += val;
        
        System.out.println(ans);
        
    }
}