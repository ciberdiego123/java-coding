package com.example.TheMind.model;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(includeFieldNames=false)
public class Player {

    private String name;

    private List<Integer> cards = new ArrayList<>();

    public Player(String name){
        this.name = name;
    }

    public Integer getMinCard(){
        Integer minCard = cards
                .stream()
                .mapToInt(n -> n)
                .min()
                .orElseThrow();
        return minCard;
    }

    public void playCard(List<Integer> publicCards){
        Integer cardToPlay = getMinCard();
        cards.remove(cardToPlay);
        publicCards.add(cardToPlay);
    }

}
