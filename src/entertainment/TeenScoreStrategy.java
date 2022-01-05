package entertainment;

public class TeenScoreStrategy implements ScoreStrategy {

    @Override
    public void getChildAverageScore(Child child) {
        double sum = 0.0;
        for (int i = 0; i < child.getNiceScoreHistory().size(); i++) {
            sum += child.getNiceScoreHistory().get(i) * (i + 1);
        }

        int size = child.getNiceScoreHistory().size();
        child.setAverageScore(sum / ((size * (size + 1)) / 2));
    }
}