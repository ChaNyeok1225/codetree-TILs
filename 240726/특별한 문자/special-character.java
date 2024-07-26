import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();

        LinkedHashSet<Character> set = new LinkedHashSet<>();
        HashSet<Character> Tset = new HashSet<>();

        for(int i = 0; i < str.length(); i++) {
            if(Tset.contains(str.charAt(i))) {
                continue;
            }
            if(set.contains(str.charAt(i))) {
                Tset.add(str.charAt(i));
                set.remove(str.charAt(i));
            } else {
                set.add(str.charAt(i));
            }
        }

        if(set.isEmpty()) {
            System.out.println("None");
        } else {
            for(char c : set) {
                System.out.println(c);
                break;
            }
        }

    }
}