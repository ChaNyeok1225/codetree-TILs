import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {

            int m = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> minH = new PriorityQueue<>();
            PriorityQueue<Integer> maxH = new PriorityQueue<>((a,b) -> b - a);

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < m; i++) {

                int num = Integer.parseInt(st.nextToken());

                if(maxH.isEmpty() || maxH.peek() > num) {
                    maxH.offer(num);
                } else {
                    minH.offer(num);
                }

                
                while(maxH.size() > ((i + 1) / 2) + 1) {
                    minH.offer(maxH.poll());
                } 
                while(maxH.size() < ((i+1) / 2) + 1) {
                    maxH.offer(minH.poll());
                }

                if((i & 1) == 0)
                    sb.append(maxH.peek() + " ");
            }

            sb.append("\n");
        }

        System.out.print(sb);

    }
}