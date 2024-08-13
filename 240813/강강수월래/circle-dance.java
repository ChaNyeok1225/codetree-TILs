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

        HashMap<Integer, Node> students = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            Node head, tail;
            head = tail = new Node(0);

            for(int j = 0; j < k; j++) {
                int num = Integer.parseInt(st.nextToken());
                Node student = new Node(num);
                
                student.prev = tail;
                tail.next = student;
                tail = student;

                students.put(num, student);
            }
            tail.next = head.next;
            head.next.prev = tail;
        }

        Node a, b, an;
        int min;
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int inst = Integer.parseInt(st.nextToken());

            switch(inst) {
                case 1:
                    a = students.get(Integer.parseInt(st.nextToken()));
                    b = students.get(Integer.parseInt(st.nextToken()));

                    a.next.prev = b.prev;
                    b.prev.next = a.next;
                    a.next = b;
                    b.prev = a;
                    break;

                case 2:
                    a = students.get(Integer.parseInt(st.nextToken()));
                    b = students.get(Integer.parseInt(st.nextToken()));

                    an = b.prev;

                    b.prev.next = a;
                    a.prev.next = b;
                    b.prev = a.prev;
                    a.prev = an;
                    break;

                case 3:
                    a = students.get(Integer.parseInt(st.nextToken()));
                    min = Integer.MAX_VALUE;
                    for(Node tmp = a.next; tmp != a; tmp = tmp.next) {
                        min = min < tmp.num ? min : tmp.num;
                    }

                    a = students.get(min);
                    while(true) {
                        sb.append(a.num + " ");
                        a = a.prev;
                        if(a.num == min)
                            break;
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}