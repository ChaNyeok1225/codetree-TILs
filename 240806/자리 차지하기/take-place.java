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

        for(int i = 1; i <= m; i++) {
            set.add(i);
        }
        
        st = new StringTokenizer(br.readLine());
        int ans = 0;
        Integer remains;
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            remains = set.floor(num);

            if(remains == null) {
                break;
            }
            set.remove(remains);
            ans++;
        }

        System.out.println(ans);
    }
}