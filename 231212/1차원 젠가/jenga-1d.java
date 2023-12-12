import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        for(int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            int sidx = Integer.parseInt(st.nextToken());
            int eidx = Integer.parseInt(st.nextToken());

            int target = sidx-1;

            for(int j = 0; j <= eidx - sidx; j++) {
                list.remove(target);
            }
        }
        
        for(int i = 0; i < list.size(); i++)
            sb.append(list.get(i)).append("\n");

        System.out.println(list.size());
        System.out.println(sb);

    }
}