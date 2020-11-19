package streams;

import streams.model.City;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoreStatistics {

    public static void main(String[] args){

        Function<String, City> lineToCity =
                line -> {

                    String[] split = line.split(";");
                    String cityName = split[1].trim();

                    String state = split[2].trim();

                    String populationAsString = split[3];
                    populationAsString = populationAsString.replace(",", "");
                    int population = Integer.parseInt(populationAsString);

                    String landAreaAsString = split[7];
                    landAreaAsString = landAreaAsString.replace(",","");
                    double landArea = Double.parseDouble(landAreaAsString);

                    return new City(cityName,state,population,landArea);
                };

        Path path = Path.of("data/cities.csv");
        Set<City> cities = null;
        try(Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)){
            cities = lines.skip(2)
                    .map(lineToCity)
                    .collect(Collectors.toSet());
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("# cities = "+cities.size());

        Map<String, List<City>> citiesPerState =
                cities.stream()
                .collect(
                        Collectors.groupingBy(
                                city -> city.getState()
                        ));

        System.out.println("Map size = " + citiesPerState.size());
        List<City> citiesOfUtah = citiesPerState.get("Utah");
        System.out.println(citiesOfUtah);

        Map<String, Long> numberOfCitiesPerState =
                cities.stream()
                .collect(
                  Collectors.groupingBy(
                          city -> city.getState(), Collectors.counting()
                  )
                );

        System.out.println("# of cities in Utah: " + numberOfCitiesPerState.get("Utah"));

        Map.Entry<String, Long> stateWithMostCities =
                numberOfCitiesPerState.entrySet().stream() // Streal Map.Entry <String, Long>
                    // .max(Comparator.comparing(Map.Entry::getValue))
                    .max(Map.Entry.comparingByValue())
                    .orElseThrow();
        System.out.println(stateWithMostCities);

        int populationOfUtah = citiesPerState.get("Utah").stream()
                //.mapToInt(city -> city.getPopulation())
                // .sum();
                .collect(Collectors.summingInt(city -> city.getPopulation()));

        System.out.println("Population of Utah = " + populationOfUtah);

        Map <String, Integer> populationOfCitiesPerState =
                cities.stream()
                .collect(
                        Collectors.groupingBy(
                                city -> city.getState(),
                                Collectors.summingInt(city -> city.getPopulation())
                        ));

        System.out.println("Population of Utah = " + populationOfCitiesPerState.get("Utah"));

        Map.Entry<String, Integer> stateWithTheMostPeople =
                populationOfCitiesPerState.entrySet().stream() // Streal Map.Entry <String, Long>
                        // .max(Comparator.comparing(Map.Entry::getValue))
                        .max(Map.Entry.comparingByValue())
                        .orElseThrow();

        System.out.println(stateWithTheMostPeople);



    }
}
