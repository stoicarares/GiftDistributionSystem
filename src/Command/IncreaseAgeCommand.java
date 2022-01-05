package Command;

import entertainment.Child;
import entertainment.Database;

public class IncreaseAgeCommand extends Command {
    @Override
    public void execute() {
        for (Child child : Database.getDatabase().getChildren()) {
            child.setAge(child.getAge() + 1);
        }
    }
}