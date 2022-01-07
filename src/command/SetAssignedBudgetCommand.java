package command;

import common.Constants;
import fileio.Child;
import database.Database;

/**
 * Command for setting each child's allocated budget
 */
public final class SetAssignedBudgetCommand extends Command {
    /**
     * Adds all the children's average scores
     * @return The sum resulted
     */
    public double getTotalScore() {
        double sum = 0.0;
        for (Child child:Database.getDatabase().getChildren()) {
            if (child.getAge() <= Constants.YOUNG_ADULT_AGE) {
                sum += child.getAverageScore();
            }
        }

        return sum;
    }

    /**
     * Calculates the budget unit
     * @return A double value, meaning the budget unit
     */
    public double getBudgetUnit() {
        return Database.getSantaBudget() / this.getTotalScore();
    }

    @Override
    public void execute() {
        for (Child child:Database.getDatabase().getChildren()) {
            child.setAssignedBudget(this.getBudgetUnit() * child.getAverageScore());
        }
    }
}
