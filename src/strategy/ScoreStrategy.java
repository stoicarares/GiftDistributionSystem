package strategy;

import fileio.Child;

/**
 * Strategy design pattern for setting children average scores, depending on their age
 */
public interface ScoreStrategy {
    /**
     * Method that calculates the average score
     * @param child The child to calculate for
     */
    void getChildAverageScore(Child child);
}
