package com.talan.kata.tennis.tennis;

import com.talan.kata.tennis.model.Player;
import com.talan.kata.tennis.displayscore.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.talan.kata.tennis.utils.GameScoreUtils.SEP;
import static org.apache.commons.lang3.StringUtils.join;

public class TennisGame {

    private static final String PLAYERS = "Players: ";
    public static final String LINE_DELIMITER = "\n";
    public static final String THE_WINNER_OF_THE_SET = "The winner of the Set is ";
    public static final String NOT_YET_KNOWN = "not yet known";

    //The two players of the match
    private Player p1;
    private Player p2;

    //All displayScore cases
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

    /**
     * Display the current score of the match
     * @return String
     */
    public String displayScore() {
        final String players = join(PLAYERS,
                p1.getName(),
                SEP,
                p2.getName());

        final String scores = displayScores.stream()
                .filter(d -> d.isActivated(p1, p2))
                .collect(Collectors.toList())
                .stream()
                .map(d -> d.displayScore(p1, p2))
                .collect(Collectors.joining(LINE_DELIMITER));

        return  String.join(LINE_DELIMITER, players, scores);
    }

    /**
     * Returns the winner of the Set if it's known
     * Otherwise return 'Not yet known'
     * If a player reach the Set score of 6 and the other player has a Set score of 4 or lower, the player win the Set, Ex 6-2
     * The first player who reach the score of 7 wins the Set, Ex 7-5 or 7-6 (After TieBreak)
     * @return String
     */
    public String whoIsTheSetWinner() {
        Optional<Player> optional = whoIsTheWinner(p1, p2);
        if(!optional.isPresent()){
            optional = whoIsTheWinner(p2, p1);
        }
        return prepareTheWinnerResult(optional);
    }

    /**
     * Return the first player if it is the winner of the Set
     * @param firstPlayer: first player
     * @param secondPlayer: second player
     * @return Optional Player
     */
    private Optional<Player> whoIsTheWinner(Player firstPlayer, Player secondPlayer) {
        Optional<Player> optional = Optional.empty();
        if ((firstPlayer.getSetScore() == 7) || (firstPlayer.getSetScore() == 6 && secondPlayer.getSetScore() < 5)){
            optional = Optional.of(firstPlayer);
        }
        return optional;
    }

    /**
     * Prepare the result
     * The name of the set winner if it is present
     * Or 'Not yet known' otherwise
     * @param optional: Optional Player
     * @return String
     */
    private String prepareTheWinnerResult(Optional<Player> optional) {
        final String winner;
        if(optional.isPresent()){
            winner = join(THE_WINNER_OF_THE_SET, optional.get().getName());
        } else {
            winner = join(THE_WINNER_OF_THE_SET, NOT_YET_KNOWN);
        }
        return winner;
    }

}
