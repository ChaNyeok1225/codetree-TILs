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

        long[] times = new long[m];
        long max = 0;
        for(int i = 0; i < m; i++) {
            times[i] = Integer.parseInt(br.readLine());
            max = max > times[i] ? max : times[i];
        }

        long start = 1, end = max * n, mid;
        long ans = 0;

        while(start <= end) {
            mid = start + (end - start) / 2;
            
            long cnt = 0;
            for(int i = 0; i < m; i++) 
                cnt += mid / times[i];
            
            if(cnt >= n) {
                end = mid - 1;
                ans = mid;
            } else
                start = mid + 1;
        } 
        
        System.out.println(ans);
        
    }
}