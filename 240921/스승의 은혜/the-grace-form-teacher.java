import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] info = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(info, (o1,o2) -> {
            if(o1[0] + o1[1] == o2[0] + o2[1])
                return o1[0] - o2[0];
            return (o1[0] + o1[1]) - (o2[0] + o2[1]);
        });

        int total = 0;
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(b >= total + info[i][0] + info[i][1]) {
                total += info[i][0] + info[i][1];
                answer++;
            } else {
                if(b >= total + info[i][0] / 2 + info[i][1]) {
                    answer++;
                }
                break;                
            }
        }        

        System.out.println(answer);
        
    }
}