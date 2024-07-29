//n과 m
import java.util.*;
import java.io.*;

public class Main {

    static int ans= -1;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        int[][] map= new int[n][m];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        int ans = -1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                int h = 0;
                int minW = Integer.MAX_VALUE;
                for(int k = i; k < n; k++) {
                    if(map[k][j] <= 0)
                        break;
                    h++;
                    int w = 0;
                    for(int l = j; l < m; l++) {
                        if(map[k][l] <= 0)
                            break;
                        w++;
                    }

                    minW = minW < w ? minW : w;
                    int area = h * minW;
                    ans = ans > area ? ans : area;
                }
            }
        }

        System.out.print(ans);

    }

    
}