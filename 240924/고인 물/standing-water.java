import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int answer = 0;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        int[] h = new int[m];
        for(int i = 0; i < m; i++) 
            h[i] = Integer.parseInt(st.nextToken());
        
        int l = 0, r = m - 1, acc;

        acc = 0;
        for(int i = 0; i < m; i++) {
            if(h[l] <= h[i]) {
                l = i;
                answer += acc;
                acc = 0;
                continue;
            }
            acc += h[l] - h[i];
        }

        for(int i = m - 1; i >= l; i--) {
            if(h[r] <= h[i]) {
                r = i;
                continue;
            }
            answer += h[r] - h[i];
        }

        System.out.println(answer);

    }
}