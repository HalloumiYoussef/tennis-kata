package com.talan.kata.tennis.displayScore;

import com.talan.kata.tennis.model.Player;
import org.apache.commons.lang3.StringUtils;

import static com.talan.kata.tennis.utils.ConstantsUtils.*;

public class SetDisplayScore extends AbstractDisplayScore {

    private static final String SET_SCORE = "Set Score: ";

    @Override
    public boolean isActivated(Player p1, Player p2) {
        //Always display SetScore
        return true;
    }

    @Override
    public String displayScore(Player p1, Player p2) {
        return StringUtils.join(SET_SCORE,
                p1.getSetScore(),
                SEP,
                p2.getSetScore());
    }
}
