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

        Integer n1, n2, tmp;

        n1 = set.first();
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            n2 = set.ceiling(n1 + m);
            if(n2 != null && n2 - n1 < ans) {
                ans = n2 - n1;
            }
            n1 = set.higher(n1);
        }

        System.out.println(ans);

    }
}