package com.talan.kata.tennis.tennis;

import com.talan.kata.tennis.model.Player;
import com.talan.kata.tennis.utils.GameScoreUtils;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class TennisGameTest {

    private Player player1 = new Player("P1");
    private Player player2 = new Player("P2");
    private TennisGame tennisGame;

    @Before
    public void setUp(){
        tennisGame = new TennisGame(player1, player2);
    }


    @Test
    @Parameters({
            "0, 0, Players: P1 - P2\nSet Score: 0 - 0\nGame Score: 0 - 0",
            "15, 30, Players: P1 - P2\nSet Score: 0 - 0\nGame Score: 15 - 30",
            "40, 30, Players: P1 - P2\nSet Score: 0 - 0\nGame Score: 40 - 30"
    })
    public void should_display_game_score(String player1Score, String player2Score, String actualScore){
        // Given
        player1.setGameScore(GameScoreUtils.toEnum(player1Score));
        player2.setGameScore(GameScoreUtils.toEnum(player2Score));
        // When
        String expectedScore = tennisGame.displayScore();
        // Then
        Assertions.assertThat(expectedScore).isEqualTo(actualScore);
    }

    @Test
    @Parameters({
            "15, 40, 3, 4, Players: P1 - P2\nSet Score: 3 - 4\nGame Score: 15 - 40",
            "0, 0, 6, 6, Players: P1 - P2\nSet Score: 6 - 6\nGame Score: 0 - 0\nTieBreak Score: 0 - 0"
    })
    public void should_display_set_and_game_scores(String player1GameScore, String player2GameScore, int player1SetScore, int player2SetScore, String actualScore){
        // Given
        player1.setSetScore(player1SetScore);
        player1.setGameScore(GameScoreUtils.toEnum(player1GameScore));
        player2.setSetScore(player2SetScore);
        player2.setGameScore(GameScoreUtils.toEnum(player2GameScore));
        // When
        String expectedScore = tennisGame.displayScore();
        // Then
        Assertions.assertThat(expectedScore).isEqualTo(actualScore);
    }

    @Test
    @Parameters({
            "40, ADV, Players: P1 - P2\nSet Score: 0 - 0\nAdvantage: P2",
            "ADV, 40, Players: P1 - P2\nSet Score: 0 - 0\nAdvantage: P1"
    })
    public void should_display_adv_score(String player1Score, String player2Score, String actualScore){
        // Given
        player1.setGameScore(GameScoreUtils.toEnum(player1Score));
        player2.setGameScore(GameScoreUtils.toEnum(player2Score));
        // When
        String expectedScore = tennisGame.displayScore();
        // Then
        Assertions.assertThat(expectedScore).isEqualTo(actualScore);
    }

    @Test
    @Parameters({"DEUCE, DEUCE, Players: P1 - P2\nSet Score: 0 - 0\nDEUCE Activated"})
    public void should_display_deuce_score(String player1Score, String player2Score, String actualScore){
        // Given
        player1.setGameScore(GameScoreUtils.toEnum(player1Score));
        player2.setGameScore(GameScoreUtils.toEnum(player2Score));
        // When
        String expectedScore = tennisGame.displayScore();
        // Then
        Assertions.assertThat(expectedScore).isEqualTo(actualScore);
    }

    @Test
    @Parameters({
            "0, 0, The winner of the Set is not yet known",
            "5, 4, The winner of the Set is not yet known",
            "2, 6, The winner of the Set is P2",
            "6, 4, The winner of the Set is P1",
            "7, 5, The winner of the Set is P1",
            "6, 7, The winner of the Set is P2"
    })
    public void should_return_winner(int player1SetScore, int player2SetScore, String actualWinner){
        // Given
        player1.setSetScore(player1SetScore);
        player2.setSetScore(player2SetScore);
        // When
        String expectedWinner = tennisGame.whoIsTheSetWinner();
        // Then
        Assertions.assertThat(expectedWinner).isEqualTo(actualWinner);
    }
}
