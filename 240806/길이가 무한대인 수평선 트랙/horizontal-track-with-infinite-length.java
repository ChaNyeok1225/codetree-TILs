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

        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a,b) -> {
            if(a[0] == b[0])
                return b[1] - a[1];
            return b[0] - a[0];
        });

        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            int point = arr[i][0] + arr[i][1] * t;

            Integer p = set.floor(point);

            if(p != null && arr[i][0] <= p) {
                point = p;
            }

            set.add(point);
        }   

        System.out.println(set.size());

    }
}