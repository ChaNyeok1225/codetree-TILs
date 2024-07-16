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

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, ans = 0;
        for(int i = 2; i < n; i++) {
        
            for(int j = 0; j < i - 1; j++) {
                sum = arr[i-1] + arr[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            ans += map.getOrDefault(k - arr[i], 0);
        }

        System.out.println(ans);

    }
}