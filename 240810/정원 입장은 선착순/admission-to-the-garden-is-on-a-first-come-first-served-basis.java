import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        int curIdx = 0;
        int curTime = arr[curIdx][1];
        pq.offer(arr[curIdx]);
        curIdx++;

        int ans = 0;
        int[] cur;
        while(!pq.isEmpty()) {
            cur = pq.poll();

            if(curTime < cur[1])
                curTime = cur[1];
            ans = ans > curTime - cur[1] ? ans : curTime - cur[1];
            curTime += cur[2];

            while(curIdx < n && curTime >= arr[curIdx][1] || pq.isEmpty()) {
                pq.offer(arr[curIdx]);
                curIdx++;
            }
        }

        System.out.println(ans);
    }
}