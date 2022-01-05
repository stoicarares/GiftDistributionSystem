package writer;

import entertainment.Child;
import entertainment.Database;
import fileio.InputGift;

import java.util.ArrayList;
import java.util.List;

public class ChildrenOutput {
    private List<Child> children = new ArrayList<>();

    public void transferChildren() {
        for (Child child : Database.getDatabase().getChildren()) {
            Child newChild = new Child(child);

            List<InputGift> newInputGifts = new ArrayList<>();
            for (InputGift gift : child.getReceivedGifts()) {
                newInputGifts.add(new InputGift(gift));
            }
            newChild.setReceivedGifts(newInputGifts);

            List<Double> newNiceScores = new ArrayList<>(child.getNiceScoreHistory());
            newChild.setNiceScoreHistory(newNiceScores);

            this.children.add(newChild);
        }
    }

    public List<Child> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "{" +
                "children=" + children +
                '}';
    }
}