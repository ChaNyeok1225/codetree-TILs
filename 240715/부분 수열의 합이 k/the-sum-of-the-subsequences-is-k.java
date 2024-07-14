import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, j = 0, ans = 0;
        for(int i = 0; i < n; i++) {

            while(j < n && sum < k) {
                sum+=arr[j++];
            }
            if(sum == k) {
                ans++;
            }

            sum -= arr[i];
        }

        System.out.println(ans);
    }
}