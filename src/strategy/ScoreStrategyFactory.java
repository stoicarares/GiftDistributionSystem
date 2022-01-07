package strategy;

import common.Constants;
import fileio.Child;

/**
 * Factory and Strategy design patterns combined
 */
public final class ScoreStrategyFactory {
    /**
     * Method for making the correct instance of the strategy.
     * @param child Child to apply strategy on.
     * @return The correct instance of the strategy depending on child's age.
     */
    public ScoreStrategy createStrategy(final Child child) {
        if (child.getAge() < Constants.KID_AGE) {
            return new BabyScoreStrategy();
        } else if (child.getAge() < Constants.TEEN_AGE) {
            return new KidScoreStrategy();
        } else if (child.getAge() <= Constants.YOUNG_ADULT_AGE) {
            return new TeenScoreStrategy();
        }

        return new YoungAdultScoreStrategy();
    }
}
