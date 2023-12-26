import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        long n = Integer.parseInt(br.readLine());
        long k = Integer.parseInt(br.readLine());

        long start = 1, end = n * n, mid;
        long ans = 0;

        while(start <= end) {
            mid = start + (end - start) / 2;

            long cnt = 0, value;
            for(long i = 1; i < n + 1; i++) {
                value = mid / i;
                cnt += n < value ? n : value;
            }

            if (cnt < k) {
                start = mid + 1;
            } else if (cnt >= k) {
                end = mid - 1;
                ans = mid;
            }

        }
        System.out.println(ans);
        
    }
}