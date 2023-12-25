import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        long n = Integer.parseInt(br.readLine());

        long start = 1, end = Integer.MAX_VALUE, mid, ans = 0;

        while(start <= end) {
            mid = start + (end - start) / 2;

            long mCnt = mid / 3 + mid / 5 - mid / 15;
            long digit = mid - mCnt;

            if(digit >= n) {
                end = mid - 1;
                ans = mid;
            } else
                start = mid + 1;
        }

        System.out.println(ans);
        
        
    }
}