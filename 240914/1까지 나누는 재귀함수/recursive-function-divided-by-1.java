import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        recv(n);

        System.out.println(sb);
    }

    static void recv(int n) {
        sb.append(n).append(" ");

        if(n == 1) {
            return;
        }
        else if((n & 1) == 1) {
            recv(n / 3);
        } else {
            recv(n / 2);
        }
    }
}