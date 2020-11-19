import java.util.*;
import java.util.stream.IntStream;

public class ArrayRearrangement {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int x = in.nextInt();
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(in.nextInt());
            }
            List<Integer> b = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                b.add(in.nextInt());
            }
            Collections.sort(a);
            Collections.sort(b, Collections.reverseOrder());
            String ans = IntStream.range(0, n)
                    .map(i -> a.get(i) + b.get(i))
                    .filter(e -> e <= x)
                    .count() == n ? "Yes" : "No";
            System.out.println(ans);
        }
        in.close();
    }

}
