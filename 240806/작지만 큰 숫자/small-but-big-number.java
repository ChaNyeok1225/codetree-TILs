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

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        Integer in;
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            in = set.floor(num);
            if(in != null) {
                set.remove(in);
            } else {
                in = -1;
            }

            sb.append(in).append("\n");
        }

        System.out.print(sb);
    }
}