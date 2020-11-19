package streams.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class City {

    private String name;
    private String state;
    private int population;
    private double area;

    public City(String name, String state, int population, double area) {
        this.name = name;
        this.state = state;
        this.population = population;
        this.area = area;
    }

    private List<Person> people = new ArrayList<>();

    public City(){
    }

    public City(String name, Person... people){
        this.name = name;
        this.people.addAll(Arrays.asList(people));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", population=" + population +
                ", area=" + area +
                '}';
    }
}
