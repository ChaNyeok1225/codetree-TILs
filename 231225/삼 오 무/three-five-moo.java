import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int start = 1, end = 1_000_000_000, mid, ans = 0;

        while(start <= end) {
            mid = start + (end - start) / 2;

            
            int mCnt = mid / 3 + mid / 5 - mid / 15;
            int digit = mid - mCnt;

            if(digit >= n) {
                end = mid - 1;
                ans = mid;
            } else
                start = mid + 1;
        }

        System.out.println(ans);
        
        
    }
}