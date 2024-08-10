import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        int[][] arr = new int[n][];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[i] = new int[] {i, a, t};
        }

        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        int curIdx = 0;
        int curTime = arr[curIdx][1];
        pq.offer(new int[] {arr[curIdx][0], arr[curIdx][1], arr[curIdx][2]});
        curIdx++;

        int ans = 0;
        int[] cur;
        while(!pq.isEmpty()) {
            cur = pq.poll();

            if(cur != null) {
                if(curTime < cur[1])
                    curTime = cur[1];
                ans = ans > curTime - cur[1] ? ans : curTime - cur[1];
                curTime += cur[2];
            }

            while(curIdx < n && curTime >= arr[curIdx][1]) {
                pq.offer(new int[] {arr[curIdx][0], arr[curIdx][1], arr[curIdx][2]});
                curIdx++;
            }
            if(curIdx < n && pq.isEmpty()) {
                pq.offer(new int[] {arr[curIdx][0], arr[curIdx][1], arr[curIdx][2]});
                curIdx++;
            }
        }

        System.out.println(ans);
    }
}