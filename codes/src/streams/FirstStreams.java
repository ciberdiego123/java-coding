package streams;

import streams.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FirstStreams {

    public static void main(String[] args){
        List<String> names = List
                .of("Paul","Sarah","James","Julie","Charles","Charlotte","Ann","Boris","Emily", "");
        List<Integer> ages = List
                .of(25, 27, 31, 25, 22, 31, 27, 29, 34, 34);
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            people.add(new Person(names.get(i), ages.get(i)));
        }

        long countEmptyNames =
                people.stream()
                        .map(p1 -> p1.getName())
                        .filter(name1 -> name1.isEmpty())
                        .count();

        long countNonEmptyNames =
                people.stream()
                        .map(p -> p.getName())
                        .filter(name -> !name.isEmpty())
                        .count();

        System.out.println("Empty names = " + countEmptyNames);
        System.out.println("Non empty names = " + countEmptyNames);

    }



}
