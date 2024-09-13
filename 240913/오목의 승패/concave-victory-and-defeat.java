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
        int[][] vis = new int[19][19];

        for(int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dr = {1, 0, 1, 1}, dc = {0, 1, 1, -1};

        int color, cnt, nr, nc;
        for(int i = 0; i < 19; i++) {
            for(int j = 0; j < 19; j++) {
                if(map[i][j] == 0)
                    continue;

                color = map[i][j];
                vis[i][j] = 15;
                for(int d = 0; d < 4; d++) {
                    cnt = 1;
                    nr = i;
                    nc = j;

                    while(true) {
                        nr += dr[d];
                        nc += dc[d];

                        if(nr < 0 || nc < 0 || nr > 18 || nc > 18 || map[nr][nc] != color || (vis[nr][nc] & (1 << d)) != 0 ) {
                            if(cnt == 5) {
                                answer = color;
                                answerR = i;
                                answerC = j;
                                if(d == 3) {
                                    answerR = i + 4;
                                    answerC = j - 4;
                                }
                            }
                            break;
                        }
                        cnt++;
                        vis[nr][nc] |= (1 << d);
                    }
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