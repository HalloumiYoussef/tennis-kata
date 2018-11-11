package com.talan.kata.tennis.utils;

import com.talan.kata.tennis.model.EnumGameScore;
import org.apache.commons.lang3.StringUtils;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Joseph on 31/07/2018.
 */
public class GameScoreUtils {

    public static final String SEP = " - ";

    private GameScoreUtils() {
        //Default
    }

    /**
     * Get the EnumGameScore by its value
     * @param gameScore: the value of the game score
     * @return EnumGameScore
     * @throws EnumConstantNotPresentException: when the gameScore is unknown
     */
    public static EnumGameScore toEnum(String gameScore) {
        final Optional<EnumGameScore> enumGameScore = Stream.of(EnumGameScore.values())
                                                        .filter(gs -> scoresAreEquals(gameScore, gs))
                                                        .findFirst();
        if(enumGameScore.isPresent()){
            return enumGameScore.get();

        }else {
            throw new EnumConstantNotPresentException(EnumGameScore.class, gameScore);
        }
    }

    private static boolean scoresAreEquals(String gameScore, EnumGameScore gs) {
        return StringUtils.equalsIgnoreCase(gs.getScore(), gameScore);
    }
}
