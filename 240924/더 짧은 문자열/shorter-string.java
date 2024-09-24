import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        String[] str = br.readLine().split(" ");

        int len1 = str[0].length();
        int len2 = str[1].length();

        String answer;

        if(len1 == len2)
            answer = "equal";
        else 
            answer = len1 < len2 ? str[0] + " " + len1 : str[1] + " " + len2;

        System.out.println(answer);
    }
}