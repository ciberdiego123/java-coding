import java.util.Scanner;

public class AnotherTwoIntegers {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            int a = in.nextInt();
            int b = in.nextInt();
            int d = Math.abs(b - a);
            int r = d % 10 == 0 ? d / 10 : d / 10 + 1;
            System.out.println(r);
        }
        in.close();
    }

}
