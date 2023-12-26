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

        long[][] lines = new long[m][2];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Long.parseLong(st.nextToken());
            lines[i][1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(lines, (a,b) -> Long.compare(a[0],b[0]));

        long start = 1, end = lines[m-1][1] - lines[0][0], mid;
        long ans = 0;

        while(start <= end) {
            mid = start + (end - start) / 2;

            long cnt = 0;
            for(int i = 0; i < m; i++) 
                cnt += (( lines[i][1] - lines[i][0] ) / mid ) + 1;
            if(cnt >= n) {
                start = mid + 1;
                ans = mid;
            } else
             end = mid - 1;

        }
        
        System.out.println(ans);
        
    }
}