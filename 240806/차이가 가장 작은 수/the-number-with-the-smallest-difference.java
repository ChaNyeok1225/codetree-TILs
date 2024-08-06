import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        TreeSet<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        Integer search;

        int ans = Integer.MAX_VALUE;
        for(int k : set) {
            search = set.ceiling(k + m);

            if(search != null && ans > k - search) {
                ans = k - search;
            }
        }

        if(ans == Integer.MAX_VALUE)
            ans = -1;
        System.out.println(ans);

    }
}