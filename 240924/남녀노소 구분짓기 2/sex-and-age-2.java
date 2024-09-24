import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int g = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());

        char answer = ' ';
        if(g == 0) {
            if(a >= 19)
                answer = 'M';
            else
                answer = 'B';
        } else {
            if(a >= 19)
                answer = 'W';
            else
                answer = 'G';
        }

        System.out.println(answer);
    }
}