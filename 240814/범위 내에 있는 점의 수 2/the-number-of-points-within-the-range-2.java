import java.util.*;
import java.io.*;
import java.util.Map.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] point = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            point[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(point);

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            map.put(point[i], ++cnt);
        }

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            Entry<Integer, Integer> startEntry = map.lowerEntry(s);
            Entry<Integer, Integer> endEntry = map.floorEntry(e);

            s = startEntry == null ? 0 : startEntry.getValue();
            e = endEntry == null ? 0 : endEntry.getValue();
            sb.append(e - s + "\n");
        }

        System.out.println(sb);
    }
}