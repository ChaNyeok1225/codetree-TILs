import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

		long s = Long.parseLong(br.readLine());

		long start = 1;
		long end = s/2;
		long mid = 0;
		long ans = 0;
		while(start <= end) {
			mid = start + (end - start)/2;

			long value = mid * (mid+1) / 2;
			
			if(value <= s) {
				start = mid + 1;
				ans = mid;
			} else {
				end = mid - 1;
			}
		}

		System.out.println(ans);
        
        
    }
}