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

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) 
            nums[i] = Integer.parseInt(st.nextToken());
        
        int start, end,mid, sidx = 0, eidx = 0;
        for(int i = 0; i < m; i++) {
            int value = Integer.parseInt(br.readLine());

            start = 0;
            end = n-1;
            sidx = eidx = n;

            while(start <= end) {
                mid = start + (end - start)/2;

                if(nums[mid] >= value) {
                    end = mid - 1;
                    sidx = mid;
                }
                else
                    start = mid + 1;
            }

            start = 0;
            end = n-1;

            while(start <= end) {
                mid = start + (end - start)/2;

                if(nums[mid] > value) {
                    end = mid - 1;
                    eidx = mid;
                }
                else 
                    start = mid + 1;
                
            }

            sb.append(eidx - sidx).append("\n");
        }

        System.out.print(sb);
        
    }
}