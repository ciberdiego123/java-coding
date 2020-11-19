import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BabyName {

    public static String getMaxParent(String parent, int maxChar){
        int to = parent.length();
        return IntStream.range(0, parent.length())
                .filter(i -> parent.codePointAt(i) == maxChar)
                .filter(i -> i-1 < 0 || parent.codePointAt(i-1) < maxChar)
                .mapToObj(i -> CharBuffer.wrap(parent).subSequence(i, to)) // subSequence avoiding to use a string constructor
                .max(CharBuffer::compareTo)
                .orElseThrow().toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String father = in.next();
        String mother = in.next();
        int maxFather = father.chars()
                .max()
                .orElseThrow();
        father = getMaxParent(father, maxFather);
        int maxMother = mother.chars()
                .max()
                .orElseThrow();
        mother = getMaxParent(mother, maxMother);
        StringBuilder babyName = new StringBuilder();
        babyName.append(father.charAt(0));
        if(father.length() > 1){
            babyName.append(
                    father.substring(1)
                    .chars()
                    .takeWhile(c -> c >= maxMother)
                    .mapToObj(c -> String.valueOf((char)c))
                    .collect(Collectors.joining()));
        }
        babyName.append(mother);
        System.out.println(babyName.toString());
        in.close();
    }

}


