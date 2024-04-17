import java.util.*;
import java.io.*;
import org.w3c.dom.Node;

public class Main {

  static class Node {
    int pid;
    int color;
    int md;
    int colorSet;
    List<Integer> child;

    public Node(int pid, int color, int md) {
      this.pid = pid;
      this.color = color;
      this.md = md;
      colorSet = 1 << color;
      child = new ArrayList<>();
    }
  }

  static Node[] nodes;
  static ArrayList<Integer> nodeNum;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    StringTokenizer st;


    nodes = new Node[100010];
    nodeNum = new ArrayList<>();
    int Q = Integer.parseInt(br.readLine());
    int[] op = new int[5];
    int opIdx;

    while(Q-- > 0) {
      st = new StringTokenizer(br.readLine());
      opIdx = 0;

      while(st.hasMoreTokens())
        op[opIdx++] = Integer.parseInt(st.nextToken());

      switch (op[0]) {

        case 100 :
          insertNode(op[1], op[2], op[3], op[4]);
          break;

        case 200:
          changeColor(op[1], op[2]);
          break;

        case 300:
          output.append(getColor(op[1])).append("\n");
          break;

        case 400:
          output.append(getScore()).append("\n");
          break;
      }
    }
    System.out.println(output);
  }

  static void insertNode(int mid, int pid, int color, int md) {
    int dep = 1;
    int tmp = pid;
    while(tmp != -1) {
      Node cur = nodes[tmp];
      if(cur.md <= dep++)
        return;
      tmp = cur.pid;
    }

    nodes[mid] = new Node(pid, color, md);
    nodeNum.add(mid);
    if(pid != -1) {
      nodes[pid].child.add(mid);

      while(pid != -1) {
        Node cur = nodes[pid];

        if((cur.colorSet & (1 << color)) != 0) {
          break;
        }
        cur.colorSet |= 1 << color;
        pid = cur.pid;
      }
    }
  }

  static ArrayDeque<Integer> q = new ArrayDeque<>();
  static void changeColor(int mid, int color) {
    int pid = nodes[mid].pid;
    q.offer(mid);

    while(!q.isEmpty()) {
      Node cur = nodes[q.poll()];
      cur.color = color;
       cur.colorSet = (1 << color);
      for(int child : cur.child) {
        q.offer(child);
      }
    }

    while(pid != -1) {
      Node cur = nodes[pid];
      int cc = (1<<cur.color);
      for(int child : cur.child)
        cc |= nodes[child].colorSet;
      cur.colorSet = cc;
      pid = cur.pid;
    }


  }

  static int getColor(int mid) {
    return nodes[mid].color;
  }

  static int getScore() {
    int ret = 0;

    for(int mid : nodeNum) {
      int size = 0;
      int cs = nodes[mid].colorSet;
      while(cs != 0) {
        if((cs & 1) == 1)
          size++;
        cs >>>= 1;
      }
      ret += size * size;
    }

    return ret;
  }

}