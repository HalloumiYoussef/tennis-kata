package com.talan.kata.tennis.displayscore;

import com.talan.kata.tennis.model.Player;
import org.apache.commons.lang3.StringUtils;

import static com.talan.kata.tennis.utils.GameScoreUtils.SEP;

public class SetDisplayScore implements AbstractDisplayScore {

    private static final String SET_SCORE = "Set Score: ";

    /**
     * Always activated, the Set Score should be displayed all the time
     * @param p1: first player
     * @param p2: second player
     * @return true
     */
    @Override
    public boolean isActivated(Player p1, Player p2) {
        return true;
    }

    /**
     * Return the Set Score
     * @param p1: first player
     * @param p2: second player
     * @return String
     */
    @Override
    public String displayScore(Player p1, Player p2) {
        return StringUtils.join(SET_SCORE,
                p1.getSetScore(),
                SEP,
                p2.getSetScore());
    }
}
