package com.talan.kata.tennis.utils;

import com.talan.kata.tennis.model.EnumGameScore;
import org.apache.commons.lang3.StringUtils;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Joseph on 31/07/2018.
 */
public final class GameScoreUtils {

    /**
     * Go to the nex Score
     * @param gameScore Initial Score
     * @return Next Score
     */
    public static EnumGameScore toEnum(String gameScore) {
        final Optional<EnumGameScore> enumGameScore = Stream.of(EnumGameScore.values()).filter(gs -> scoresAreEquals(gameScore, gs)).findFirst();
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
