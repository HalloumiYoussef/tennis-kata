package com.talan.kata.tennis.tennis;

import com.talan.kata.tennis.model.Player;
import com.talan.kata.tennis.displayScore.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.talan.kata.tennis.utils.ConstantsUtils.*;

public class TennisGame {

    private static final String PLAYERS = "Players: ";
    public static final String LINE_DELIMITER = "\n";

    private Player p1;
    private Player p2;

    private List<AbstractDisplayScore> displayScores = Arrays.asList(
            new SetDisplayScore(),
            new DeuceDisplayScore(),
            new AdvantageDisplayScore(),
            new GameDisplayScore(),
            new TieBreakDisplayScore());

    public TennisGame(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public String displayScore() {
        final String players = StringUtils.join(PLAYERS,
                p1.getName(),
                SEP,
                p2.getName());

        final String scores = displayScores.stream().
                filter(d -> d.isActivated(p1, p2))
                .collect(Collectors.toList())
                .stream()
                .map(d -> d.displayScore(p1, p2))
                .collect(Collectors.joining(LINE_DELIMITER));

        return  String.join(LINE_DELIMITER, players, scores);
    }


}
