import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        int max = 0;

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String str = br.readLine();

            int num = map.getOrDefault(str, 0) + 1;
            map.put(str, num);
            max = max > num ? max : num;
        }

        System.out.println(max);

    }
}