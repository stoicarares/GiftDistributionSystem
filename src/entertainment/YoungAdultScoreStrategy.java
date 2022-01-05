package entertainment;

public class YoungAdultScoreStrategy implements ScoreStrategy {
    @Override
    public void getChildAverageScore(Child child) {
        child.setAverageScore(child.getAverageScore());
    }
}
