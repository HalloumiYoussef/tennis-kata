package com.talan.kata.tennis.displayscore;

import com.talan.kata.tennis.model.Player;
import org.apache.commons.lang3.StringUtils;

import static com.talan.kata.tennis.utils.GameScoreUtils.SEP;

public class TieBreakDisplayScore implements AbstractDisplayScore {

    private static final String TIE_BREAK_SCORE = "TieBreak Score: ";

    /**
     * The Tie-Break rule is activated when the 2 players reach the score of 6 Games
     * @param p1: first player
     * @param p2: second player
     * @return boolean
     */
    @Override
    public boolean isActivated(Player p1, Player p2) {
        return p1.getSetScore() == 6 && p2.getSetScore() == 6;
    }

    /**
     * Return the Tie-Break Score
     * @param p1: first player
     * @param p2: second player
     * @return String
     */
    @Override
    public String displayScore(Player p1, Player p2) {
        return StringUtils.join(TIE_BREAK_SCORE,
                p1.getTbScore() ,
                SEP,
                p2.getTbScore());
    }
}
