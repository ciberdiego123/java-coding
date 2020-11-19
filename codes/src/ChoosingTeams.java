import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ChoosingTeams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        List<Integer> participations = new ArrayList<>();
        for(int i = 0; i< n; i++)
            participations.add(in.nextInt());
        Collections.sort(participations);
        long maxNumberOfTeams = IntStream
                .range(0, participations.size())
                .filter(i -> (i + 1) % 3 == 0)
                .map(i -> 5 - participations.get(i) )
                .filter(p -> p >= k)
                .count();
        System.out.println(maxNumberOfTeams);
    }

}
