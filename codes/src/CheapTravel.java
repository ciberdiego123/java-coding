import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheapTravel {

    static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //Target
        int n = in.nextInt();
        //# Special Ticket
        int m = in.nextInt();
        //Price one ticket
        int a = in.nextInt();
        // Price special ticket
        int b = in.nextInt();
        for(int i = 1; i < n; i++){
            getMinTravelCost(i, m, a, b);
        }
        System.out.println(getMinTravelCost(n, m, a, b));
        in.close();
    }

    public static int getMinTravelCost(int n, int m, int a, int b){
        if(n <= 0){
            return 0;
        }else if(cache.containsKey(n)){
            return cache.get(n);
        }else{
            int ans;
            int option1 = a + getMinTravelCost(n - 1, m, a, b);
            int option2 = b + getMinTravelCost(n - m, m, a, b);
            ans = Math.min(option1, option2);
            cache.put(n, ans);
            return ans;
        }
    }

}
