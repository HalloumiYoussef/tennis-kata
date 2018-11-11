package com.talan.kata.tennis.utils;

import com.talan.kata.tennis.model.EnumGameScore;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameScoreUtilsTest {

    @Test
    public void should_return_score() {
        assertEquals(EnumGameScore.ZERO, GameScoreUtils.toEnum("0"));
        assertEquals(EnumGameScore.FIFTEEN, GameScoreUtils.toEnum("15"));
        assertEquals(EnumGameScore.THIRTY, GameScoreUtils.toEnum("30"));
        assertEquals(EnumGameScore.FORTY, GameScoreUtils.toEnum("40"));
        assertEquals(EnumGameScore.DEUCE, GameScoreUtils.toEnum("DEUCE"));
        assertEquals(EnumGameScore.ADV, GameScoreUtils.toEnum("ADV"));
    }

    @Test(expected = EnumConstantNotPresentException.class)
    public void should_throw_exception() {
        GameScoreUtils.toEnum("45");
    }
}