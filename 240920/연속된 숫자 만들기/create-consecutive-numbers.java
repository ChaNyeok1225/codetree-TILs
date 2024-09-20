import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int[] point = new int[3];
        point[0] = Integer.parseInt(st.nextToken());
        point[1] = Integer.parseInt(st.nextToken());
        point[2] = Integer.parseInt(st.nextToken());
        Arrays.sort(point);

        int diff1 = Math.abs(point[1]-point[0]);
        int diff2 = Math.abs(point[1]-point[2]);

        int dmax = Math.max(diff1,diff2);
        int dmin = Math.min(diff1,diff2);

        if(dmin > 2 || (dmin == 1 && dmax > 2)) {
            sb.append("2");
        } else if (diff1 == 1 && diff2 == 1){
            sb.append("0");
        } else {
            sb.append("1");
        } sb.append("\n");
        sb.append(dmax - 1);

        System.out.println(sb);

    }
}