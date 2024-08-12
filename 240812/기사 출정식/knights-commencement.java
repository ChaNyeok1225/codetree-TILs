import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int num;
        Node prev, next;

        Node(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node head, tail;
        head = tail = new Node(0);

        HashMap<Integer, Node> knights = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            Node knight = new Node(num);
            
            knight.prev = tail;
            tail.next = knight;
            tail = knight;

            knights.put(num, knight);
        }
        head.next.prev = tail;
        tail.next = head.next;

        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            Node knight = knights.get(num);
            sb.append(knight.next.num + " " + knight.prev.num + "\n");
            knight.prev.next = knight.next;
            knight.next.prev = knight.prev;
        }
    
        System.out.print(sb);
    }
}