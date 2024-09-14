import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer>[] map = new TreeMap[20001];
        for(int i = 0; i < 20001; i++)
            map[i] = new TreeMap<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken()) + 10000;
            int y1 = Integer.parseInt(st.nextToken()) + 10000;
            int x2 = Integer.parseInt(st.nextToken()) + 10000;
            int y2 = Integer.parseInt(st.nextToken()) + 10000;

            for(int x = x1; x <= x2 - 1; x++) {
                map[x].put(y2, map[x].getOrDefault(y2, 0) + 1);
                map[x].put(y1, map[x].getOrDefault(y1, 0) - 1);
            }
        }
        
        int answer = 0;
        for(int i = 0; i < 20001; i++) {
            int cnt = 0;
            int sy = 0;

            for(Map.Entry<Integer, Integer> entry : map[i].entrySet()) {
                if(cnt == 0) 
                    sy = entry.getKey();
                cnt += entry.getValue();
                if(cnt == 0) 
                    answer += entry.getKey() - sy;
            }

        }

        System.out.println(answer);
    }
}