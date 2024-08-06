import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();
        set.add(-1);
        set.add(n + 1);

        TreeSet<int[]> distSet = new TreeSet<>((a,b) -> {
            if(a[1] == b[1])
                return a[0] - b[0];
            return b[1] - a[1];
        });
        distSet.add(new int[] {0, n + 1});

        int hn, ln;
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            ln = set.floor(num);
            hn = set.ceiling(num);

            distSet.remove(new int[] {ln + 1, (hn - 1) - (ln + 1) + 1});
            distSet.add(new int[] {ln + 1, (num - 1) - (ln + 1) + 1});
            distSet.add(new int[] {num + 1, (hn - 1) - (num + 1) + 1});

            sb.append(distSet.first()[1]).append("\n");
            set.add(num);
        }

        System.out.print(sb);
    }
}