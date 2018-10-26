package com.talan.kata.tennis.displayScore;

import com.talan.kata.tennis.model.Player;
import org.apache.commons.lang3.StringUtils;

import static com.talan.kata.tennis.utils.ConstantsUtils.*;

public class TieBreakDisplayScore extends AbstractDisplayScore {

    private static final String TIE_BREAK_SCORE = "TieBreak Score: ";

    @Override
    public boolean isActivated(Player p1, Player p2) {
        return p1.getSetScore() == 6 && p2.getSetScore() == 6;
    }

    @Override
    public String displayScore(Player p1, Player p2) {
        return StringUtils.join(TIE_BREAK_SCORE,
                p1.getTbScore() ,
                SEP,
                p2.getTbScore());
    }
}
