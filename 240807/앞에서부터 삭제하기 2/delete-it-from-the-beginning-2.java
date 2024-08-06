import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }   

        double ans = 0;
        int total = arr[n-1];
        pq.offer(arr[n-1]);

        int cnt = 0;
        for(int i = n - 2; i > 0; i--) {
            cnt++;
            total += arr[i];
            pq.offer(arr[i]);

            ans = Math.max(ans, (total - pq.peek()) / (double)cnt);
        }
        System.out.printf("%.2f",ans);
    }
}