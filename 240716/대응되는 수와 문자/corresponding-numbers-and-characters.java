import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        HashMap<String, Integer> sti = new HashMap<>();
        HashMap<Integer, String> its = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i <= n; i++) {
            String str = br.readLine();
            sti.put(str, i);
            its.put(i, str);
        }

        for(int i = 0; i < m; i++) {
            String str = br.readLine();

            if(Character.isDigit(str.charAt(0))) {
                sb.append(its.get(Integer.parseInt(str))); 
            } else {
                sb.append(sti.get(str));
            }sb.append("\n");
        }

        System.out.println(sb);

    }
}