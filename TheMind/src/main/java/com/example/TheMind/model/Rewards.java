package com.example.TheMind.model;

import lombok.Data;

@Data
public class Rewards {

    private int lives;

    private int numberOfShurikens;

    public Rewards(int lives, int numberOfShurikens) {
        this.lives = lives;
        this.numberOfShurikens = numberOfShurikens;
    }
}
