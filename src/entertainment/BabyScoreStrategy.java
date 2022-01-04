package entertainment;

public class BabyScoreStrategy implements ScoreStrategy {

    @Override
    public void getChildAverageScore(Child child) {
        child.setAverageScore(10.0);
    }
}
