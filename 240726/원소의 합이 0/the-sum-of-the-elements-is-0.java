import java.util.*;
import java.io.*;
import java.util.Map.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[4][n];
        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }  
        }

        HashMap<Integer, Integer> abMap = new HashMap<>();
        HashMap<Integer, Integer> cdMap = new HashMap<>();
        
        int abSum, cdSum;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                abSum = arr[0][i] + arr[1][j];
                abMap.put(abSum, abMap.getOrDefault(abSum, 0) + 1);

                cdSum = arr[2][i] + arr[3][j];
                cdMap.put(cdSum, cdMap.getOrDefault(cdSum, 0) + 1);
            }
        }

        int ans = 0;
        for(Entry<Integer, Integer> abEntry : abMap.entrySet()) {
            ans += abEntry.getValue() * cdMap.getOrDefault(0 - abEntry.getKey(), 0);
        }

        System.out.println(ans);
    }
}