import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] points = new int[n];
        for(int i = 0; i < n; i++)
            points[i] = Integer.parseInt(br.readLine());

        Arrays.sort(points);

        int start = 1, end = points[n-1] - points[0], mid;
        int ans = 0;

        while(start <= end) {
            mid = start + (end - start) / 2;

            int cnt = 1;
            int point = points[0];
            for(int i = 1; i < n; i++) {
                if(points[i] - point >= mid) {
                    cnt++;
                    point = points[i];
                }
            }

            if(cnt >= m) {
                start = mid + 1; 
                ans = mid;
            } else
                end = mid - 1;

        }
        
        System.out.println(ans);
        
    }
}