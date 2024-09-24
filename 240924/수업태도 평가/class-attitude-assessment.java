import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> studentPoint = new HashMap<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int point = Integer.parseInt(st.nextToken());

            studentPoint.put(name, studentPoint.getOrDefault(name, 0) + point);
        }

        int[] points = new int[7];
        int index = 0;
        for(int point : studentPoint.values()) {
            points[index++] = point;
        }
        Arrays.sort(points);
        int selectPoint = points[0];
        for(int i = 0; i < 7; i++) {
            if(points[i] > selectPoint) {
                selectPoint = points[i];
                break;
            }
        }
        String answer = null;
        for(Map.Entry<String, Integer> entry : studentPoint.entrySet()) {  
            if(entry.getValue() == selectPoint) {
                if(answer != null) {
                    answer = "Tie";
                    break;
                }
                else
                    answer = entry.getKey();
            }
        }

        System.out.println(answer);
    }
}