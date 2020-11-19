import java.util.Scanner;

public class VasyaSocks {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int i = 0;
        int j = 0;
        while(n > 0){
            n--;
            i++;
            j++;
            if(j == m){
                j = 0;
                n++;
            }
        }
        System.out.println(i);
        in.close();
    }
}
