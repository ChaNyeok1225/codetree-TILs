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

        long[][] line = new long[m][2];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Long.parseLong(st.nextToken());
            line[i][1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(line, (a,b) -> Long.compare(a[0],b[0]));


        long start = 1, end = line[m-1][1] - line[0][0];
        long mid;
        long ans = 0;

        while(start <= end) {
            mid = start + (end - start) / 2;

            long point = Long.MIN_VALUE;
            long cnt = 0;

            for(int i = 0; i < m; i++) {
                if(point + mid > line[i][1])
                    continue;
                
                if(point + mid > line[i][0]) {
                    point += mid;
                } else
                    point = line[i][0];
                cnt++;
                
                long dis = line[i][1] - point;
                long val = dis / mid;
                cnt += val;

                point += val * mid;
            }

            if(cnt >= n) {
                start = mid + 1;
                ans = mid;
            } else
             end = mid - 1;

        }
        

        System.out.println(ans);
        
    }
}