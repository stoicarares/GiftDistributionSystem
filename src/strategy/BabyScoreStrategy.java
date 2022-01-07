package strategy;

import common.Constants;
import fileio.Child;

/**
 * Strategy for setting the average score for babies
 */
public final class BabyScoreStrategy implements ScoreStrategy {
    @Override
    public void getChildAverageScore(final Child child) {
        child.setAverageScore(Constants.MAX_AVERAGE_SCORE);
    }
}
