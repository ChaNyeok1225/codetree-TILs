import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        long m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long s = Integer.parseInt(st.nextToken());
        long e = Integer.parseInt(st.nextToken());

        long start, end, mid = 0, cnt = 0;
        long min = Integer.MAX_VALUE, max = 0;
        for(long i = s; i <= e; i++) {

            start = 1;
            end = m;
            cnt = 0;
            while(start <= end) {
                mid = start + (end - start) / 2;
                cnt++;
                if(mid == i) {
                    min = min < cnt ? min : cnt;
                    max = max > cnt ? max : cnt;
                    break;
                }
                else if(mid < i) 
                    start = mid + 1;
                else
                    end = mid - 1;
            }   
        }

        System.out.println(min + " " + max);

    }
}