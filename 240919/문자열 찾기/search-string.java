import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        char[] str = br.readLine().toCharArray();

        char[] koi = {'K','O','I'};
        char[] ioi = {'I','O','I'};

        int[] kj = new int[3];
        int[] ij = new int[3];

        int k = 0;
        for(int i = 1; i < 3; i++) {
            while(k > 0 && koi[k] != koi[i]) k = kj[k-1];
            if(koi[k] == koi[i]) kj[i] = ++k;
        }

        k = 0;
        for(int i = 1; i < 3; i++) {
            while(k > 0 && ioi[k] != ioi[i]) k = ij[k-1];
            if(ioi[k] == ioi[i]) ij[i] = ++k;
        }

        int ik, kk;
        ik = kk = 0;

        int ka, ia;
        ka = ia = 0;

        for(int i = 0; i < str.length; i++) {
            while(ik > 0 && str[i] != ioi[ik]) ik = ij[ik-1];
            if(str[i] == ioi[ik]) {
                ik++;
                if(ik == ioi.length) {
                    ik = ij[ik - 1];
                    ia++;
                }
            }

            while(kk > 0 && str[i] != koi[kk]) kk = kj[kk-1];
            if(str[i] == koi[kk]) {
                kk++;
                if(kk == koi.length) {
                    kk = kj[ik - 1];
                    ka++;
                }
            }
        }       

        System.out.println(ka + " " + ia);

    }
}