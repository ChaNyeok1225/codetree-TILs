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

        int size = 2 * n;

        int[] arr = new int[size];
        int p = 0;
        for(int d = 0; d < 2; d++) {
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[p + i] = Integer.parseInt(st.nextToken());
            }
            p = n;
        }

        t = t % (size);
        
        p = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[(j + p + size - t) % size] + " ");
            } System.out.println();
            p = n;
        }

    }
}