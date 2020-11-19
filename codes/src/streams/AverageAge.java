package streams;

import streams.model.Person;

import java.util.List;
import java.util.OptionalDouble;

public class AverageAge {

    public static void main(String[] args) {

        Person p01 = new Person("Paul", 12);
        Person p02 = new Person("Sarah", 27);
        Person p03 = new Person("James", 31);
        Person p04 = new Person("Julie", 15);
        Person p05 = new Person("Charles", 22);

        List<Person> people = List.of(p01, p02, p03, p04, p05);

        int sum = 0;
        int count = 0;

        double average = people.stream()
            .mapToInt(p -> p.getAge())
            .filter(age -> age > 20)
            .average()
            .orElseThrow();

        System.out.println("Average = " + average);

    }
}
