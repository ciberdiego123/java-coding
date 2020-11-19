package streams;

import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamFromString {

    public static void main(String[] args){

        String sentence = "the quick brown fox jumps over the lazy dog";

        sentence.chars()
                .mapToObj(codePoint -> Character.toString(codePoint))
                .filter(letter -> !letter.equals(" "))
                //.distinct()
                //.sorted()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

    }

}
