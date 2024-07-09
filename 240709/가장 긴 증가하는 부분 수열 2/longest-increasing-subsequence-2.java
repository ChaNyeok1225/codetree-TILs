import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int len = 0;
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());

        int value;
        int l, r, mid = 0;
        for(int i = 0; i < n; i++) {
            value = Integer.parseInt(st.nextToken());

            if(len - 1 < 0 || arr[len - 1] < value) {
                arr[len++] = value;
            } else {
                l = 0;
                r = len - 1;

                while(l <= r) {
                    mid = l + (r - l) / 2;

                    if(arr[mid] <= value) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }

                }

                arr[l] = value;
            }
        }

        System.out.println(len);
    }
}