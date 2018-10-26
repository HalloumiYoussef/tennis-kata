package com.talan.kata.tennis.model;

import lombok.Data;

/**
 * Player Class
 */
@Data
public class Player {

    private String name;
    EnumGameScore gameScore = EnumGameScore.ZERO;
    private int setScore;
    private int tbScore;

    public Player(String name) {
        this.name = name;
    }
}
