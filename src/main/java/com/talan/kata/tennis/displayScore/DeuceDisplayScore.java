package com.talan.kata.tennis.displayScore;

import com.talan.kata.tennis.model.EnumGameScore;
import com.talan.kata.tennis.model.Player;

public class DeuceDisplayScore extends AbstractDisplayScore{

    private static final String DEUCE_ACTIVATED = "DEUCE Activated";

    @Override
    public boolean isActivated(Player p1, Player p2) {
        return p1.getGameScore() == EnumGameScore.DEUCE && p2.getGameScore() == EnumGameScore.DEUCE;
    }

    @Override
    public String displayScore(Player p1, Player p2) {
        return DEUCE_ACTIVATED;
    }
}
