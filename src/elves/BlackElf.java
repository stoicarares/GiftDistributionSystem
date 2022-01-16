package elves;

import common.Constants;
import database.Database;
import enums.ElvesType;
import fileio.Child;

public final class BlackElf extends ElfCommand {
    @Override
    public void execute() {
        for (Child child : Database.getDatabase().getChildren()) {
            if (child.getElf().equals(ElvesType.BLACK)) {
                double oldBudget = child.getAssignedBudget();
                double newBudget = oldBudget - oldBudget * Constants.THIRTY / Constants.HUNDRED;
                child.setAssignedBudget(newBudget);
            }
        }
    }
}
