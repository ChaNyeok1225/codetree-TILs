import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());

        boolean[][] point = new boolean[101][101];

        int answer = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int w = x; w < x + 10; w++) {
                for(int h = y; h < y + 10; h++) {
                    if(point[w][h])
                        continue;
                    answer++;
                    point[w][h] = true;
                }
            }
        }

        System.out.println(answer);
    }
}