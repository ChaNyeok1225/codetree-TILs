import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[] sel;
    static int[][] rules;
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        sel = new char[n];
        rules = new int[k][3];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            char ins = st.nextToken().charAt(0);
            rules[i][0] = ins == 'S' ? 0 : 1;
            rules[i][1] = Integer.parseInt(st.nextToken()) - 1;
            rules[i][2] = Integer.parseInt(st.nextToken()) - 1;
        }

        dfs(0, n);

        System.out.println(answer);
    }

    static void dfs(int idx, int size) {
        if(idx == size) {

            for(int i = 0; i < rules.length; i++) {
                if(rules[i][0] == 0) {
                    if(sel[rules[i][1]] != sel[rules[i][2]])
                        return;
                } else {
                    if(sel[rules[i][1]] == sel[rules[i][2]])
                        return;
                }
            }

            answer++;
            return;
        }

        for(int i = 0; i < 3; i++) {
            sel[idx] = (char)(i + 'A');
            dfs(idx+1, size);
        }
    }
}