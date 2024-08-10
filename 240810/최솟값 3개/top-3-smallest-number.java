import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        BigInteger bi = new BigInteger("1");

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            String num = st.nextToken();
            bi = bi.multiply(new BigInteger(num));
            pq.offer(Integer.parseInt(num));
            if(i < 2) {
                sb.append(-1);
            } else {
                if(i > 2) {
                    bi = bi.divide(new BigInteger(String.valueOf(pq.poll())));
                }
                sb.append(bi);
            }

            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}