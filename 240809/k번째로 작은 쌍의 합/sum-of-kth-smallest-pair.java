import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return (arr1[a[0]] + arr2[a[1]]) - (arr1[b[0]] + arr2[b[1]]);
        });

        for(int i = 0; i < n; i++) {
            pq.offer(new int[] {i, 0});
        }

        int[] cur = new int[2];
        while(k-- > 0) {
            cur = pq.poll();
            if(cur[1] < m - 1)
                pq.offer(new int[] {cur[0], cur[1] + 1});
        };
        
        System.out.println(arr1[cur[0]] + arr2[cur[1]]);
        
    }
}