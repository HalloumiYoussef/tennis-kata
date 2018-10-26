package com.talan.kata.tennis.displayScore;

import com.talan.kata.tennis.model.EnumGameScore;
import com.talan.kata.tennis.model.Player;
import org.apache.commons.lang3.StringUtils;

import static com.talan.kata.tennis.utils.ConstantsUtils.*;

public class GameDisplayScore extends AbstractDisplayScore {

    private static final String GAME_SCORE = "Game Score: ";

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

    @Override
    public String displayScore(Player p1, Player p2) {
        return StringUtils.join(GAME_SCORE,
                p1.getGameScore().getScore() ,
                SEP,
                p2.getGameScore().getScore());
    }
}
