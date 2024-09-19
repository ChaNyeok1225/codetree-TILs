import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        char c = ' ';
        if(n >= 90)
            c = 'S';
        else if(n >= 80)
            c = 'A';
        else if(n >= 70)
            c = 'B';
        else if(n >= 60)
            c = 'C';
        else
            c = 'F';
        
        System.out.println(c);
    }
}