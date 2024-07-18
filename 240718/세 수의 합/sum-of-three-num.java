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
        for(int i = 0; i < n - 2; i++) {

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            for(int j = i + 2; j < n; j++) {
                sum = k - (arr[i+1] + arr[j]);
                ans += map.getOrDefault(sum, 0);
            }
            
        }

        System.out.println(ans);

    }
}