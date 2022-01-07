package strategy;

import fileio.Child;

/**
 * Strategy for setting the average score for young adults.
 * It wasn't necessary to make this strategy, but for posibility of extend
 * Just setting the score to null, anyway young adults will be eliminated
 */
public final class YoungAdultScoreStrategy implements ScoreStrategy {
    @Override
    public void getChildAverageScore(final Child child) {
        child.setAverageScore(null);
    }
}
