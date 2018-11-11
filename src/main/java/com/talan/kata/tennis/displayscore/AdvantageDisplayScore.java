package com.talan.kata.tennis.displayScore;

import com.talan.kata.tennis.model.EnumGameScore;
import com.talan.kata.tennis.model.Player;
import org.apache.commons.lang3.StringUtils;

public class AdvantageDisplayScore extends AbstractDisplayScore {

    private static final String ADVANTAGE = "Advantage: ";

    @Override
    public boolean isActivated(Player p1, Player p2) {
        return p1.getGameScore() == EnumGameScore.ADV || p2.getGameScore() == EnumGameScore.ADV;
    }

    @Override
    public String displayScore(Player p1, Player p2) {
        final String name = p1.getGameScore() == EnumGameScore.ADV ? p1.getName():p2.getName();
        return StringUtils.join(ADVANTAGE, name);
    }
}
