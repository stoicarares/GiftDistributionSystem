package Command;

import entertainment.Child;
import entertainment.Database;

public class SetAssignedBudgetCommand implements Command {
    public double getTotalScore() {
        double sum = 0.0;
        for (Child child:Database.getDatabase().getChildren()) {
            sum += child.getAverageScore();
        }

        return sum;
    }

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
