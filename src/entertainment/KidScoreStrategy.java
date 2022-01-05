package entertainment;

public class KidScoreStrategy implements ScoreStrategy {

    @Override
    public void getChildAverageScore(Child child) {
        Double sum = 0.0;
        for (Double score : child.getNiceScoreHistory()) {
            sum += score;
        }

        child.setAverageScore(sum / child.getNiceScoreHistory().size());
//        System.out.println(sum / child.getNiceScoreHistory().size());
    }

}

