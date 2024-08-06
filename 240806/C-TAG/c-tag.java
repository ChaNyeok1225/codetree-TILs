import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] A = new char[n][];
        char[][] B = new char[n][];

        for(int i = 0; i < n; i++) {
            A[i] = br.readLine().toCharArray();
        }
        for(int i = 0; i < n; i++) {
            B[i] = br.readLine().toCharArray();
        }

        Set<String> set = new HashSet<>();

        int ans = 0;
        boolean flag = true;
        for(int i = 0; i < m - 2; i++) {
            for(int j = i + 1; j < m - 1; j++) {
                for(int k = j + 1; k < m; k++) {

                    for(int idx = 0; idx < n; idx++) {
                        set.add(A[idx][i] + "" + A[idx][j] + "" + A[idx][k]);
                    }

                    for(int idx = 0; idx < n; idx++) {
                        if(set.contains(B[idx][i] +""+B[idx][j]+""+B[idx][k])) {
                            flag = false;
                            break;
                        }
                    }

                    if(flag) {
                        ans++;
                    }

                    set.clear();
                    flag = true;
                }
            }
        }

        System.out.println(ans);
    }
}