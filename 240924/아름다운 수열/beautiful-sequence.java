import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());
        int[] num = new int[n];
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine().trim());
        }

        int m = Integer.parseInt(br.readLine().trim());
        int[] bnum = new int[m];
        for(int i = 0; i < m; i++) {
            bnum[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(bnum);
        int[] bchange = new int[m];
        for(int i = 1; i < m; i++) {
            bchange[i] = bnum[i] - bnum[i-1];
        }

        int answer = 0;
        List<Integer> bindex = new ArrayList<>();
        int[] tmp = new int[m];
        int[] change = new int[m];
        next : for(int i = 0; i < n - m + 1; i++) {
            for(int j = 0; j < m; j++) {
                tmp[j] = num[i + j];
            }
            Arrays.sort(tmp);

            for(int j = 1; j < m; j++) {
                if(bchange[j] != tmp[j] - tmp[j-1]) 
                    continue next;
            }
            answer++;
            bindex.add(i + 1);
        }

        sb.append(answer).append('\n');
        for(int i = 0; i < bindex.size(); i++)
            sb.append(bindex.get(i)).append('\n');

        System.out.print(sb);
    }
}