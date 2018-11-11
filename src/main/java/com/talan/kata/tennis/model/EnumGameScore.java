package com.talan.kata.tennis.model;

/**
 * EnumGameScore
 * Enumeration with all possible scores for the game
 * Created by YHI on 26/06/2018.
 */
public enum EnumGameScore {

    ZERO("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    ADV("ADV"),
    DEUCE("DEUCE");

    private String score;

    EnumGameScore(String score) {
        this.score = score;
    }

    public String getScore() {
        return this.score;
    }

}
