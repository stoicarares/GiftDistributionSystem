package elves;

import database.Database;
import enums.ElvesType;
import fileio.Child;

public class PinkElf extends Command {
    @Override
    public void execute() {
        for (Child child : Database.getDatabase().getChildren()) {
            if (child.getElf().equals(ElvesType.PINK)) {
                double oldBudget = child.getAssignedBudget();
                double newBudget = oldBudget + oldBudget * 30 / 100;
                child.setAssignedBudget(newBudget);
            }
        }
    }
}
