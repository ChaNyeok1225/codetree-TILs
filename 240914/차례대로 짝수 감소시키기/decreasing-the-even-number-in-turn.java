import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        
        int num = 1000;
        int sum = 0;
        int cnt = 0;
        for(int i = 2; num > n; i += 2) {
            cnt++;
            sum += i;
            num -= i;
        }

        System.out.println(cnt + " " + sum);
        
    }
}