package command;

import common.Constants;
import fileio.Child;
import database.Database;
import fileio.InputChild;

import java.util.List;

/**
 * Command for adding new children to the database.
 */
public final class UpdateNewChildrenCommand extends Command {
    private List<InputChild> newChildren;

    public UpdateNewChildrenCommand(final List<InputChild> newChildren) {
        this.newChildren = newChildren;
    }

    public void setNewChildren(final List<InputChild> newChildren) {
        this.newChildren = newChildren;
    }

    @Override
    public void execute() {
        if (newChildren != null) {
            for (InputChild child : newChildren) {
                if (child.getAge() <= Constants.YOUNG_ADULT_AGE) {
                    Child newChild = new Child.Builder(child.getId(), child.getLastName(),
                            child.getFirstName(), child.getCity(), child.getAge(),
                            child.getNiceScore(), child.getGiftsPreferences(),
                            child.getElf()).niceScoreBonusCount(child.getNiceScoreBonus()).build();
                    Database.getDatabase().getChildren().add(newChild);
                }
            }
        }
    }
}
