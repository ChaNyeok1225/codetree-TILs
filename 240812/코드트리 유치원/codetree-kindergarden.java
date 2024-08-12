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

        int q = Integer.parseInt(br.readLine());

        HashMap<Integer, Node> kids = new HashMap<>();

        int curNum = 1;
        Node head, tail;
        head = tail = new Node(curNum);
        kids.put(curNum, tail);
        curNum++;

        Node kid, thead, ttail;
        int a, b, cnt, inst;
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            inst = Integer.parseInt(st.nextToken());

            switch(inst) {

                case 1 :
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    kid = kids.get(a);

                    cnt = 1;
                    thead = ttail = new Node(curNum);
                    kids.put(curNum, ttail);
                    curNum++;

                    for(int j = 1; j < b; j++) {
                        Node newNode = new Node(curNum);
                        kids.put(curNum, newNode);
                        curNum++;

                        ttail.next = newNode;
                        newNode.prev = ttail;
                        ttail = newNode;
                    }
                    
                    ttail.next = kid.next;
                    if(kid.next != null)
                        ttail.next.prev = ttail;
                    else
                        tail = ttail;
                    kid.next = thead;
                    thead.prev = kid;
                    break;

                case 2 :
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    kid = kids.get(a);

                    cnt = 1;
                    thead = ttail = new Node(curNum);
                    kids.put(curNum, ttail);
                    curNum++;

                    for(int j = 1; j < b; j++) {
                        Node newNode = new Node(curNum);
                        kids.put(curNum, newNode);
                        curNum++;

                        ttail.next = newNode;
                        newNode.prev = ttail;
                        ttail = newNode;
                    }
                    ttail.next = kid;
                    thead.prev = kid.prev;
                    if(kid.prev != null)
                        kid.prev.next = thead;
                    else
                        head = thead;
                    kid.prev = ttail;
                    break;

                case 3 :
                    a = Integer.parseInt(st.nextToken());
                    kid = kids.get(a);

                    if(kid.prev == null || kid.next == null) {
                        sb.append("-1\n");
                    } else {
                        sb.append(kid.prev.num + " " + kid.next.num + "\n");
                    }
                    break;
            }
        }

        System.out.print(sb);
        
    }
}