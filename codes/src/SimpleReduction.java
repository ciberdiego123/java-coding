import java.util.List;
import java.util.Optional;

public class SimpleReduction {

    public static void main(String[] args){
        List<Integer> ints = List.of(1, 1, 1, 1, 1);

        Optional<Integer> reduce = ints.stream().reduce((i1, i2) -> i1 + i2);
        System.out.println("reduce = "+ reduce);
        //reduce.get(); Java 8 and 9
        //int sum = ints.stream().reduce(0, (i1, i2) -> i1 + i2);
        Integer sum = reduce.orElseThrow();
        System.out.println("sum = "+ sum);
    }

}
