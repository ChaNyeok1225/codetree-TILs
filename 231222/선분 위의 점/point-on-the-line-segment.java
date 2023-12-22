import java.io.*;
import java.util.*;

public class Main {

    static int[] points;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        points = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)  
            points[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(points);

        int start, end, mid, sl, el, sidx, eidx;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            sl = Integer.parseInt(st.nextToken());
            el = Integer.parseInt(st.nextToken());

            sidx = lowerBound(sl, 0, n-1);
            eidx = upperBound(el, 0, n-1);

            sb.append(eidx-sidx).append("\n");
        }
        System.out.print(sb);
        
    }

    static int lowerBound(int val, int start, int end) {
        int mid;
        int idx = end+1;

        while(start <= end) {
            mid = start + (end - start) / 2;

            if(points[mid] < val) {
                start = mid + 1;
            } else {
                end = mid - 1;
                idx = mid;
            }
        }

        return idx;
    }

    static int upperBound(int val, int start, int end) {
        int mid;
        int idx = end+1;

        while(start <= end) {
            mid = start + (end - start) / 2;

            if(points[mid] <= val) {
                start = mid + 1;
            } else {
                end = mid - 1;
                idx = mid;
            }
        }

        return idx;
    }
}