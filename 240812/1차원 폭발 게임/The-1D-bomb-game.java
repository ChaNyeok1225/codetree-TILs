import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 2];
        int[] acc = new int[n + 2];
        for(int i = n; i >= 1; i--) {
            arr[i] = Integer.parseInt(br.readLine());
        } 

        int remain = n;
        while(true) {
            int cnt = 0;
            for(int i = 1; i <= n; i++) {
                if(arr[i] > 0 && arr[i] == arr[i-1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }

                acc[i] = cnt;
            }

            boolean flag = false;
            boolean endflag = true;
            for(int i = n; i >= 1; i--) {
                if(acc[i] >= m) {
                    flag = true;
                } else if(acc[i] != acc[i + 1] - 1) {
                    flag = false;
                }

                if(flag) {
                    arr[i] = 0;
                    remain--;
                    endflag = false;
                }
            }

            if(endflag)
                break;

            int land = 1;
            for(int i = 1; i <= n; i++) {
                if(arr[i] > 0) {
                    arr[land] = arr[i];
                    if(i != land++)
                        arr[i] = 0;
                }
            } 
            n = remain;
        }

        System.out.println(remain);

        for(int i = remain; i >= 1; i--) {
            System.out.println(arr[i]);
        }
    }
}