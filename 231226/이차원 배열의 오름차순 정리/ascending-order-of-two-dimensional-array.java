import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int start = 1, end = n * n, mid;
        int ans = 0;

        while(start <= end) {
            mid = start + (end - start) / 2;

            int cnt = 0, value;
            for(int i = 1; i < n + 1; i++) {
                value = mid / i;
                cnt += n < value ? n : value;
            }

            if(cnt == k) {
                ans = mid;
                break;
            } else if (cnt < k) {
                start = mid + 1;
            } else if (cnt > k) {
                end = mid - 1;
            }

        }
        System.out.println(ans);
        
    }
}