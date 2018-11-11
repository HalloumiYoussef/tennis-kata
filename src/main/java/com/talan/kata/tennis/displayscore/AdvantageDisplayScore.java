package com.talan.kata.tennis.displayscore;

import com.talan.kata.tennis.model.EnumGameScore;
import com.talan.kata.tennis.model.Player;
import org.apache.commons.lang3.StringUtils;

public class AdvantageDisplayScore implements AbstractDisplayScore {

    private static final String ADVANTAGE = "Advantage: ";

    /**
     * Activated when a player has the Advantage
     * @param p1: first player
     * @param p2: second player
     * @return boolean
     */
    @Override
    public boolean isActivated(Player p1, Player p2) {
        return p1.getGameScore() == EnumGameScore.ADV || p2.getGameScore() == EnumGameScore.ADV;
    }

    /**
     * Display the player who has the Advantage
     * @param p1: first player
     * @param p2: second player
     * @return String
     */
    @Override
    public String displayScore(Player p1, Player p2) {
        final String name = p1.getGameScore() == EnumGameScore.ADV ? p1.getName():p2.getName();
        return StringUtils.join(ADVANTAGE, name);
    }
}
