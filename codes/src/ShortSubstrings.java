import java.util.Scanner;
import java.util.stream.IntStream;

public class ShortSubstrings {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            String b = in.next();
            StringBuilder a = new StringBuilder();
            int n = b.length();
            a.append(b.charAt(0));
            for(int i = 2; i <= n-2; i += 2 ){
                a.append(b.charAt(i));
            }
            a.append(b.charAt(n - 1));
            System.out.println(a.toString());
        }
        in.close();
    }

}
