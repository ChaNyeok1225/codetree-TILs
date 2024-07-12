import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map = new HashMap<>();
        String[] dict = new String[n];
        for(int i = 0; i < n; i++) {
            dict[i] = br.readLine();
            map.put(dict[i], i+1);
        }
        Arrays.sort(dict);

        int idx, l, r, mid = 0;
        String str;
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            idx = Integer.parseInt(st.nextToken());
            str = st.nextToken();

            l = 0; r = n - 1;
            while(l <= r) {
                mid = l + (r - l) / 2;
                if(str.compareTo(dict[mid]) > 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            
            for(r = 0; r < idx; r++) {
                if(l + r >= n || !(dict[l+r].startsWith(str))) {
                    r = -1;
                    break;
                }
            }

            if(r == -1) {
                sb.append(-1);
            } else {
                sb.append(map.get(dict[l + r - 1]));
            }sb.append("\n");

        }
        

        System.out.println(sb);
    }

}