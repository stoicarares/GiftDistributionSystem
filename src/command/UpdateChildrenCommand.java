package command;

import fileio.Child;
import database.Database;
import enums.Category;
import fileio.InputChildUpdate;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * Command for updating children profiles.
 */
public final class UpdateChildrenCommand extends Command {
    private final List<InputChildUpdate> childrenUpdates;

    public UpdateChildrenCommand(final List<InputChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
    @Override
    public void execute() {
        for (InputChildUpdate inputChildUpdate : childrenUpdates) {
            Child child = Database.getDatabase().getChildById(inputChildUpdate.getId());
            if (child != null) {
                if (inputChildUpdate.getNiceScore() != null) {
                    child.getNiceScoreHistory().add(inputChildUpdate.getNiceScore());
                }
                if (inputChildUpdate.getGiftsPreferences() != null) {
                    for (Category category : inputChildUpdate.getGiftsPreferences()) {
                        child.getGiftsPreferences().remove(category);
                    }
                    LinkedHashSet<Category> hs = new LinkedHashSet<>(inputChildUpdate
                                                                    .getGiftsPreferences());
                    child.getGiftsPreferences().addAll(0, hs);
                }
            }
        }
    }
}
