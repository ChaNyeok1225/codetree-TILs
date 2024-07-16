import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] inst;
        for(int i = 0; i < n; i++) {
            inst = br.readLine().split(" ");

            switch(inst[0]) {
                case "add" : 
                    map.put(Integer.parseInt(inst[1]), Integer.parseInt(inst[2]));
                    break;

                    case "remove" :
                    map.remove(Integer.parseInt(inst[1]));
                    break;

                    case "find" :
                    Integer a = map.get(Integer.parseInt(inst[1]));
                    if(a == null) {
                        sb.append("None");
                    } else {
                        sb.append(a);
                    }
                    sb.append("\n");
            }

        }

        System.out.println(sb);

    }
}