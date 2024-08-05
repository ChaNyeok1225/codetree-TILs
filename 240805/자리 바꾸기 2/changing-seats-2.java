import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n+1];
        HashSet<Integer>[] set = new HashSet[n+1];
        for(int i = 1; i < n + 1; i++) {
            arr[i] = i;
            set[i] = new HashSet<>();
            set[i].add(i);
        }

        int[][] change = new int[k][2];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            change[i][0] = Integer.parseInt(st.nextToken());
            change[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int t = 0; t < 3; t++) {
            for(int i = 0; i < k; i++) {
                set[arr[change[i][0]]].add(change[i][1]);
                set[arr[change[i][1]]].add(change[i][0]);

                int tmp = arr[change[i][0]];
                arr[change[i][0]] = arr[change[i][1]];
                arr[change[i][1]] = tmp;
            }
        }

        for(int i = 1; i < n + 1; i++) {
            sb.append(set[i].size()+"\n");
        }

        System.out.print(sb);

    }
}