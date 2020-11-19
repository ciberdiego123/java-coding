package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class StreamFromTextFile {

    public static void main(String[] args){
        Path path = Path.of("data/first-names.txt");
        try(Stream<String> lines = Files.lines(path)){
            System.out.println(lines.count());
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
