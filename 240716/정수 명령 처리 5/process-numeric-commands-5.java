import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        

        Stack<Integer> arr = new Stack<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String inst = st.nextToken();
            
            switch(inst) {

                case "push_back" :
                    arr.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_back" :
                    arr.pop();
                    break;
                case "size" :
                    sb.append(arr.size()).append("\n");
                    break;
                case "get" :
                    sb.append(arr.get(Integer.parseInt(st.nextToken())-1)).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}