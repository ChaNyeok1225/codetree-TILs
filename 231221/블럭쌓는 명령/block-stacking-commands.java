import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> blocks = new ArrayList<>();

        int[] arr = new int[n+1];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start]++;
            arr[end+1]--;
        }
        
        int val = 0;
        for(int i = 1; i < n + 1; i++) {
            val += arr[i];
            blocks.add(val);
        }

        Collections.sort(blocks);
        
        System.out.println(blocks.get(n/2));
        
        
    }
}