import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        sb.append(st.nextToken());
        sb.setLength(3);
        sb.append(str);

        System.out.println(sb);

    }
}