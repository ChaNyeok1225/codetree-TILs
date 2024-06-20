import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int e = 0, sum = 0;
        for(int i = 0; i < n; i++) {
            while(e < n && sum < s) {
                sum += arr[e++];
            }
            if(sum >= s) {
                if(e - i < answer)
                    answer = e - i;
            }
            sum -= arr[i];
        }

        if(answer == Integer.MAX_VALUE)
            answer = -1;
        System.out.println(answer);
    }
}