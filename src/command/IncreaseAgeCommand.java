package command;

import fileio.Child;
import database.Database;

/**
 * Command that increases the each child's age at the end of an year
 */
public final class IncreaseAgeCommand extends Command {
    @Override
    public void execute() {
        for (Child child : Database.getDatabase().getChildren()) {
            child.setAge(child.getAge() + 1);
        }
    }
}
