import java.util.*;
import java.io.*;
import java.util.Map.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int num;
        for(int i = 0; i < n; i++) {
            num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1] == b[1])
                return b[0] - a[0];
            return b[1] - a[1];
        });

        for(Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[] {entry.getKey(), entry.getValue()});
        }

        for(int i = 0; i < k; i++) {
            sb.append(pq.poll()[0]).append(" ");
        }

        System.out.println(sb);

    }
}