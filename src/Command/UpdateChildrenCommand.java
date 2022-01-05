package Command;

import Writer.ChildrenOutput;
import entertainment.Child;
import entertainment.Database;
import enums.Category;
import fileio.InputChildUpdate;
import fileio.InputGift;

import java.util.List;

public class UpdateChildrenCommand extends Command {
    private final List<InputChildUpdate> childrenUpdates;

    public UpdateChildrenCommand(List<InputChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    @Override
    public void execute() {
        for (InputChildUpdate inputChildUpdate : childrenUpdates) {
            Child child = Database.getDatabase().getChildById(inputChildUpdate.getId());
            if (child != null) {
                if (inputChildUpdate.getNiceScore() != null)
                    child.getNiceScoreHistory().add(inputChildUpdate.getNiceScore());
                if (inputChildUpdate.getGiftsPreferences() != null) {
                    for (Category category : inputChildUpdate.getGiftsPreferences()) {
                        child.getGiftsPreferences().remove(category);
                    }
                    child.getGiftsPreferences().addAll(0, inputChildUpdate.getGiftsPreferences());
                }
            }
        }
    }
}
