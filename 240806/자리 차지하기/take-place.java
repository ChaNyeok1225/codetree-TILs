import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        TreeSet<int[]> set = new TreeSet<>((a,b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        Set<int[]> subSet;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        
        st = new StringTokenizer(br.readLine());
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            subSet = set.headSet(new int[] {num, n});
            if(subSet.size() == num) {
                break;
            }
            
            ans++;
            set.add(new int[] {num, i});
        }

        System.out.println(ans);
    }
}