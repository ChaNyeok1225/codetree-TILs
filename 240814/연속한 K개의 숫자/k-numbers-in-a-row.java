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
        int b = Integer.parseInt(st.nextToken());

        boolean[] num = new boolean[n+1];
        for(int i = 0; i < b; i++) {
            num[Integer.parseInt(br.readLine())] = true;
        }

        int[] arr = new int[n+1];
        int ans = k, cur = k;
        for(int i = 1; i <= n; i++) {
            if(!num[i]) 
                cur--;
            
            if(i >= k) {
                ans = ans < cur ? ans : cur;

                if(!num[i - k + 1]) {
                    cur++;
                }
            }
        }   

        System.out.println(ans);
    }
}