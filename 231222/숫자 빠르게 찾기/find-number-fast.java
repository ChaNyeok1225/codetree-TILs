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

        int start, end, mid = 0;
        for(int i = 0; i < m; i++) {
            int value = Integer.parseInt(br.readLine());

            boolean flag = false;
            start = 0;
            end = n-1;

            while(start <= end) {
                mid = start + (end - start) / 2;

                if(nums[mid] == value) {
                    flag = true;
                    mid++;
                    break;
                }
                else if (nums[mid] < value)
                    start = mid + 1;
                else if (nums[mid] > value)
                    end = mid - 1;
            }
            if(!flag)
                mid = -1;

            sb.append(mid).append("\n");
        }

        System.out.print(sb);
        
        
    }
}