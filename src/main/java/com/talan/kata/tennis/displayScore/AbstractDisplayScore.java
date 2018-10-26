package com.talan.kata.tennis.displayScore;

import com.talan.kata.tennis.model.Player;

public abstract class AbstractDisplayScore {

    public abstract boolean isActivated(Player p1, Player p2);

    public abstract String displayScore(Player p1, Player p2);

}
