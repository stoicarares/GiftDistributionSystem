package entertainment;

import common.Constants;

public class ScoreStrategyFactory {
    public ScoreStrategy createStrategy(Child child) {
        if (child.getAge() < 5) {
            return new BabyScoreStrategy();
        } else if (child.getAge() < 12) {
            return new KidScoreStrategy();
        } else if (child.getAge() < 18) {
            return new TeenScoreStrategy();
        }

        return new YoungAdultScoreStrategy();
    }
}