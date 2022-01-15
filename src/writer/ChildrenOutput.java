package writer;

import fileio.Child;
import database.Database;
import enums.Category;
import fileio.InputGift;

import java.util.ArrayList;
import java.util.List;

public final class ChildrenOutput {
    private List<OutputChild> children = new ArrayList<>();

    /**
     * Making deep copy on each child in the database for printing it in the output file
     */
    public void transferChildren() {
        for (Child child : Database.getDatabase().getChildren()) {
            OutputChild newChild = new OutputChild(child);

            List<OutputGift> newInputGifts = new ArrayList<>();
            for (InputGift gift : child.getReceivedGifts()) {
                newInputGifts.add(new OutputGift(gift));
            }
            newChild.setReceivedGifts(newInputGifts);

            List<Category> newCategories = new ArrayList<>(child.getGiftsPreferences());
            newChild.setGiftsPreferences(newCategories);

            List<Double> newNiceScores = new ArrayList<>(child.getNiceScoreHistory());
            newChild.setNiceScoreHistory(newNiceScores);

            this.children.add(newChild);
        }
    }

    public List<OutputChild> getChildren() {
        return children;
    }

    public void setChildren(final List<OutputChild> children) {
        this.children = children;
    }
}
