package com.example.TheMind.model;

import lombok.Data;
import lombok.ToString;

@Data
public class Round {

    private int roundLevel;

    private int numberOfShurikens;

    private int lives;

    public Round(int roundLevel){
        this.roundLevel = roundLevel;
    }

    public void loseOneLife(){
        lives--;
    }

    public void loseOneShuriken(){
        numberOfShurikens--;
    }

}
