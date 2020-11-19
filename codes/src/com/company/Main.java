package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(8,5,1,2,3,4,10,0,11,15,7,15,10,8);

        Map<Integer, List<Integer>> numberIndexes = new HashMap<>();
        for (int i = 0; i< numbers.size(); i++) {
            int n = numbers.get(i);
            if(!numberIndexes.containsKey(n)){
                numberIndexes.put(n, new ArrayList<>());
            }
            numberIndexes.get(n).add(i);
        }

        for(int i = 0; i < numbers.size(); i++) {
            int j = 15 - numbers.get(i);
            if(numberIndexes.containsKey(j)){
                int finalI = i;
                List<Integer> indexes = numberIndexes.get(j)
                        .stream().filter(index -> finalI < index)
                        .collect(Collectors.toList());
                for (Integer index : indexes){
                    System.out.println(String.format("[%d,%d]",i, index));
                }
            }
        }
    }
}
