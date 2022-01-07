package strategy;

import fileio.Child;

/**
 * Strategy for setting the average score for kids
 */
public final class KidScoreStrategy implements ScoreStrategy {

    @Override
    public void getChildAverageScore(final Child child) {
        Double sum = 0.0;
        for (Double score : child.getNiceScoreHistory()) {
            sum += score;
        }

        child.setAverageScore(sum / child.getNiceScoreHistory().size());
    }
}
