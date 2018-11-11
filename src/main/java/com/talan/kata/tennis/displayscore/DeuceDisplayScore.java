package com.talan.kata.tennis.displayscore;

import com.talan.kata.tennis.model.EnumGameScore;
import com.talan.kata.tennis.model.Player;

public class DeuceDisplayScore implements AbstractDisplayScore{

    private static final String DEUCE_ACTIVATED = "DEUCE Activated";

    /**
     * Activated when the DEUCE rule is activated
     * @param p1: first player
     * @param p2: second player
     * @return boolean
     */
    @Override
    public boolean isActivated(Player p1, Player p2) {
        return p1.getGameScore() == EnumGameScore.DEUCE && p2.getGameScore() == EnumGameScore.DEUCE;
    }

    /**
     * Mention that the DEUCE is activated
     * @param p1: first player
     * @param p2: second player
     * @return String
     */
    @Override
    public String displayScore(Player p1, Player p2) {
        return DEUCE_ACTIVATED;
    }
}
