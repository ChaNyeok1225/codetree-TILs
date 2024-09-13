import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int answer = 0;
        for(int i = 0; i < 3; i++)
            answer += br.readLine().length();

        System.out.println(answer);
    }
}