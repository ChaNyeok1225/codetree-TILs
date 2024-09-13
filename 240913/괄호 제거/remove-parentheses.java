import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<int[]> arr;
    static boolean[] vis;
    static char[] c;

    static TreeSet<String> set = new TreeSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        c = str.toCharArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        arr = new ArrayList<>();
        
        for(int i = 0; i < c.length; i++) {
            if(c[i] == '(') {
                stack.offer(i);
            } else if(c[i] == ')') {
                arr.add(new int[] {stack.pollLast(), i});
            }
        }

        vis = new boolean[c.length];

        dfs(0);

        set.remove(str);
        for(String s : set) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int idx) {
        
        if(idx == arr.size()) {
            for(int i = 0; i < vis.length; i++) {
                if(!vis[i])
                    sb.append(c[i]);
            }
            set.add(sb.toString());
            sb.setLength(0);
            return;
        }

        int[] sel = arr.get(idx);
        vis[sel[0]] = true;
        vis[sel[1]] = true;
        dfs(idx + 1);
        vis[sel[0]] = false;
        vis[sel[1]] = false;
        dfs(idx + 1);
    }
}