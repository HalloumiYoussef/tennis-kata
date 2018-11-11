package com.talan.kata.tennis.displayscore;

import com.talan.kata.tennis.model.Player;

public interface AbstractDisplayScore {

    /**
     * The displayScore is activated or not
     * @param p1: first player
     * @param p2: second player
     * @return boolean
     */
    boolean isActivated(Player p1, Player p2);

    /**
     * Returns the score
     * @param p1: first player
     * @param p2: second player
     * @return String
     */
    String displayScore(Player p1, Player p2);

}
