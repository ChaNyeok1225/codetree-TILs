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

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start, end, mid, idx;
        for(int i = 0; i < m; i++) {
            int value = Integer.parseInt(st.nextToken());
            
            start = 0;
            end = n-1;
            idx = n;

            while(start <= end) {
                mid = start + (end - start)/2;

                if(nums[mid] >= value) {
                    end = mid - 1;
                    idx = mid;
                }
                else 
                    start = mid + 1;
            }
            if(idx == n || nums[idx] != value)
                idx = -2;
            sb.append(idx+1).append("\n");
        }

        System.out.println(sb);
    }
}