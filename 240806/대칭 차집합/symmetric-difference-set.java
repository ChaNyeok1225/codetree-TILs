import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Set<Integer> totalSet = new HashSet<>();

        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < a; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < b; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        totalSet.addAll(aSet);
        totalSet.addAll(bSet);

        aSet.retainAll(bSet);

        totalSet.removeAll(aSet);

        System.out.println(totalSet.size());

    }
}