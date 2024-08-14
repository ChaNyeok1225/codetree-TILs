import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        String name;
        Node prev, next;

        Node(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int x = n / m;
        HashMap<String, Node> map = new HashMap<>();
        Node[] heads = new Node[m], tails = new Node[m];
        Node head, tail;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            heads[i] = tails[i] = new Node(null);
            head = heads[i];
            tail = tails[i];

            for(int j = 0; j < x; j++) {
                String str = st.nextToken();

                Node newNode = new Node(str);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;

                map.put(str, newNode);
            }
        }

        Node a, b, c;
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int inst = Integer.parseInt(st.nextToken());

            switch(inst) {
                case 1 :
                    a = map.get(st.nextToken());
                    b = map.get(st.nextToken());

                    a.prev.next = a.next;
                    if(a.next != null) {
                        a.next.prev = a.prev;
                    }

                    a.next = b;
                    a.prev = b.prev;
                    a.prev.next = a;
                    b.prev = a;
                    break;

                case 2 :
                    a = map.get(st.nextToken());

                    a.prev.next = a.next;
                    if(a.next != null) {
                        a.next.prev = a.prev;
                    }
                    break;

                case 3 :
                    a = map.get(st.nextToken());
                    b = map.get(st.nextToken());
                    c = map.get(st.nextToken());

                    a.prev.next = b.next;
                    if(b.next != null) {
                        b.next.prev = a.prev;
                    }

                    c.prev.next = a;
                    a.prev = c.prev;
                    b.next = c;
                    c.prev = b;
                    break;
            }
        }

        for(int i = 0; i < m; i++) {
            head = heads[i];

            if(head.next == null) {
                sb.append(-1);
            }   else {
                for(Node tmp = head.next; tmp != null; tmp = tmp.next) {
                    sb.append(tmp.name + " ");
                }
            }


            sb.append("\n");
        }


        System.out.println(sb);
    }
}