import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int answer, answerR, answerC;
        answer = answerR = answerC = 0;
        int[][] map = new int[19][19];

        for(int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dr = {1, 0, 1}, dc = {0, 1, 1};

        int color, cnt, nr, nc;
        for(int i = 0; i < 19; i++) {
            for(int j = 0; j < 19; j++) {
                if(map[i][j] == 0)
                    continue;

                color = map[i][j];
                map[i][j] = 0;
                for(int d = 0; d < 3; d++) {
                    cnt = 1;
                    nr = i;
                    nc = j;

                    while(true) {
                        nr += dr[d];
                        nc += dc[d];

                        if(nr + dr[d] > 18 || nc + dr[d] > 18 || map[nr][nc] != color) {
                            if(cnt == 5) {
                                answer = color;
                                answerR = i;
                                answerC = j;
                            }
                            break;
                        }
                        cnt++;
                    }
                    map[nr][nc] = 0;
                }
            }
        }

        sb.append(answer).append("\n");
        if(answer != 0) {
            sb.append(answerR + 1).append(" ").append(answerC + 1);
        }
        System.out.print(sb);
    }
}