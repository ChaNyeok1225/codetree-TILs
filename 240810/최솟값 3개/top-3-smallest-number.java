import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        int total = 1;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());            
            pq.offer(num);
            total *= num;

            if(i < 2) {
                sb.append(-1);
            } else {
                if(i > 2)
                    total /= pq.poll();
                sb.append(total);
            }

            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}