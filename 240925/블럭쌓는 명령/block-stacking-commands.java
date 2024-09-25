import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] num = new int[n+2];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            num[s]++;
            num[t+1]--;
        }

        int[] cnt = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += num[i+1];
            cnt[i] = sum;
        }

        Arrays.sort(cnt);
        System.out.print(cnt[n/2]);

    }
}