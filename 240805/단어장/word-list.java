import java.util.*;
import java.io.*;
import java.util.Map.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        TreeMap<String, Integer> map = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for(Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey() + " " +entry.getValue() + "\n");
        }
        System.out.println(sb);
    }
}