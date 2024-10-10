import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());

        double ar = Math.sqrt(a);
        double br = Math.sqrt(b);

        if(ar > br) {
            double tmp = ar;
            ar = br;
            br = tmp;
        }

        double num = Math.ceil(ar);

        int answer = 0;
        for(; num < br; num += 1) {
            answer++;
        }

        System.out.println(answer);
    }
}