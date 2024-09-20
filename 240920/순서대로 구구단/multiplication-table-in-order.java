import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int step = a > b ? -1 : 1;

        for(int i = 1; i < 10; i++) {
            for(int x = a; x != b + step; x += step) {
                sb.append(x).append(" * ").append(i).append(" = ").append(x*i).append("  ");
            }sb.append("\n");
        }

        System.out.println(sb);

    }
}