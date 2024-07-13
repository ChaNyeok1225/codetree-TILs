import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(maxHeap.isEmpty() || num < maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            int s = i / 2 + 1;
            while(maxHeap.size() != s) {
                if(maxHeap.size() < s) {
                    maxHeap.offer(minHeap.poll());
                } else {
                    minHeap.offer(maxHeap.poll());
                }
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb);

    }
}