package com.talan.kata.tennis.displayscore;

import com.talan.kata.tennis.model.EnumGameScore;
import com.talan.kata.tennis.model.Player;
import org.apache.commons.lang3.StringUtils;

import static com.talan.kata.tennis.utils.GameScoreUtils.SEP;

public class GameDisplayScore implements AbstractDisplayScore {

    private static final String GAME_SCORE = "Game Score: ";

    /**
     * The game score is displayed when it is not the case of Advantage or DEUCE
     * @param p1: first player
     * @param p2: second player
     * @return boolean
     */
    @Override
    public boolean isActivated(Player p1, Player p2) {
        return isNotAdvCase(p1, p2) && isNotDeuceCase(p1, p2);
    }

    private boolean isNotDeuceCase(Player p1, Player p2) {
        return p1.getGameScore() != EnumGameScore.DEUCE && p2.getGameScore() != EnumGameScore.DEUCE;
    }

    private boolean isNotAdvCase(Player p1, Player p2) {
        return p1.getGameScore() != EnumGameScore.ADV && p2.getGameScore() != EnumGameScore.ADV;
    }

    /**
     * Return the GameScore
     * @param p1: first player
     * @param p2: second player
     * @return String
     */
    @Override
    public String displayScore(Player p1, Player p2) {
        return StringUtils.join(GAME_SCORE,
                p1.getGameScore().getScore() ,
                SEP,
                p2.getGameScore().getScore());
    }
}
