import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] count = new int[26];

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            char c = st.nextToken().charAt(0);

            if(c < 'a' || c > 'z')
                break;
            count[(int)(c-'a')]++;
        }

        for(int i = 0; i < 26; i++) {
            if(count[i] == 0)
                continue;
            sb.append((char)(i + 'a')).append(" : ").append(count[i]).append("\n");
        }
        System.out.println(sb);
    }
}