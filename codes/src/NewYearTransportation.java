import java.util.Scanner;

public class NewYearTransportation {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i < n ; i++) {
            a[i] = in.nextInt();
        }
        int currentI = 1;
        while(currentI < t){
            currentI += a[currentI];
        }
        if(currentI == t)
            System.out.println("YES");
        else
            System.out.println("NO");
        in.close();
    }

}
