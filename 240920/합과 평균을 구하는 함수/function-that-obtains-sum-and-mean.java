import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        double n1 = Double.parseDouble(st.nextToken());
        double n2 = Double.parseDouble(st.nextToken());
        double n3 = Double.parseDouble(st.nextToken());

        int rn1 = (int)Math.round(n1);
        int rn2 = (int)Math.round(n2);
        int rn3 = (int)Math.round(n3);

        System.out.println(rn1 + rn2 + rn3);
        System.out.println((int)Math.round((rn1 + rn2 + rn3) / 3.0));



    }
}