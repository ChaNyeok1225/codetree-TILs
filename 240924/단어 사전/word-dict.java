import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        TreeSet<String> set = new TreeSet<>();
        while(st.hasMoreTokens()) {
            set.add(st.nextToken());
        }

        for(String str : set) {
            sb.append(str).append(' ');
        }
        System.out.println(sb);
    }
}