package writer;

import fileio.Child;
import database.Database;
import enums.Category;
import fileio.InputGift;

import java.util.ArrayList;
import java.util.List;

public final class ChildrenOutput {
    private List<Child> children = new ArrayList<>();

    /**
     * Making deep copy on each child in the database for printing it in the output file
     */
    public void transferChildren() {
        for (Child child : Database.getDatabase().getChildren()) {
            Child newChild = new Child(child);

            List<InputGift> newInputGifts = new ArrayList<>();
            for (InputGift gift : child.getReceivedGifts()) {
                newInputGifts.add(new InputGift(gift));
            }
            newChild.setReceivedGifts(newInputGifts);

            List<Category> newCategories = new ArrayList<>(child.getGiftsPreferences());
            newChild.setGiftsPreferences(newCategories);

            List<Double> newNiceScores = new ArrayList<>(child.getNiceScoreHistory());
            newChild.setNiceScoreHistory(newNiceScores);

            this.children.add(newChild);
        }
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(final List<Child> children) {
        this.children = children;
    }
}
