import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dpa = new int[n];
        int[] dpd = new int[n];

        for(int i = 0; i < n; i++) {
            dpa[i] = 1;

            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dpa[i] = dpa[i] > dpa[j] + 1 ? dpa[i] : dpa[j] + 1;
                } 
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            dpd[i] = 1;
            for(int j = n - 1; j > i; j--) {
                if(arr[i] > arr[j]) {
                    dpd[i] = dpd[i] > dpd[j] + 1 ? dpd[i] : dpd[j] + 1;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = ans > dpa[i] + dpd[i] - 1 ? ans : dpa[i] + dpd[i] - 1;
        }
        
        System.out.println(ans);
    }
}