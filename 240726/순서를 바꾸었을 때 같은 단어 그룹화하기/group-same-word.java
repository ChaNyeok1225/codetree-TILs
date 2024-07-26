import java.util.*;
import java.io.*;
import java.util.Map.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        TreeMap<Character,Integer> map;
        HashMap<String, Integer> groupCnt = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            
            map = new TreeMap<>();
            sb.setLength(0);

            for(int j = 0; j < str.length(); j++) {
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
            }

            for(Entry<Character, Integer> entry : map.entrySet()) {
                sb.append(entry.getKey()+""+entry.getValue());
            }

            groupCnt.put(sb.toString(), groupCnt.getOrDefault(sb.toString(), 0) + 1);            
        }

        int ans = 0;
        for(int value : groupCnt.values()) {
            ans = ans > value ? ans : value;
        }

        System.out.println(ans);


    }
}