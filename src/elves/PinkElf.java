package elves;

import database.Database;
import common.Constants;
import enums.ElvesType;
import fileio.Child;

public final class PinkElf extends ElfCommand {
    @Override
    public void execute() {
        for (Child child : Database.getDatabase().getChildren()) {
            if (child.getElf().equals(ElvesType.PINK)) {
                double oldBudget = child.getAssignedBudget();
                double newBudget = oldBudget + oldBudget * Constants.THIRTY / Constants.HUNDRED;
                child.setAssignedBudget(newBudget);
            }
        }
    }
}
